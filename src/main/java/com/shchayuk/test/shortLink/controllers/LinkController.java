package com.shchayuk.test.shortLink.controllers;

import com.shchayuk.test.shortLink.dto.LinkDTO;
import com.shchayuk.test.shortLink.models.Link;
import com.shchayuk.test.shortLink.services.LinkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LinkController {

    private final ModelMapper modelMapper;
    private final LinkService linkService;

    @Autowired
    public LinkController(ModelMapper modelMapper, LinkService linkService) {
        this.modelMapper = modelMapper;
        this.linkService = linkService;
    }


    @PostMapping("/generate")
    public ResponseEntity <?> getShortLink(@RequestBody LinkDTO linkDTO){
        Link link = convertToLink(linkDTO);
        String shortLink = linkService.reduceLink(link);

        Map<String, String> map = new HashMap<>();
        map.put("short", shortLink);

        return ResponseEntity.ok(map);
    }

    private Link convertToLink(LinkDTO linkDTO){
        return modelMapper.map(linkDTO, Link.class);
    }
}
