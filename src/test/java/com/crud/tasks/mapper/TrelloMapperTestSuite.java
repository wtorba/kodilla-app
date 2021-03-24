package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrelloMapperTestSuite {

    public TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void verifyMapToBoard() {
        // Given
        TrelloBoardDto trelloBoardDto= new TrelloBoardDto("test_id", "test_board", new ArrayList<>());
        // When
        TrelloBoard trelloBoard = trelloMapper.mapToBoard(trelloBoardDto);
        // Then
        assertEquals(trelloBoard.getClass(),TrelloBoard.class);
        assertEquals("test_id", trelloBoard.getId());
        assertEquals("test_board", trelloBoard.getName());
        assertEquals(new ArrayList<>(), trelloBoard.getLists());

    }

    @Test
    public void verifyMapToBoards() {
        // Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("test_id", "test_board", new ArrayList<>()));
        trelloBoardDtos.add(new TrelloBoardDto("test2_id", "test2_board", new ArrayList<>()));
        // When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);
        // Then
        assertEquals(2, trelloBoards.size());
        assertEquals("test2_id", trelloBoards.get(1).getId());
        assertEquals("test2_board", trelloBoards.get(1).getName());
        assertEquals(0, trelloBoards.get(1).getLists().size());
    }

    @Test
    public void verifyMapToBoardsDto() {
        // Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("test_id", "test_board", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("test2_id", "test2_board", new ArrayList<>()));
        // When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);
        // Then
        assertEquals(2, trelloBoardDtos.size());
        assertEquals("test2_id", trelloBoardDtos.get(1).getId());
        assertEquals("test2_board", trelloBoardDtos.get(1).getName());
        assertEquals(0, trelloBoardDtos.get(1).getLists().size());
    }

    @Test
    public void verifyMapToList() {
        //Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("test_id","test_name",false));
        trelloListDtos.add(new TrelloListDto("test2_id","test2_name",true));
        //When
        List<TrelloList>  trelloLists = trelloMapper.mapToList(trelloListDtos);
        //Then
        assertEquals(2, trelloLists.size());
        assertEquals("test2_id",trelloLists.get(1).getId());
        assertEquals("test2_name",trelloLists.get(1).getName());
        assertFalse(trelloLists.get(0).isClosed());
    }

    @Test
    public void verifyMapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("test_id","test_name",false));
        trelloLists.add(new TrelloList("test2_id","test2_name",true));
        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);
        //Then
        assertEquals(2, trelloLists.size());
        assertEquals("test2_id",trelloListDtos.get(1).getId());
        assertEquals("test2_name",trelloListDtos.get(1).getName());
        assertFalse(trelloListDtos.get(0).isClosed());
    }

    @Test
    public void verifyMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name", "description", "pos", "listId");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("name", trelloCardDto.getName());
        assertEquals("description",trelloCardDto.getDescription());
        assertEquals("pos",trelloCardDto.getPos());
        assertEquals("listId",trelloCardDto.getListId());
    }

    @Test
    public void verifyMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "listId");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("name", trelloCard.getName());
        assertEquals("description",trelloCard.getDescription());
        assertEquals("pos",trelloCard.getPos());
        assertEquals("listId",trelloCard.getListId());
    }

}
