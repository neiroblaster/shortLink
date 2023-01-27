package com.shchayuk.test.shortLink.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "link")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "short-link")
    private String shortLink;

    @Column(name = "original-link")
    private String original;

}
