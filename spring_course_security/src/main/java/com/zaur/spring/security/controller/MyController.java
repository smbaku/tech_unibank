package com.zaur.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAllEmpl() {
        return "view_for_all_employees";
    }


    @GetMapping("/hr_info")
    public String getHr_info() {
        return "view_for_hr";
    }

    @GetMapping("/manager_info")
    public String gtManager_info() {
        return "view_for_manager";
    }


}
