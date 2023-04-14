package com.portfolio.weplay.comm.validation;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class GetToken {

    private static final String URL = "https://api.onstove.com/tm/v1/preferences/";
    private static final String USER_AGENT = "Mozilla/5.0";

    public String GetToken(String memberNo){
        StringBuffer stringBuffer = new StringBuffer();
        try {
            URL url = new URL(URL+memberNo);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //HttpURLConnection을 이용한 GET 통신
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setDoOutput(true);

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
        String token = "";
        try{
            JSONObject jsonObject =(JSONObject) parser.parse(response);
            JSONObject data =(JSONObject) jsonObject.get("data");

            token = data.get("introduce").toString();
        } catch(ParseException pe){
            System.out.println(pe.getMessage());
        }

        System.out.println("result = "+token);

        return token;
    }

}
