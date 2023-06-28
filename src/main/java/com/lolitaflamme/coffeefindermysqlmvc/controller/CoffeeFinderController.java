package com.lolitaflamme.coffeefindermysqlmvc.controller;

import com.lolitaflamme.coffeefindermysqlmvc.repository.CoffeeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CoffeeFinderController {

    @NonNull
    private final CoffeeRepository coffeeRepository;

    @GetMapping("/coffees")
    private String findCoffees(Model model) {
        model.addAttribute("coffeesBySupplier", coffeeRepository.findAll());
        return "coffees";
    }
}
