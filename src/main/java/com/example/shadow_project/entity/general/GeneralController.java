package com.example.shadow_project.entity.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GeneralController {
    @Autowired
    GeneralService generalService;
    @GetMapping("/search/{input}")
    public Map<String, List<Object>> getAllSearch(@PathVariable("input") String input){
        Map<String,List<Object>> map=this.generalService.searchAll(input);
        return map;
    }
}

