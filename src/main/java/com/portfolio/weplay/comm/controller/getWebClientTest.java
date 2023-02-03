package com.portfolio.weplay.comm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;

import java.util.Map;

@RequestMapping(value = "/test")
public class getWebClientTest {

    public final String BASE_URL = "https://timeline.onstove.com/159967896";

    public void test(){
        System.out.println("test 도착");
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(BASE_URL);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
        WebClient webClient = WebClient.builder().uriBuilderFactory(factory).baseUrl(BASE_URL).build();

        String response = webClient.get().uri(uriBuilder -> uriBuilder.build()).retrieve().bodyToMono(String.class).block();

        System.out.println("response : " + response);
    }
}
