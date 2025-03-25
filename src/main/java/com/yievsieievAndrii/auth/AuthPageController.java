package com.yievsieievAndrii.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yievsieievAndrii.user.User;

/**
 * AuthPageController
 */
@Controller
public class AuthPageController {

  @Autowired
  private AuthService authService;

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/register")
  public String showRegistrationForm() {
    return "register";
  }

  @PostMapping("/register")
  public String registerUser(User user, Model model) {

    try {
      authService.registerUser(user);
      return "redirect:/login";
    } catch (RuntimeException e) {
      model.addAttribute("error", e.getMessage());
      return "register"; 
    }
  }
}
