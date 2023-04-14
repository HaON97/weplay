package com.portfolio.weplay.comm.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * @Author : HaON
 * @Comment : 서버 리턴값을 담기 위한 객체
 * */
@Getter
@Setter
@ToString
public class CustomResponseEntity {

    private String status;
    private Object data;
    private String message;

}
