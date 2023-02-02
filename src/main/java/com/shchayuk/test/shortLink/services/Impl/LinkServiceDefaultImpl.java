package com.shchayuk.test.shortLink.services.Impl;

import com.shchayuk.test.shortLink.models.Link;
import com.shchayuk.test.shortLink.repositories.LinkRepository;
import com.shchayuk.test.shortLink.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceDefaultImpl implements LinkService {

    private final String PREDICATE = "/li/";

    @Autowired
    LinkRepository linkRepository;

    @Override
    public String getOriginalLinkByShortLink(String shortLink){
        Link link = linkRepository.findByShortLink(shortLink);
        return link.getOriginal();
    }

    @Override
    public String reduceLink(Link link) {
        link.setOriginal(link.getOriginal());

        String shortLink = String.valueOf(Math.abs(link.hashCode()));

        link.setShortLink(shortLink);

        linkRepository.save(link);

        return PREDICATE + shortLink;
    }
}
