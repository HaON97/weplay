package com.portfolio.weplay.comm.validation;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class GetCharacterList {

    private static final String URL = "https://lostark.game.onstove.com/board/IsCharacterList";
    private static final String URL2 = "https://lostark.game.onstove.com/Profile/Member?id=";
    private static final String USER_AGENT = "Mozilla/5.0";

    public String IsCharacterList(String memberNo){
        StringBuffer stringBuffer = new StringBuffer();
        try {
            URL url = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //HttpURLConnection을 이용한 POST 통신
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setDoOutput(true);

            //멤버 아이디
            String jsonInputString = "{\"memberNo\": \""+memberNo+"\"}";
            OutputStream os = connection.getOutputStream();
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = bufferedReader.readLine()) != null)  {
                stringBuffer.append(inputLine);
            }
            bufferedReader.close();
        } catch(IOException ie){
            System.out.println(ie.getMessage());
        }

        //Json 결과를 String으로 얻어옴.
        String response = stringBuffer.toString();

        //String to Json
        JSONParser parser = new JSONParser();
        String encryptMemberNo = "";
        try{
            JSONObject object = (JSONObject) parser.parse(response);
            encryptMemberNo = object.get("encryptMemberNo").toString();
        } catch(ParseException pe){
            System.out.println(pe.getMessage());
        }

        System.out.println("result = "+encryptMemberNo);

        //Get CharacterName from Meta tag. Using JSoup.
        String urlForMeta = URL2+encryptMemberNo;
        Document doc = null;

        try {
            doc = Jsoup.connect(java.net.URLDecoder.decode(urlForMeta,"utf-8")).header("User-Agent" , "Mozilla/5.0").get();
        } catch (IOException e) {
            e.getMessage();
        }

        String metaUrl = doc.select("meta[property=og:url]").attr("content");
        //메타 태그의 url을 split해서 앞부분만 날리고 뒤에 대표 캐릭터이름만 가져옴.
        String[] metaUrlSplit = metaUrl.split("Character/");
        System.out.println(metaUrlSplit[1]);

        return metaUrlSplit[1];
    }

}
