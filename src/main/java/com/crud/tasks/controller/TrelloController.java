package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.facade.TrelloFacade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.*;
import java.util.stream.Collectors;
//import java.util.Optional;
//import java.util.Collections;

@RestController
@RequestMapping("/v1/trello")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloController.class);
    private final TrelloFacade trelloFacade;

    //@GetMapping("getTrelloBoards")
    @GetMapping("/boards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloFacade.fetchTrelloBoards();
    }

//        try {
//            List<TrelloBoardDto> trelloBoards = trelloFacade.fetchTrelloBoards();
//            return Optional.ofNullable(trelloBoards)
//                    .orElse(Collections.emptyList())
//                    .stream()
//                    .filter(e -> Objects.nonNull(e.getId()) && Objects.nonNull(e.getName()))
//                    .filter(e -> e.getName().contains("Kodilla"))
//                    .collect(Collectors.toList());

/*            trelloBoards.forEach(trelloBoardDto -> {
                System.out.println(trelloBoardDto.getId() + " - " + trelloBoardDto.getName());
                System.out.println("This board contains lists: ");
                trelloBoardDto.getLists().forEach(trelloList ->
                        System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed())
                );
            });*/
//        } catch (RestClientException e) {
//            LOGGER.error(e.getMessage(), e);
//            return Collections.emptyList();
//        }


 /*       Optional.ofNullable(trelloBoards).orElse(Collections.emptyList()).stream()
                .filter(e -> (e.getName()!=null && !(e.getName().isEmpty())))
                .filter(e -> (e.getId()!=null && !(e.getId().isEmpty())))
                .filter(e -> e.getName().contains("Kodilla"))
                .forEach(e -> System.out.println(e.getId() + " " + e.getName()));*/
//    }

    //@PostMapping("createTrelloCard")
    @PostMapping("/cards")
    public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloFacade.createCard(trelloCardDto);
    }
}