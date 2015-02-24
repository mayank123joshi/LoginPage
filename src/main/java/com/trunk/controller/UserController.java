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
    	Login user = new Login();
//    	model.put("login", user);
    	return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") Login user) {
	    if(null != user && null != user.getUsername()
	            && null != user.getPassword())
			return "success";
		else
			return "login.html";
    }  
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(@ModelAttribute("user") Login user) {
    	if(user.isAuthenticated())
    		return "success";
    	else
    		return "redirect:index.html";
    }
}
