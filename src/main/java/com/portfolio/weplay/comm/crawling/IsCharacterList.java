package com.portfolio.weplay.comm.crawling;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class IsCharacterList {

    private static final String URL = "https://lostark.game.onstove.com/board/IsCharacterList";
    private static final String USER_AGENT = "Mozilla/5.0";

    public String IsCharacterList(String memberNo) throws IOException, ParseException {
        URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setDoOutput(true);

        String jsonInputString = "{\"memberNo\": \""+memberNo+"\"}";
        //멤버 아이디

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        String inputLine;

        while ((inputLine = bufferedReader.readLine()) != null)  {
            stringBuffer.append(inputLine);
        }
        bufferedReader.close();

        String response = stringBuffer.toString();

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(response);

        String encryptMemberNo = object.get("encryptMemberNo").toString();

        System.out.println("result = "+encryptMemberNo);

        return encryptMemberNo;
    }

}
