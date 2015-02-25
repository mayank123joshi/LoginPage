package com.trunk.controller;

import com.trunk.controller.Login;

import org.apache.log4j.Logger; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class UserController {
    
    private static final Logger logger = Logger.getLogger(UserController.class);
 
    /**
     * Saves the static list of users in model and renders it 
     * via freemarker template.
     * 
     * @param model 
     * @return The index view (FTL)
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(@ModelAttribute("model") ModelMap model) {
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("model") ModelMap model) {
    	model.addAttribute("user", new Login());
    	return "login";
    }
    
    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public String success(@ModelAttribute("user") Login user, ModelMap model) {
    	 model.addAttribute("user", user.getUsername());
         model.addAttribute("pass", user.getPassword());
         model.addAttribute("auth", user.isAuthenticated());
         logger.info("Username" + user.getUsername());
         logger.info("Password" + user.getPassword());
         logger.info("Auth status" + user.isAuthenticated());
         
         if(user.getUsername().equals("mayank") && "password".equals(user.getPassword()))
        	 user.setIsAuthenticated(true);
         
         logger.info("Auth status" + user.isAuthenticated());
	     if(user.isAuthenticated())
	    	 return "success";
	     else
	    	 return "redirect:login.html";
    }
}
