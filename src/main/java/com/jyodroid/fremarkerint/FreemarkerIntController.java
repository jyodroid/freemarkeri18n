package com.jyodroid.fremarkerint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FreemarkerIntController {
    @GetMapping("/international")
    public String getInternationalPage(){
        return "international";
    }

    @GetMapping("/international/hardcoded")
    public String getInternationalHardcodedPage(){
        return "international_hc";
    }
}
