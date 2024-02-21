package com.sergeyzhirkov.demo.repository;

import com.sergeyzhirkov.demo.model.Phrase;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class PhraseRepository {
    private final CopyOnWriteArrayList<Phrase> phraseList = new CopyOnWriteArrayList<>();

    public Optional<Phrase> getRandomPhrase() {
        return phraseList.isEmpty()
                ? Optional.empty()
                : Optional.of(phraseList.get((int) (Math.random() * phraseList.size())));
    }

    public void addPhrase(String text) {
        phraseList.add(new Phrase(text));
    }

}
