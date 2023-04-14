package com.portfolio.weplay.comm.func;

import com.portfolio.weplay.comm.vo.CustomResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Random;

/**
 * @Author : HaON
 * @Comment : 랜덤 문자열 관련 함수 모음 클래스
 * */
public class RandomString {

    private ResponseEntity<CustomResponseEntity> rec;
    private CustomResponseEntity cre;
    private HttpHeaders header;

    /**
     * @Author : HaON
     * @Comment : 알파벳 + 숫자로 이루어진 20자리 랜덤 문자열 생성
     * */
    public String MakeUUID() {
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

        return randomStr;
    }
}
