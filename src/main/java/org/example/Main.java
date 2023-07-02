package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String adress = "https://api.nasa.gov/planetary/apod?api_key=IGn5pSt8eyPteCQxwDdvgJiT8t0m1klyYnEaZ9Oi";
        CloseableHttpResponse answer = http(adress);
        Nasa result = jsonToFacts(answer);
        String url = result.getUrl();
        try (FileOutputStream fos =new FileOutputStream(url.substring(url.lastIndexOf("/")+1))){
            fos.write(http(url).getEntity().getContent().readAllBytes());
        } catch (IOException ex){
            ex.getMessage();
        }
    }

    public static CloseableHttpResponse http(String adress) {
        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create()
                    .setDefaultRequestConfig(RequestConfig.custom()
                            .setConnectTimeout(5000)
                            .setSocketTimeout(30000)
                            .setRedirectsEnabled(false)
                            .build())
                    .build();
            HttpGet request = new HttpGet(adress);
            response = httpClient.execute(request);
            return response;
        } catch (IOException ex) {
            ex.getMessage();
        }
        return response;
    }

    public static Nasa jsonToFacts(CloseableHttpResponse answer){
        ObjectMapper mapper = new ObjectMapper();
        Nasa result = null;
        try{
            result = mapper.readValue(new String(answer.getEntity().getContent().readAllBytes()),
                    new TypeReference<>() {});
        } catch (IOException ex){
            ex.getMessage();
        }
        return result;
    }
}