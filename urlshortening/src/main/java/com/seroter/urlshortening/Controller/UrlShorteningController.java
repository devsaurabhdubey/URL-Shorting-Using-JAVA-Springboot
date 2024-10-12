package com.seroter.urlshortening.Controller;


import com.seroter.urlshortening.Service.UrlShorteningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlShorteningController {

    @Autowired
    private UrlShorteningService urlShorteningService;

    @PostMapping("/shorten")
    @ResponseStatus(HttpStatus.CREATED)
    public String shortenUrl(@RequestBody String originalUrl)
    {
        return urlShorteningService.shortUrl(originalUrl);
    }

    @GetMapping("/{shortUrl}")
    public String redirectToOriginal(@PathVariable String shortUrl)
    {
        String originalUrl = urlShorteningService.getOriginalUrl(shortUrl);

        if(originalUrl != null)
        {
            return "Redirecting to:"+originalUrl;
        }
        else {
            return "Url Not foudn";
        }
    }

}
