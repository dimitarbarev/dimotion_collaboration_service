//package org.example.business.implementation;
//
//import org.example.business.MessagePublisher;
//import org.example.model.request.UserRequest;
//import org.example.model.response.UserResponse;
//import org.example.repository.UserRepository;
//import org.example.repository.entity.UserEntity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//import java.util.*;
//
//public class UserServiceImplementationTest {
//
//    private UserRepository userRepository;
//    private UserServiceImplementation userService;
//
//    private MessagePublisher messagePublisher;
//
//    @BeforeEach
//    void setUp() {
//        userRepository = mock(UserRepository.class);
//        messagePublisher = mock(MessagePublisher.class);
//        userService = new UserServiceImplementation(userRepository, messagePublisher);
//    }
//
//    @Test
//    void testCreate_HappyFlow() {
//        UserRequest request = new UserRequest("John", "john@example.com", "pass");
//
//        UserEntity savedEntity = new UserEntity(1L, "John", "john@example.com", "pass", Set.of(), Set.of());
//        when(userRepository.save(any(UserEntity.class))).thenReturn(savedEntity);
//
//        UserResponse response = userService.create(request);
//
//        assertEquals("John", response.getName());
//        assertEquals("john@example.com", response.getEmail());
//        assertNotNull(response.getId());
//    }
//
//    @Test
//    void testGetById_HappyFlow() {
//        UserEntity entity = new UserEntity(1L, "Jane", "jane@example.com", "Smith", Set.of(), Set.of());
//        when(userRepository.findById(1L)).thenReturn(Optional.of(entity));
//
//        Optional<UserResponse> response = userService.getById(1L);
//
//        assertTrue(response.isPresent());
//        assertEquals("Jane", response.get().getName());
//        assertEquals("jane@example.com", response.get().getEmail());
//    }
//
//    @Test
//    void testGetById_SadFlow_UserNotFound() {
//        when(userRepository.findById(2L)).thenReturn(Optional.empty());
//
//        Optional<UserResponse> response = userService.getById(2L);
//
//        assertFalse(response.isPresent());
//    }
//
//    @Test
//    void testGetAll_HappyFlow() {
//        List<UserEntity> entities = Arrays.asList(
//                new UserEntity(1L, "Alice", "alice@wonder.com", "123", Set.of(), Set.of()),
//                new UserEntity(2L, "Bob", "bob@builder.com", "456", Set.of(), Set.of())
//        );
//
//        when(userRepository.findAll()).thenReturn(entities);
//
//        List<UserResponse> responses = userService.getAll();
//
//        assertEquals(2, responses.size());
//        assertEquals("Alice", responses.get(0).getName());
//        assertEquals("Bob", responses.get(1).getName());
//    }
//
//    @Test
//    void testGetAll_AlternativeFlow_EmptyList() {
//        when(userRepository.findAll()).thenReturn(Collections.emptyList());
//
//        List<UserResponse> responses = userService.getAll();
//
//        assertTrue(responses.isEmpty());
//    }
//
//    @Test
//    void testDeleteById_HappyFlow() {
//        doNothing().when(userRepository).deleteById(1L);
//
//        assertDoesNotThrow(() -> userService.deleteById(1L));
//        verify(userRepository, times(1)).deleteById(1L);
//    }
//}
//
//
//
