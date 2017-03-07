package com.example.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MedicalController {

    @Autowired
    private Config config;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return config.getDbUrl();
    }
}
