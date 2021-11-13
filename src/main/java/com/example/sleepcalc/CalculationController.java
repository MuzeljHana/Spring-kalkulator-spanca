package com.example.sleepcalc;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CalculationController {

    @GetMapping("/wakeup/{wakeup}")
    public Calculation getSleeptime(@PathVariable @DateTimeFormat(pattern = "kkmm") Date wakeup) {
        Calculation calc = new Calculation();
        calc.calculateSleepTime(wakeup);
        return calc;
    }
}
