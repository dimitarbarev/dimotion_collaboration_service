//package org.example.business.implementation;
//
//import org.example.business.MessagePublisher;
//import org.example.model.request.BoardRequest;
//import org.example.model.response.BoardResponse;
//import org.example.repository.BoardRepository;
//import org.example.repository.TeamRepository;
//import org.example.repository.entity.BoardEntity;
//import org.example.repository.entity.TeamEntity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDateTime;
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class BoardServiceImplementationTest {
//
//    private BoardRepository boardRepository;
//    private TeamRepository teamRepository;
//    private MessagePublisher messagePublisher;
//    private BoardServiceImplementation boardService;
//
//    @BeforeEach
//    public void setUp() {
//        boardRepository = mock(BoardRepository.class);
//        teamRepository = mock(TeamRepository.class);
//        messagePublisher = mock(MessagePublisher.class);
//
//        boardService = new BoardServiceImplementation(boardRepository, teamRepository, messagePublisher);
//    }
//
//    @Test
//    public void testCreate_HappyFlow() {
//        BoardRequest request = new BoardRequest("Board Title", LocalDateTime.now().toString(), 1L);
//        TeamEntity team = new TeamEntity();
//        team.setId(1L);
//
//        when(teamRepository.findById(1L)).thenReturn(Optional.of(team));
//        when(boardRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
//
//        BoardResponse response = boardService.create(request);
//
//        assertNotNull(response);
//        assertEquals("Board Title", response.getTitle());
//    }
//
//    @Test
//    public void testCreate_TeamNotFound_SadFlow() {
//        BoardRequest request = new BoardRequest("Board Title", LocalDateTime.now().toString(), 999L);
//
//        when(teamRepository.findById(999L)).thenReturn(Optional.empty());
//
//        assertThrows(RuntimeException.class, () -> boardService.create(request));
//    }
//
//    @Test
//    public void testGetById_HappyFlow() {
//        BoardEntity entity = new BoardEntity(1L, "Sample", LocalDateTime.now(), new TeamEntity(), new HashSet<>());
//        when(boardRepository.findById(1L)).thenReturn(Optional.of(entity));
//
//        Optional<BoardResponse> result = boardService.getById(1L);
//
//        assertTrue(result.isPresent());
//        assertEquals("Sample", result.get().getTitle());
//    }
//
//    @Test
//    public void testGetById_NotFound_SadFlow() {
//        when(boardRepository.findById(1L)).thenReturn(Optional.empty());
//
//        Optional<BoardResponse> result = boardService.getById(1L);
//
//        assertFalse(result.isPresent());
//    }
//
//    @Test
//    public void testDeleteById() {
//        boardService.deleteById(1L);
//        verify(boardRepository, times(1)).deleteById(1L);
//    }
//}
