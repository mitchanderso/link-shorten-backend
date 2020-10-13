package com.shortener.linkshorten;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableScan
public interface LinkRepo extends CrudRepository<LinkEntity, String> {

    Optional<LinkEntity> findById(String id);
    Optional<LinkEntity> findByLongLink(String longLink);
    Optional<LinkEntity> findByShortLink(String shortLink);
}
