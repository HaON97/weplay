package com.portfolio.weplay.AAAtest;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;
/**
 * @Author : HaON
 * @Comment : DB Mapper 테스트
 * */
@Mapper
@Alias("TestMapper")
public interface MapperTest2 {

    public Integer mapper1();

}
