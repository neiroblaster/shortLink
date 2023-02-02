package com.shchayuk.test.shortLink.controllers;

import com.shchayuk.test.shortLink.services.Impl.LinkServiceDefaultImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RedirectController {

    private final LinkServiceDefaultImpl linkService;

    @Autowired
    public RedirectController(LinkServiceDefaultImpl linkService) {
        this.linkService = linkService;
    }

    @GetMapping(
            value = "/li/{short-name}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public RedirectView redirectToOriginalLink(@PathVariable("short-name") String shortLink){
        String originalLink = linkService.getOriginalLinkByShortLink(shortLink);
        return new RedirectView(originalLink);
    }
}
