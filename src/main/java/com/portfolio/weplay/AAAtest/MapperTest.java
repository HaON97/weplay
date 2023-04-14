package com.portfolio.weplay.AAAtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : HaON
 * @Comment : DB연결 테스트
 * */
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
