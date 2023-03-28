package com.portfolio.weplay.comm.validation;

import com.portfolio.weplay.comm.CustomResponseEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api")
public class LoginValidation {
    //String url = "https://timeline.onstove.com/159967896"; // 009d23204d787121ccfbc08cddb7f78c
    private WebDriver driver;
    private CustomResponseEntity cre;
    private HttpHeaders header;

    @RequestMapping(method = RequestMethod.POST, value = "/login/validation")
    public ResponseEntity<CustomResponseEntity> Crawling(@RequestBody Map<String,String> param){
        String userURL = param.get("userURL");
        String userApiKey = param.get("userApiKey");
        String userMainChar = param.get("userMainChar");
        String userCode = userURL.split("/")[3];

        //셀레니움을 이용한 동적 크롤링
        // 크롬 드라이버가 설치된 주소
        // 반영시 경로 수정 필수!!!!! (FINAL CHECK)
        System.setProperty("webdriver.chrome.driver", "/Users/kj/Downloads/chromedriver_mac64/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");          // 최대크기로
        options.addArguments("--headless");                 // Browser를 띄우지 않음
        options.addArguments("--disable-gpu");              // GPU를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
        options.addArguments("--no-sandbox");               // Sandbox 프로세스를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.

        // 드라이버 객체 생성
        driver = new ChromeDriver(options);
        
        // 웹페이지 호출
        driver.get(userURL);
        String certifiedCode = "";
        try{

            // 로드될때까지 대기 3초
            // 대기 안할경우 알수없음의 페이지 나옴 주의!!
            Thread.sleep(3000);
            
            // 페이지 소스를 가져오는 코드
            List<WebElement> elementList = driver.findElements(By.className("section-body"));

            // 인증키는 리스트중 2번째에 있다
            certifiedCode = elementList.get(1).getText();
            
            // Test용
            userApiKey = certifiedCode;

        } catch(Exception e){
            System.out.println(e);
        }

        cre = new CustomResponseEntity();
        header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> data = new HashMap<String, Object>();

        if(certifiedCode.equals(userApiKey)){
            String getMainChar = new GetCharacterList().IsCharacterList(userCode);
            if(getMainChar.equals(userMainChar)){
                data.put("result", "SUCCESS");
                cre.setStatus("200");
                cre.setData(data);
                cre.setMessage("인증이 완료되었습니다.");
            } else {
                data.put("result", "FAIL");
                cre.setStatus("200");
                cre.setData(data);
                cre.setMessage("대표캐릭터가 일치하지 않습니다. 대표캐릭터를 입력해주세요.");
            }
        } else {
            data.put("result", "FAIL");
            cre.setStatus("200");
            cre.setData(data);
            cre.setMessage("인증키가 일치하지 않습니다.");
        }

        return new ResponseEntity<>(cre, header, HttpStatus.OK);
    }

}
