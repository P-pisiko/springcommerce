package dev.commerse.controllers;

import dev.commerse.database.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Autowired
    DatabaseAccess db;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("itemList", db.getItemsList());
        return "landingPage";
    }




    /*
   @PostMapping("/api/login")
        public String loginPost(@ModelAttribute("loginForm") Customer customer, Model model)  {
        System.out.println(customer.toString());
        model.addAttribute("username", customer.getUsername());
        return "/landingPage";
    }
    */
}
