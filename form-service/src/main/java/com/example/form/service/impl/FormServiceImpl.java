package com.example.form.service.impl;


import com.example.form.dao.FormRepository;
import com.example.form.dao.FormUserRepository;
import com.example.form.domain.FormUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl {

    private static final Logger log = LoggerFactory.getLogger(FormServiceImpl.class);

    @Autowired
    private FormRepository formRepository;
    @Autowired
    private FormUserRepository formUserRepository;

    public List<FormUser> findByUserIdAndStatus(Long userId) {
        return formUserRepository.findByUserIdAndStatus(userId, FormUser.Status.NORMAL.getValue());
    }
}
