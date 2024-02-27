package com.sergeyzhirkov.demo.controller;

import broker.Publisher;
import com.sergeyzhirkov.demo.model.Phrase;
import com.sergeyzhirkov.demo.service.PhraseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/help-service/v1/support")
@RequiredArgsConstructor
public class PhraseController {
    private final Publisher publisher;
    private final PhraseService phraseService;

    @GetMapping
    public Phrase getRandomPhrase() {
        return phraseService.getRandomPhrase().orElseGet(() -> new Phrase("Empty phrase"));
    }

    @PostMapping
    public void addPhrase(@RequestBody String newPhrase) {
        publisher.publishMessage(newPhrase);
    }
}
