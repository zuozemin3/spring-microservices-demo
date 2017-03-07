package com.example.medical.controller;

import com.example.medical.client.FormFeignClient;
import com.example.medical.client.domain.Form;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MedicalController {
    private static final Logger LOG = LoggerFactory.getLogger(MedicalController.class);

    @Autowired
    private FormFeignClient formFeignClient;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "hello";
    }

    @RequestMapping("/forms")
    @ResponseBody
    List<Form> findFormsByUserId() {
        LOG.info("findFormsByUserId");
        return formFeignClient.findFormsByUserId("588666");
    }
}
