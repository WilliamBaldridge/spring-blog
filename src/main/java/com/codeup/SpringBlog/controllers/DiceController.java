package com.codeup.SpringBlog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String showDicePage() {

        return "/roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String diceRoll(@RequestParam(name = "dice") String dice, @PathVariable double n, Model model) {

        Random random = new Random();
        n = random.nextInt(6) + 1;



        model.addAttribute("dice", "Your guess is: " + dice + " and the result was: " + n);
        return "roll-dice";
    }



}
