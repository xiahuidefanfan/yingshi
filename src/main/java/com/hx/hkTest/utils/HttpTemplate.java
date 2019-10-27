package com.hx.hkTest.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class HttpTemplate {

	public static String httpGet(String url){
        RestTemplate restTemplate=new RestTemplate();
        String result=restTemplate.exchange(url, HttpMethod.GET,null,String.class).getBody();
        return result;
    }

    public static String httpPost(String url,String name){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.postForEntity(url,name,String.class).getBody();
    }

    public static void main(String str[]){
        //System.out.println(HttpTemplate.httpGet("http://localhost:8080/test"));
    	Map<String, String> params = new HashMap<>();
    	params.put("appKey", "95d47096703347e39b79017d88a1f1d7");
    	params.put("appSecret", "5cdb8996f5cd7f82155c729ae00982cb");
    	System.out.println(HttpClientUtil.doPost("https://open.ys7.com/api/lapp/token/get", params, "UTF-8"));
    }
}
