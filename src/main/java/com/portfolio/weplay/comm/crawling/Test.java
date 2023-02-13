package com.portfolio.weplay.comm.crawling;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/test")
public class Test {
    String url = "https://timeline.onstove.com/159967896"; // 009d23204d787121ccfbc08cddb7f78c
    String url2 = "https://lostark.game.onestove.com/board/IsCharacterList?memberNo=160997106";

    @RequestMapping(method = RequestMethod.POST, path = "/testMethod")
    public String test(@RequestBody String pkey){
        String result = "haha";

        System.out.println(result);
        System.out.println(pkey);

        return result;
    }

}