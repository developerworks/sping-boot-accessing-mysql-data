package cn.totorotec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping(path = "/")
    public Map<String, Object> index() {
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "hello world");

        return result;
    }
}
