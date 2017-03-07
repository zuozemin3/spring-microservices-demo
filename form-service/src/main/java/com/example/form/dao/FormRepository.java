package com.example.form.dao;

import com.example.form.domain.Form;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FormRepository extends CrudRepository<Form, Long> {
    List<Form> findByStatusOrderByUpdateTimeDesc(Integer status);
}
