package com.shchayuk.test.shortLink.controllers;

import com.shchayuk.test.shortLink.services.Impl.LinkServiceDefaultImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RequiredArgsConstructor
@RestController
public class RedirectController {

    private final LinkServiceDefaultImpl linkService;

    @GetMapping(
            value = "/li/{short-name}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public RedirectView redirectToOriginalLink(@PathVariable("short-name") String shortLink){
        String originalLink = linkService.getOriginalLinkByShortLink(shortLink);
        return new RedirectView(originalLink);
    }
}
