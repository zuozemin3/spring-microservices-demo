package com.example.form.dao;

import com.example.form.domain.Form;
import com.example.form.domain.FormUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FormUserRepository extends PagingAndSortingRepository<FormUser, Long> {
    List<FormUser> findByFormAndStatus(Form form, Integer status);

    FormUser findTopByFormAndUserId(Form form, Long userId);

    List<FormUser> findByUserIdAndStatus(Long userId, Integer status);

    List<FormUser> findByUserIdInAndStatus(List<Long> userIds, Integer status, Pageable pageable);
}
