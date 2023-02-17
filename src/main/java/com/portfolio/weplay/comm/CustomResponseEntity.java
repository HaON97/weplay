package com.portfolio.weplay.comm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomResponseEntity {

    private String status;
    private Object data;
    private String message;

}
