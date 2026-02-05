package se.jimmy.iths.labjavaverktygbyggmiljoer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.jimmy.iths.labjavaverktygbyggmiljoer.service.ATMService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/atm")
public class ATMController {
    private final ATMService atmService;

    @GetMapping
    public String getBalance(Model model) {
        model.addAttribute("balance", atmService.getBalance());
        return "atm";
    }

}
