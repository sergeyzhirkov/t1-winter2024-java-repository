package com.sergeyzhirkov.demo.service;

import broker.Subscriber;
import com.sergeyzhirkov.demo.model.Phrase;
import com.sergeyzhirkov.demo.repository.PhraseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhraseService {

    private final PhraseRepository phraseRepository;
    private final Subscriber subscriber;

    @Scheduled(fixedRate = 1000)
    public void scheduleGetMessageTask() {
        String message = subscriber.getMessage();
        if (message != null) {
            phraseRepository.addPhrase(message);
        }
    }

    public Optional<Phrase> getRandomPhrase() {
        return phraseRepository.getRandomPhrase();
    }
}
