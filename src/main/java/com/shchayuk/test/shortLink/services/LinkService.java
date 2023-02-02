package com.shchayuk.test.shortLink.services;

import com.shchayuk.test.shortLink.models.Link;

public interface LinkService {
    String getOriginalLinkByShortLink(String shortLink);

    String reduceLink(Link link);
}
