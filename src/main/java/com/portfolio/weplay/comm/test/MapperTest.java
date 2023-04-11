package com.portfolio.weplay.comm.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/mapper")
public class MapperTest {

    @Autowired
    private MapperTest2 map2;
    @RequestMapping(method = RequestMethod.POST ,value = "/test")
    public void mapperTest(){
        System.out.println(map2.mapper1());
    }
}
