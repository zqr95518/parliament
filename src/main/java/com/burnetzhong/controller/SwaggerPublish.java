package com.burnetzhong.controller;

import com.burnetzhong.domain.Swagger;
import com.burnetzhong.repo.SwaggerDocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Project: zhcore
 *
 * @Comments
 * @Author Zhong Han
 * @Created Date 2017/4/5
 */
@RestController
@RequestMapping(path = "/swagger")
public class SwaggerPublish {

    @Autowired
    private SwaggerDocRepo swaggerDocRepo;

    @GetMapping("")
    public String helloWorld() {
        return "Hello World!";
    }

    @PostMapping(path = "/publish", consumes = "application/json;charset=utf-8")
    public void publish(@RequestBody Swagger swagger) {
        Swagger original = swaggerDocRepo.findByInfo_Title(swagger.getInfo().getTitle());

        // MongoDB docs cannot contain "$" when update, so we must delete old one and save the new one.
        if (original != null) {
            swaggerDocRepo.delete(original);
        }
        swaggerDocRepo.save(swagger);
    }
}
