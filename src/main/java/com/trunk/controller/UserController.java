package com.trunk.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class UserController {
    /**
     * Static list of users to simulate Database
     */
    private static List<User> userList = new ArrayList<User>();
 
    //Initialize the list with some data for index screen
    static {
        userList.add(new User("Mayank", "Joshi"));
        userList.add(new User("Sandeep", "Kumar"));
        userList.add(new User("Shyam", "Dubey"));
        userList.add(new User("Sumit", "Kapoor"));
        userList.add(new User("Gupreet", "Singh"));
    }

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
 
        model.addAttribute("userList", userList);
 
        return "index";
    }
 
    /**
     * Add a new user into static user lists and display the 
     * same into FTL via redirect 
     * 
     * @param user
     * @return Redirect to /index page to display user list
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("user") User user) {
 
        if (null != user && null != user.getFirstname()
                && null != user.getLastname() && !user.getFirstname().isEmpty()
                && !user.getLastname().isEmpty()) {
 
            synchronized (userList) {
                userList.add(user);
                logger.debug("Added to list : {" + user.getFirstname() +", "+user.getLastname()+"}");
            }
 
        }
 
        return "redirect:index.html";
    }
 
}
