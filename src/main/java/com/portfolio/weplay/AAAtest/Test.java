package com.portfolio.weplay.AAAtest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

/**
 * @Author : HaON
 * @Comment : 리엑트와의 통신과 메소드 테스트를 위한 클래스
 * */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/test")
public class Test {
    //String url = "https://timeline.onstove.com/159967896"; // 009d23204d787121ccfbc08cddb7f78c
    String url2 = "https://lostark.game.onstove.com/board/IsCharacterList?memberNo=159967896";

    private WebClient webClient = WebClient.builder()
            .baseUrl("https://lostark.game.onstove.com")
            .build();
    @RequestMapping(method = RequestMethod.POST, value = "/testMethod")
    public String test(@RequestBody String pkey) throws IOException {
        System.out.println(pkey);

        //JSOUP를 이용한 정적 크롤링
        /*
        //크롬 버전 109.0.5414.120
        String url = "https://timeline.onstove.com/159967896";
        String docString = "";
        try{
            //하단의 코드는 SSL 적용된 사이트의 값을 가져올때 사용
            //Document doc = SSLHelper.getConnection(url).ignoreContentType(true).ignoreHttpErrors(true).post();
            Document doc = Jsoup.connect(url).get();
            docString = doc.toString();
            System.out.println(docString);
        } catch(Exception e){
            System.out.println(e.toString());
        }
        */

        /*String url = "https://lostark.game.onstove.com/boayesrd/IsCharacterList?memberNo=159967896";
        String docString = "";
        try{
            Document doc = SSLHelper.getConnection(url).ignoreContentType(true).ignoreHttpErrors(true).post();
            docString = doc.toString();
            System.out.println(doc);
        } catch(Exception e) {
            System.out.println(e.toString());
        }*/

        /*Object object =  webClient.post()         // POST method
                .uri("/board/IsCharacterList?memberNo=159967896")    // baseUrl 이후 uri
                .bodyValue(bodyEmpInfo)     // set body value
                .retrieve()                 // client message 전송
                .bodyToMono()  // body type : EmpInfo
                .block();*/



        return pkey;
    }

}