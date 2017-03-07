package com.example.medical.client;

import com.example.medical.client.domain.Form;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "form-service", fallbackFactory = FormFeignClientFallbackFactory.class)
public interface FormFeignClient {
    @RequestMapping(value = "/forms/{userId}", method = RequestMethod.GET)
    List<Form> findFormsByUserId(@PathVariable("userId") String userId);
}


@Component
class FormFeignClientFallbackFactory implements FallbackFactory<FormFeignClient> {

    @Override
    public FormFeignClient create(Throwable throwable) {
        return new FormFeignClient() {
            @Override
            public List<Form> findFormsByUserId(@PathVariable("userId") String userId) {
                return new ArrayList<>();
            }
        };
    }
}
