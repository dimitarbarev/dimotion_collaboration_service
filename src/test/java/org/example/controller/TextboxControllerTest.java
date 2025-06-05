//package org.example.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.example.business.TextboxService;
//import org.example.model.request.TextboxRequest;
//import org.example.model.response.TextboxResponse;
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
//public class TextboxControllerTest {
//
//    private MockMvc mockMvc;
//    private TextboxService textboxService;
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setUp() {
//        textboxService = Mockito.mock(TextboxService.class);
//        TextboxController textboxController = new TextboxController(textboxService);
//        mockMvc = MockMvcBuilders.standaloneSetup(textboxController).build();
//        objectMapper = new ObjectMapper();
//    }
//
//    @Test
//    void testCreate_HappyFlow() throws Exception {
//        TextboxRequest request = new TextboxRequest();
//        request.setBoardId(1L);
//        request.setUserId(1L);
//
//        TextboxResponse response = new TextboxResponse();
//        response.setId(1L);
//
//        when(textboxService.create(any())).thenReturn(response);
//
//        mockMvc.perform(post("/api/textboxes")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L));
//    }
//
//    @Test
//    void testGetById_HappyFlow() throws Exception {
//        TextboxResponse response = new TextboxResponse();
//        response.setId(1L);
//
//        when(textboxService.getById(1L)).thenReturn(Optional.of(response));
//
//        mockMvc.perform(get("/api/textboxes/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L));
//    }
//
//    @Test
//    void testGetById_SadFlow() throws Exception {
//        when(textboxService.getById(999L)).thenReturn(Optional.empty());
//
//        mockMvc.perform(get("/api/textboxes/999"))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void testGetAll_HappyFlow() throws Exception {
//        TextboxResponse t1 = new TextboxResponse();
//        t1.setId(1L);
//        TextboxResponse t2 = new TextboxResponse();
//        t2.setId(2L);
//
//        when(textboxService.getAll()).thenReturn(Arrays.asList(t1, t2));
//
//        mockMvc.perform(get("/api/textboxes"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(2));
//    }
//
//    @Test
//    void testDelete_HappyFlow() throws Exception {
//        mockMvc.perform(delete("/api/textboxes/1"))
//                .andExpect(status().isNoContent());
//    }
//}
//
