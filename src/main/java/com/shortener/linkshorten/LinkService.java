package com.shortener.linkshorten;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.shortener.linkshorten.LinkShorteningUtil.encode;

@Service
public class LinkService {

    LinkRepo linkRepo;

    public LinkService(LinkRepo linkRepo) {
        this.linkRepo = linkRepo;
    }

    private void updateUniqueId(){
        // On first try we need to create this value
        LinkEntity linkEntity = linkRepo.findByLongLink("uniqueId").orElse(new LinkEntity("uniqueId", 0));
        linkEntity.setUniqueIncrementer(linkEntity.getUniqueIncrementer() + 1);
        linkRepo.save(linkEntity);
    }

    private int getUniqueId() {
        LinkEntity linkEntity = linkRepo.findByLongLink("uniqueId").orElseThrow(() -> new LinkNotFoundException("uniqueId"));
        return linkEntity.getUniqueIncrementer();
    }



    private String generateShortLink() {
        return encode(getUniqueId());
    }

    public LinkEntity saveLink(String longlink) {
        LinkEntity linkEntity = linkRepo.findByLongLink(longlink).orElse(new LinkEntity("dummy", longlink));
        if (linkEntity.getShortLink().equals("dummy")){ // This isnt great, ideally move to a second table
            // Every time we save we want to increment
            updateUniqueId();

            // Before we save set it to the actual short Link
            linkEntity.setShortLink(generateShortLink());

            // Finally save
            linkRepo.save(linkEntity);
        }
        return linkEntity;
    }

    public LinkEntity getLinkByShortLink(String shortlink) {
        return linkRepo.findByShortLink(shortlink).orElseThrow(() -> new LinkNotFoundException(shortlink));
    }

    public LinkEntity getLinkByLongLink(String longlink) {
        return linkRepo.findByLongLink(longlink).orElseThrow(() -> new LinkNotFoundException(longlink));
    }
}
