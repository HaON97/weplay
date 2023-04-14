package com.portfolio.weplay.comm.validation;

import com.portfolio.weplay.comm.func.RandomString;
import com.portfolio.weplay.comm.vo.CustomResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
/**
 * @Author : HaON
 * @Comment : 회원가입 시 인증키 관련 클래스
 * */
@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(value = "/api")
public class GetApiKey {

    private ResponseEntity<CustomResponseEntity> rec;
    private CustomResponseEntity cre;
    private HttpHeaders header;

    /**
     * @Author : HaON
     * @Comment : 회원가입 시 인증키 발급 메소드
     * */
    @RequestMapping(method = RequestMethod.POST, value="/createApiKey")
    public ResponseEntity<CustomResponseEntity> createRandomStrUsingRandomBoolean() {

        RandomString rs = new RandomString();

        String randomStr = rs.MakeUUID();

        Map<String, Object> data = new HashMap<String, Object>();
        cre = new CustomResponseEntity();

        if(randomStr != null || !randomStr.equals("")){
            if(randomStr.length() == 20){
                data.put("apiKey", randomStr);
                data.put("result", "SUCCESS");
                cre.setStatus("200");
                cre.setData(data);
                cre.setMessage("키발급이 정상적으로 이루어졌습니다.");
            } else {
                data.put("result", "SUCCESS");
                cre.setStatus("200");
                cre.setData(data);
                cre.setMessage("키발급에 실패하였습니다.");
            }
        } else {
            data.put("result", "SUCCESS");
            cre.setStatus("200");
            cre.setData(data);
            cre.setMessage("키발급에 실패하였습니다.");
        }


        header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        rec = new ResponseEntity<CustomResponseEntity>(cre, header, HttpStatus.OK);

        return rec;
    }
}
