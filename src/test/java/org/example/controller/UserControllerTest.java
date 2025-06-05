//package org.example.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.example.business.UserService;
//import org.example.model.request.UserRequest;
//import org.example.model.response.UserResponse;
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
//public class UserControllerTest {
//
//    private MockMvc mockMvc;
//    private UserService userService;
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setUp() {
//        userService = Mockito.mock(UserService.class);
//        UserController userController = new UserController(userService);
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//        objectMapper = new ObjectMapper();
//    }
//
//    @Test
//    void testCreate_HappyFlow() throws Exception {
//        UserRequest request = new UserRequest();
//        request.setName("John Doe");
//
//        UserResponse response = new UserResponse();
//        response.setId(1L);
//        response.setName("John Doe");
//
//        when(userService.create(any())).thenReturn(response);
//
//        mockMvc.perform(post("/api/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L))
//                .andExpect(jsonPath("$.name").value("John Doe"));
//    }
//
//    @Test
//    void testGetById_HappyFlow() throws Exception {
//        UserResponse response = new UserResponse();
//        response.setId(1L);
//        response.setName("John Doe");
//
//        when(userService.getById(1L)).thenReturn(Optional.of(response));
//
//        mockMvc.perform(get("/api/users/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L))
//                .andExpect(jsonPath("$.name").value("John Doe"));
//    }
//
//    @Test
//    void testGetById_SadFlow() throws Exception {
//        when(userService.getById(999L)).thenReturn(Optional.empty());
//
//        mockMvc.perform(get("/api/users/999"))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void testGetAll_HappyFlow() throws Exception {
//        UserResponse u1 = new UserResponse();
//        u1.setId(1L);
//        u1.setName("John");
//
//        UserResponse u2 = new UserResponse();
//        u2.setId(2L);
//        u2.setName("Jane");
//
//        when(userService.getAll()).thenReturn(Arrays.asList(u1, u2));
//
//        mockMvc.perform(get("/api/users"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(2));
//    }
//
//    @Test
//    void testDelete_HappyFlow() throws Exception {
//        mockMvc.perform(delete("/api/users/1"))
//                .andExpect(status().isNoContent());
//    }
//}
//
