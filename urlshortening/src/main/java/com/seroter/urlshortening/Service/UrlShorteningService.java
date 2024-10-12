package com.seroter.urlshortening.Service;

import com.seroter.urlshortening.Model.URLMapping;
import com.seroter.urlshortening.Repository.URLMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UrlShorteningService {

    @Autowired
    private URLMappingRepository urlMappingRepository;

    private static final String BASE_URL = "http://localhost:8080/";

    public String shortUrl(String originalUrl)
    {
        String shortUrl = generateShortUrl(originalUrl);

        URLMapping urlMapping = new URLMapping(originalUrl,shortUrl);
        urlMappingRepository.save(urlMapping);
        return shortUrl;

    }

    public String getOriginalUrl(String shortUrl){
        URLMapping urlMapping = urlMappingRepository.findShortUrl(shortUrl);

        return urlMapping != null ? urlMapping.getOriginalUrl():null;
    }

    private String generateShortUrl(String originalUrl){
        String encodedUrl = Base64.getUrlEncoder().encodeToString(originalUrl.getBytes());
        return BASE_URL + encodedUrl.substring(0, 8);
    }
}
