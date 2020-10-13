package com.shortener.linkshorten;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@CrossOrigin
public class LinkController {

    LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/{id}")
    public RedirectView getShortLinkByLongLink(@PathVariable String id){
        LinkEntity linkEntity = linkService.getLinkByShortLink(id);
        return new RedirectView(linkEntity.getLongLink());
    }

    @PostMapping("/shorten")
    public ResponseEntity<LinkResponse> addNewLink(@RequestBody ShortenRequest shortenRequest){
        LinkEntity linkEntity = linkService.saveLink(shortenRequest.getToShorten());
        return new ResponseEntity<>(new LinkResponse(linkEntity.getShortLink()), HttpStatus.OK);
    }
}
