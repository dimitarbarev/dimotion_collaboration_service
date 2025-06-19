//package org.example.business.implementation;
//
//import org.example.model.request.TextboxRequest;
//import org.example.model.response.TextboxResponse;
//import org.example.repository.BoardRepository;
//import org.example.repository.TextboxRepository;
//import org.example.repository.UserRepository;
//import org.example.repository.entity.BoardEntity;
//import org.example.repository.entity.TextboxEntity;
//import org.example.repository.entity.UserEntity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class TextboxServiceImplementationTest {
//
//    private TextboxRepository textboxRepository;
//    private BoardRepository boardRepository;
//    private UserRepository userRepository;
//    private TextboxServiceImplementation textboxService;
//
//    @BeforeEach
//    public void setUp() {
//        textboxRepository = mock(TextboxRepository.class);
//        boardRepository = mock(BoardRepository.class);
//        userRepository = mock(UserRepository.class);
//        textboxService = new TextboxServiceImplementation(textboxRepository, boardRepository, userRepository);
//    }
//
//    @Test
//    public void testCreateTextbox_HappyFlow() {
//        TextboxRequest request = new TextboxRequest(1L, 1L);
//        BoardEntity board = new BoardEntity(1L, "Test Board", null, null, new HashSet<>());
//        UserEntity user = new UserEntity(1L, "John", "john@example.com", "pass", Set.of(), Set.of());
//        TextboxEntity textbox = new TextboxEntity(1L, board, user);
//
//        when(boardRepository.findById(1L)).thenReturn(Optional.of(board));
//        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
//        when(textboxRepository.save(any(TextboxEntity.class))).thenReturn(textbox);
//
//        TextboxResponse response = textboxService.create(request);
//
//        assertEquals(1L, response.getBoardId());
//        assertEquals(1L, response.getUserId());
//    }
//
//    @Test
//    public void testCreateTextbox_SadFlow_MissingBoard() {
//        TextboxRequest request = new TextboxRequest(1L, 1L);
//        when(boardRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(RuntimeException.class, () -> textboxService.create(request));
//    }
//
//    @Test
//    public void testCreateTextbox_SadFlow_MissingUser() {
//        TextboxRequest request = new TextboxRequest(1L, 1L);
//        BoardEntity board = new BoardEntity(1L, "Test Board", null, null, new HashSet<>());
//
//        when(boardRepository.findById(1L)).thenReturn(Optional.of(board));
//        when(userRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(RuntimeException.class, () -> textboxService.create(request));
//    }
//
//    @Test
//    public void testGetById_HappyFlow() {
//        BoardEntity board = new BoardEntity(1L, "Test Board", null, null, new HashSet<>());
//        UserEntity user = new UserEntity(1L, "John", "john@example.com", "pass", Set.of(), Set.of());
//        TextboxEntity textbox = new TextboxEntity(1L, board, user);
//
//        when(textboxRepository.findById(1L)).thenReturn(Optional.of(textbox));
//
//        Optional<TextboxResponse> response = textboxService.getById(1L);
//
//        assertTrue(response.isPresent());
//        assertEquals(1L, response.get().getBoardId());
//        assertEquals(1L, response.get().getUserId());
//    }
//
//    @Test
//    public void testGetAll_HappyFlow() {
//        BoardEntity board = new BoardEntity(1L, "Test Board", null, null, new HashSet<>());
//        UserEntity user = new UserEntity(1L, "Alice", "alice@example.com", "pass", Set.of(), Set.of());
//        TextboxEntity textbox = new TextboxEntity(1L, board, user);
//
//        when(textboxRepository.findAll()).thenReturn(List.of(textbox));
//
//        List<TextboxResponse> responses = textboxService.getAll();
//
//        assertEquals(1, responses.size());
//        assertEquals(1L, responses.get(0).getUserId());
//    }
//
//    @Test
//    public void testGetAll_AlternativeFlow_EmptyList() {
//        when(textboxRepository.findAll()).thenReturn(Collections.emptyList());
//
//        List<TextboxResponse> responses = textboxService.getAll();
//
//        assertTrue(responses.isEmpty());
//    }
//
//    @Test
//    public void testDeleteById_HappyFlow() {
//        textboxService.deleteById(1L);
//        verify(textboxRepository, times(1)).deleteById(1L);
//    }
//}