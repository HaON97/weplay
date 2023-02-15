package com.portfolio.weplay.comm.crawling;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

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
        /*String url = "https://lostark.game.onstove.com/boayesrd/IsCharacterList?memberNo=159967896";
        String docString = "";
        try{
            Document doc = SSLHelper.getConnection(url).ignoreContentType(true).ignoreHttpErrors(true).post();
            docString = doc.toString();
            System.out.println(doc);
        } catch(Exception e) {
            System.out.println(e.toString());
        }*/

//        Object object =  webClient.post()         // POST method
//                .uri("/board/IsCharacterList?memberNo=159967896")    // baseUrl 이후 uri
//                .bodyValue(bodyEmpInfo)     // set body value
//                .retrieve()                 // client message 전송
//                .bodyToMono()  // body type : EmpInfo
//                .block();



        return pkey;
    }

}