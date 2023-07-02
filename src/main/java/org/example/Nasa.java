package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Nasa {
    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String media_type;
    private String service_version;
    private String title;
    private String url;

    public Nasa(){
    }

    public  Nasa(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String type,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String media_type,
            @JsonProperty("service_version") String service_version,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url,

            @JsonProperty("upvotes") int upvotes){
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;

    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString(){
        return "{\n" +
                "\"copyright\"=" + copyright + ", \n" +
                "\"date\"=" + date + ", \n" +
                "\"explanation\"=" + explanation + ", \n" +
                "\"hdurl\"=" + hdurl + ", \n" +
                "\"media_type\"=" + media_type + ", \n" +
                "\"service_version\"=" + service_version + ", \n" +
                "\"title\"=" + title + ", \n" +
                "\"url\"=" + url + ", \n" +
                "}";
    }
}
