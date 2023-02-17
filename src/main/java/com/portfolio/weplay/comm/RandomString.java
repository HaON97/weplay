package com.portfolio.weplay.comm;

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
import java.util.Random;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(value = "/api")
public class RandomString {

    private ResponseEntity<CustomResponseEntity> rec;
    private CustomResponseEntity cre;
    private HttpHeaders header;

    @RequestMapping(method = RequestMethod.POST, value="/getApiKey")
    public ResponseEntity<CustomResponseEntity> createRandomStrUsingRandomBoolean() {
        Random random = new Random();
        StringBuffer randomBuf = new StringBuffer();
        for (int i = 0; i < 20; i++) {
            // Random.nextBoolean() : 랜덤으로 true, false 리턴 (true : 랜덤 소문자 영어, false : 랜덤 숫자)
            if (random.nextBoolean()) {
                // 26 : a-z 알파벳 개수
                // 97 : letter 'a' 아스키코드
                // (int)(random.nextInt(26)) + 97 : 랜덤 소문자 아스키코드
                randomBuf.append((char)((int)(random.nextInt(26)) + 97));
            } else {
                randomBuf.append(random.nextInt(10));
            }
        }
        String randomStr = randomBuf.toString();
        System.out.println("[createRandomStrUsingRandomBoolean] randomStr : " + randomStr);

        Map<String, Object> data = new HashMap<String, Object>();
        cre = new CustomResponseEntity();
        if(randomStr.length() == 20 || !(randomStr.equals(""))){
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

        header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        rec = new ResponseEntity<CustomResponseEntity>(cre, header, HttpStatus.OK);

        return rec;
    }
}
