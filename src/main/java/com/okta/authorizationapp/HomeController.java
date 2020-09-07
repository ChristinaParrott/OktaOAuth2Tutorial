package com.okta.authorizationapp;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author chipp
 */
@Controller
public class HomeController {
    
    @RequestMapping("/home")
    public String getCurrentUser(Model model,
                              @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                              @AuthenticationPrincipal OAuth2User oauth2User){
        
        model.addAttribute("userName", oauth2User.getName());
        model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
        model.addAttribute("userAttributes", oauth2User.getAttributes());
        
        return "home";
    }
    
    //Index
    @RequestMapping("/")
    public String index(Model model, Principal principal){
        return "index";
    }
    
    /*
    //Login form
    @RequestMapping("/login.html")
    public String login(){
        return "login.html";
    }
    
    //Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login.html";
    }
*/
    
}
