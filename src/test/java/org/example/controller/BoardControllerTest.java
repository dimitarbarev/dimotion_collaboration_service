//package org.example.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.example.business.BoardService;
//import org.example.model.request.BoardRequest;
//import org.example.model.response.BoardResponse;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//public class BoardControllerTest {
//
//    private MockMvc mockMvc;
//    private BoardService boardService;
//    private ObjectMapper objectMapper;
//
////    @BeforeEach
////    void setUp() {
////        boardService = Mockito.mock(BoardService.class);
////        BoardController boardController = new BoardController(boardService);
////        mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();
////        objectMapper = new ObjectMapper();
////    }
////
////    @Test
////    void testCreate_HappyFlow() throws Exception {
////        BoardRequest request = new BoardRequest();
////        request.setTitle("Board A");
////        request.setTeamId(1L);
////
////        BoardResponse response = new BoardResponse();
////        response.setId(1L);
////        response.setTitle("Board A");
////
////        when(boardService.create(any())).thenReturn(response);
////
////        mockMvc.perform(post("/api/boards")
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(objectMapper.writeValueAsString(request)))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.id").value(1L))
////                .andExpect(jsonPath("$.title").value("Board A"));
////    }
////
////    @Test
////    void testGetById_HappyFlow() throws Exception {
////        BoardResponse response = new BoardResponse();
////        response.setId(1L);
////        response.setTitle("Board A");
////
////        when(boardService.getById(1L)).thenReturn(Optional.of(response));
////
////        mockMvc.perform(get("/api/boards/1"))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.id").value(1L))
////                .andExpect(jsonPath("$.title").value("Board A"));
////    }
////
////    @Test
////    void testGetById_SadFlow() throws Exception {
////        when(boardService.getById(999L)).thenReturn(Optional.empty());
////
////        mockMvc.perform(get("/api/boards/999"))
////                .andExpect(status().isNotFound());
////    }
////
////    @Test
////    void testGetAll_HappyFlow() throws Exception {
////        BoardResponse b1 = new BoardResponse();
////        b1.setId(1L);
////        b1.setTitle("Board A");
////
////        BoardResponse b2 = new BoardResponse();
////        b2.setId(2L);
////        b2.setTitle("Board B");
////
////        when(boardService.getAll()).thenReturn(Arrays.asList(b1, b2));
////
////        mockMvc.perform(get("/api/boards"))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.length()").value(2));
////    }
////
////    @Test
////    void testDelete_HappyFlow() throws Exception {
////        mockMvc.perform(delete("/api/boards/1"))
////                .andExpect(status().isNoContent());
////    }
//}
//
