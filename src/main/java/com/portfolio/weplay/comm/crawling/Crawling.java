package com.portfolio.weplay.comm.crawling;

import lombok.extern.slf4j.XSlf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.List;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/crawl")
public class Crawling {

    WebDriver driver;
    String url = "https://timeline.onstove.com/159967896"; // 009d23204d787121ccfbc08cddb7f78c

    @RequestMapping(value = "/getCertifiedCode")
    public String Crawling(){
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

        //셀레니움을 이용한 동적 크롤링
        // 크롬 드라이버가 설치된 주소
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\smt\\Desktop\\프로젝트\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");          // 최대크기로
        options.addArguments("--headless");                 // Browser를 띄우지 않음
        options.addArguments("--disable-gpu");              // GPU를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
        options.addArguments("--no-sandbox");               // Sandbox 프로세스를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.

        // 드라이버 객체 생성
        driver = new ChromeDriver(options);
        
        // 웹페이지 호출
        driver.get(url);
        String certifiedCode = "";
        try{

            // 로드될때까지 대기 3초
            // 대기 안할경우 알수없음의 페이지 나옴 주의!!
            Thread.sleep(3000);
            
            // 페이지 소스를 가져오는 코드
            List<WebElement> elementList = driver.findElements(By.className("section-body"));

            // 인증키는 리스트중 3번째에 있다
            certifiedCode = elementList.get(2).getText();

        } catch(Exception e){
            System.out.println(e);
        }

        return certifiedCode;
    }

}
