//package org.example.controller;
//
//import org.example.business.TeamService;
//import org.example.model.request.TeamRequest;
//import org.example.model.response.TeamResponse;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//public class TeamControllerTest {
//
//    private MockMvc mockMvc;
//    private TeamService teamService;
//    private ObjectMapper objectMapper;
//
////    @BeforeEach
////    void setUp() {
////        teamService = Mockito.mock(TeamService.class);
////        TeamController teamController = new TeamController(teamService);
////        mockMvc = MockMvcBuilders.standaloneSetup(teamController).build();
////        objectMapper = new ObjectMapper();
////    }
////
////    @Test
////    void testCreate_HappyFlow() throws Exception {
////        TeamRequest request = new TeamRequest();
////        request.setName("Team A");
////        TeamResponse response = new TeamResponse();
////        response.setId(1L);
////        response.setName("Team A");
////
////        when(teamService.create(any())).thenReturn(response);
////
////        mockMvc.perform(post("/api/teams")
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(objectMapper.writeValueAsString(request)))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.id").value(1L))
////                .andExpect(jsonPath("$.name").value("Team A"));
////    }
////
////    @Test
////    void testGetById_HappyFlow() throws Exception {
////        TeamResponse response = new TeamResponse();
////        response.setId(1L);
////        response.setName("Team A");
////        when(teamService.getById(1L)).thenReturn(Optional.of(response));
////
////        mockMvc.perform(get("/api/teams/1"))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.id").value(1L))
////                .andExpect(jsonPath("$.name").value("Team A"));
////    }
////
////    @Test
////    void testGetById_SadFlow() throws Exception {
////        when(teamService.getById(999L)).thenReturn(Optional.empty());
////
////        mockMvc.perform(get("/api/teams/999"))
////                .andExpect(status().isNotFound());
////    }
////
////    @Test
////    void testGetAll_HappyFlow() throws Exception {
////        TeamResponse team1 = new TeamResponse();
////        team1.setId(1L);
////        team1.setName("Team A");
////        TeamResponse team2 = new TeamResponse();
////        team2.setId(2L);
////        team2.setName("Team B");
////
////        when(teamService.getAll()).thenReturn(Arrays.asList(team1, team2));
////
////        mockMvc.perform(get("/api/teams"))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.length()").value(2));
////    }
////
////    @Test
////    void testDelete_HappyFlow() throws Exception {
////        mockMvc.perform(delete("/api/teams/1"))
////                .andExpect(status().isNoContent());
////    }
//}
