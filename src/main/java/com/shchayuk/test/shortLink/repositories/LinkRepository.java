package com.shchayuk.test.shortLink.repositories;

import com.shchayuk.test.shortLink.models.Link;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {

    Link findByShortLink(String shortLink);
}
