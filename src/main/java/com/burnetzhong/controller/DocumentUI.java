package com.burnetzhong.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.burnetzhong.repo.SwaggerDocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Project: zhcore
 *
 * @Created Date 2017/4/6
 * @Updated Date 2019/12/2
 */

@RestController
@RequestMapping(path = "/api")
public class DocumentUI {

    @Autowired
    private SwaggerDocRepo swaggerDocRepo;

    @GetMapping("")
    public String getSwaggers() {
        return JSON.toJSONString(swaggerDocRepo.findAll(), (PropertyFilter) (object, name, value) -> !("definitions".equals(name) || "paths".equals(name)));
    }

    @GetMapping("/{id}")
    public String getByBasePath(@PathVariable String id) {
        return JSON.toJSONString(swaggerDocRepo.findById(id), (PropertyFilter) (object, name, value) -> !(value == null || value.equals(new HashMap<>()) || value.equals(new ArrayList<>()) || value.equals("") || value.equals("null")), SerializerFeature.DisableCircularReferenceDetect);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        swaggerDocRepo.deleteById(id);
        return "Success";
    }
}
