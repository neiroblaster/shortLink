package com.shchayuk.test.shortLink.services;

import com.shchayuk.test.shortLink.models.Link;
import com.shchayuk.test.shortLink.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    private final String PREDICATE = "/li/";

    @Autowired
    LinkRepository linkRepository;

    public String getOriginalLinkByShortLink(String shortLink){
        Link link = linkRepository.findByShortLink(shortLink);
        return link.getOriginal();
    }

    public String reduceLink(Link link) {
        link.setOriginal(link.getOriginal());

        String shortLink = String.valueOf(Math.abs(link.hashCode()));

        link.setShortLink(shortLink);

        linkRepository.save(link);

        return PREDICATE + shortLink;
    }
}
