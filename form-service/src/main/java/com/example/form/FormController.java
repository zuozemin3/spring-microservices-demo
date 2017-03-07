package com.example.form;

import com.example.form.domain.Form;
import com.example.form.service.impl.FormServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class FormController {
    private static final Logger LOG = LoggerFactory.getLogger(FormController.class);

    @Autowired
    private Config config;

    @Autowired
    private FormServiceImpl formService;

    @RequestMapping("/dburl")
    @ResponseBody
    String home() {
        return config.getDbUrl();
    }

    @RequestMapping(value = "/forms/{userId}", method = RequestMethod.GET)
    @ResponseBody
    List<Form> findFormsByUserId(@PathVariable String userId) {
        LOG.info("start to find");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return formService.findByUserIdAndStatus(Long.valueOf(userId)).stream().map(formUserDTO -> formUserDTO.getForm()).collect
                (Collectors.toList());
    }
}
