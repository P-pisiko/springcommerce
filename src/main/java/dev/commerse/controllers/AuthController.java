package dev.commerse.controllers;

import dev.commerse.database.CustomerRepository;
import dev.commerse.models.NewCustomerRequestDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/auth/login")
    public String login() {
        return "login";
    }

    @GetMapping("/auth/signup")
    public String signup(Model model) {
        model.addAttribute("customer", new NewCustomerRequestDTO());
        return "signup";
    }

    @PostMapping("/auth/signup")
    public String register(@Validated @ModelAttribute("customer") NewCustomerRequestDTO registerForm , BindingResult bindingResult ) {

        if (!bindingResult.hasErrors()) {
            logger.warn("Binding has no errors");
            if (registerForm.getPassword().equals(registerForm.getConfirm())) { //Password confirmation
                logger.warn("Password does match up");
                customerRepository.registerNewCustomer(registerForm.getUsername(), registerForm.getPassword());
                return "redirect:/auth/login";
            }
        }

        return "signup";

    }
}
