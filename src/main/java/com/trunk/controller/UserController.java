package com.trunk.controller;

import java.io.IOException;

import com.trunk.controller.Login;

import org.apache.log4j.Logger; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {
    
    private static final Logger logger = Logger.getLogger(UserController.class);
    
    private static final String LOGIN_PAGE = "/login";
    private static final String INDEX_PAGE = "/index";
    private static final String SUCCESS_PAGE = "/success";
 
    /**
     * Saves the static list of users in model and renders it 
     * via freemarker template.
     * 
     * @param model 
     * @return The index view (FTL)
     */
    @RequestMapping(value = INDEX_PAGE, method = RequestMethod.GET)
    public String index(@ModelAttribute("model") ModelMap model) {
        return "index";
    }
    
    @RequestMapping(value = LOGIN_PAGE, method = RequestMethod.GET)
    public String login(@ModelAttribute("model") ModelMap model) {
    	model.addAttribute("user", new Login());
    	return "login";
    }
    
    @RequestMapping(value = SUCCESS_PAGE, method = RequestMethod.POST)
    public String success(@ModelAttribute("user") Login user, ModelMap model, HttpServletRequest request, HttpServletResponse response, BindingResult bindingresult,HttpSession session) throws ServletException, IOException{
         myServiceMethodSettingCookie(request, response);        //Do service call passing the response
    	 model.addAttribute("user", user.getUsername());
         model.addAttribute("pass", user.getPassword());
         model.addAttribute("auth", user.isAuthenticated());
         logger.info("Username" + user.getUsername());
         logger.info("Password" + user.getPassword());
         logger.info("Auth status" + user.isAuthenticated());
         
         if(user.getUsername().equals("mayank") && user.getPassword().equals("password"))
        	 user.setIsAuthenticated(true);
         
         logger.info("Auth status" + user.isAuthenticated());
	     if(user.isAuthenticated())
	    	 return "success";
	     else{
	         model.addAttribute("error", "Incorrect Username or Password");
	    	 return "login";
	     }
    }
    
    @RequestMapping(value = SUCCESS_PAGE, method = RequestMethod.GET)
    public String successGet(@ModelAttribute("user") Login user, ModelMap model) {
    	if(user.isAuthenticated()){
    			RestTemplate restTemplate = new RestTemplate();
    			ResponseEntity<String> restResponse = restTemplate.getForEntity(
    	        "https://data.sparkfun.com/streams/dZ4EVmE8yGCRGx5XRX1W.json",
    	        String.class);

    			logger.info(restResponse);
    			return "success";
    	} else
	    	 return "unauthorized";
    }
    
    
    public void myServiceMethodSettingCookie(HttpServletRequest request, HttpServletResponse response) {
        final String cookieName = "testcookie";
        final String cookieValue = "my cool value here !";  // you could assign it some encoded value
        final Boolean useSecureCookie = new Boolean(false);
        final int expiryTime = 60 * 60 * 24;  // 24h in seconds
        final String cookiePath = "/";

        HttpSession session = request.getSession(true);
        session.setAttribute("hello", "world");

        Cookie myCookie = new Cookie(cookieName, cookieValue);
        myCookie.setSecure(useSecureCookie.booleanValue());  // determines whether the cookie should only be sent using a secure protocol, such as HTTPS or SSL
        myCookie.setMaxAge(expiryTime);  // A negative value means that the cookie is not stored persistently and will be deleted when the Web browser exits. A zero value causes the cookie to be deleted.
        myCookie.setPath(cookiePath);  // The cookie is visible to all the pages in the directory you specify, and all the pages in that directory's subdirectories

        response.addCookie(myCookie);
    }
}
