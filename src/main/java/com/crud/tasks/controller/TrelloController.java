package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Collections;

@RestController
@RequestMapping("/v1/trello")
@RequiredArgsConstructor
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("getTrelloBoards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        Optional.ofNullable(trelloBoards).orElse(Collections.emptyList()).stream()
                .filter(e -> !(e.getName()!=null && e.getName().isEmpty()))
                .filter(e -> !(e.getId()!=null && e.getId().isEmpty()))
                .filter(e -> e.getName().contains("Kodilla"))
                .forEach(e -> System.out.println(e.getId() + " " + e.getName()));
    }
}