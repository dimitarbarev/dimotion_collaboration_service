//package org.example.business.implementation;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.ArgumentMatchers.isA;
//import static org.mockito.ArgumentMatchers.isNull;
//import static org.mockito.Mockito.atLeast;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import org.example.model.request.TeamRequest;
//import org.example.model.response.TeamResponse;
//import org.example.repository.TeamRepository;
//import org.example.repository.UserRepository;
//import org.example.repository.entity.BoardEntity;
//import org.example.repository.entity.TeamEntity;
//import org.example.repository.entity.UserEntity;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ContextConfiguration(classes = {TeamServiceImplementation.class})
//@ExtendWith(SpringExtension.class)
//class TeamServiceImplementationTest {
//    @MockBean
//    private TeamRepository teamRepository;
//
//    @Autowired
//    private TeamServiceImplementation teamServiceImplementation;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#create(TeamRequest)}
//     */
//    @Test
//    void testCreate() {
//        // Arrange
//        TeamEntity teamEntity = new TeamEntity();
//        teamEntity.setBoards(new HashSet<>());
//        teamEntity.setId(1L);
//        teamEntity.setName("Name");
//        teamEntity.setUsers(new HashSet<>());
//        when(teamRepository.save(Mockito.<TeamEntity>any())).thenReturn(teamEntity);
//        when(userRepository.findAllById(Mockito.<Iterable<Long>>any())).thenReturn(new ArrayList<>());
//
//        // Act
//        TeamResponse actualCreateResult = teamServiceImplementation.create(new TeamRequest());
//
//        // Assert
//        verify(teamRepository).save(isA(TeamEntity.class));
//        verify(userRepository).findAllById(isNull());
//        assertEquals("Name", actualCreateResult.getName());
//        assertEquals(1L, actualCreateResult.getId().longValue());
//        assertTrue(actualCreateResult.getUsers().isEmpty());
//    }
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#create(TeamRequest)}
//     */
//    @Test
//    void testCreate2() {
//        // Arrange
//        TeamEntity teamEntity = mock(TeamEntity.class);
//        when(teamEntity.getId()).thenReturn(1L);
//        when(teamEntity.getName()).thenReturn("Name");
//        doNothing().when(teamEntity).setBoards(Mockito.<Set<BoardEntity>>any());
//        doNothing().when(teamEntity).setId(Mockito.<Long>any());
//        doNothing().when(teamEntity).setName(Mockito.<String>any());
//        doNothing().when(teamEntity).setUsers(Mockito.<Set<UserEntity>>any());
//        teamEntity.setBoards(new HashSet<>());
//        teamEntity.setId(1L);
//        teamEntity.setName("Name");
//        teamEntity.setUsers(new HashSet<>());
//        when(teamRepository.save(Mockito.<TeamEntity>any())).thenReturn(teamEntity);
//        when(userRepository.findAllById(Mockito.<Iterable<Long>>any())).thenReturn(new ArrayList<>());
//
//        // Act
//        TeamResponse actualCreateResult = teamServiceImplementation.create(new TeamRequest());
//
//        // Assert
//        verify(teamEntity).getId();
//        verify(teamEntity).getName();
//        verify(teamEntity).setBoards(isA(Set.class));
//        verify(teamEntity).setId(eq(1L));
//        verify(teamEntity).setName(eq("Name"));
//        verify(teamEntity).setUsers(isA(Set.class));
//        verify(teamRepository).save(isA(TeamEntity.class));
//        verify(userRepository).findAllById(isNull());
//        assertEquals("Name", actualCreateResult.getName());
//        assertEquals(1L, actualCreateResult.getId().longValue());
//        assertTrue(actualCreateResult.getUsers().isEmpty());
//    }
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#create(TeamRequest)}
//     */
//    @Test
//    void testCreate3() {
//        // Arrange
//        TeamEntity teamEntity = mock(TeamEntity.class);
//        when(teamEntity.getId()).thenReturn(1L);
//        when(teamEntity.getName()).thenReturn("Name");
//        doNothing().when(teamEntity).setBoards(Mockito.<Set<BoardEntity>>any());
//        doNothing().when(teamEntity).setId(Mockito.<Long>any());
//        doNothing().when(teamEntity).setName(Mockito.<String>any());
//        doNothing().when(teamEntity).setUsers(Mockito.<Set<UserEntity>>any());
//        teamEntity.setBoards(new HashSet<>());
//        teamEntity.setId(1L);
//        teamEntity.setName("Name");
//        teamEntity.setUsers(new HashSet<>());
//        when(teamRepository.save(Mockito.<TeamEntity>any())).thenReturn(teamEntity);
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setBoards(new HashSet<>());
//        userEntity.setEmail("jane.doe@example.org");
//        userEntity.setId(1L);
//        userEntity.setName("Name");
//        userEntity.setPassword("iloveyou");
//        userEntity.setTeams(new HashSet<>());
//
//        ArrayList<UserEntity> userEntityList = new ArrayList<>();
//        userEntityList.add(userEntity);
//        when(userRepository.findAllById(Mockito.<Iterable<Long>>any())).thenReturn(userEntityList);
//
//        // Act
//        TeamResponse actualCreateResult = teamServiceImplementation.create(new TeamRequest());
//
//        // Assert
//        verify(teamEntity).getId();
//        verify(teamEntity).getName();
//        verify(teamEntity).setBoards(isA(Set.class));
//        verify(teamEntity).setId(eq(1L));
//        verify(teamEntity).setName(eq("Name"));
//        verify(teamEntity).setUsers(isA(Set.class));
//        verify(teamRepository).save(isA(TeamEntity.class));
//        verify(userRepository).findAllById(isNull());
//        assertEquals("Name", actualCreateResult.getName());
//        assertEquals(1, actualCreateResult.getUsers().size());
//        assertEquals(1L, actualCreateResult.getId().longValue());
//    }
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#create(TeamRequest)}
//     */
//    @Test
//    void testCreate4() {
//        // Arrange
//        TeamEntity teamEntity = mock(TeamEntity.class);
//        when(teamEntity.getId()).thenReturn(1L);
//        when(teamEntity.getName()).thenReturn("Name");
//        doNothing().when(teamEntity).setBoards(Mockito.<Set<BoardEntity>>any());
//        doNothing().when(teamEntity).setId(Mockito.<Long>any());
//        doNothing().when(teamEntity).setName(Mockito.<String>any());
//        doNothing().when(teamEntity).setUsers(Mockito.<Set<UserEntity>>any());
//        teamEntity.setBoards(new HashSet<>());
//        teamEntity.setId(1L);
//        teamEntity.setName("Name");
//        teamEntity.setUsers(new HashSet<>());
//        when(teamRepository.save(Mockito.<TeamEntity>any())).thenReturn(teamEntity);
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setBoards(new HashSet<>());
//        userEntity.setEmail("jane.doe@example.org");
//        userEntity.setId(1L);
//        userEntity.setName("Name");
//        userEntity.setPassword("iloveyou");
//        userEntity.setTeams(new HashSet<>());
//
//        UserEntity userEntity2 = new UserEntity();
//        userEntity2.setBoards(new HashSet<>());
//        userEntity2.setEmail("john.smith@example.org");
//        userEntity2.setId(2L);
//        userEntity2.setName("42");
//        userEntity2.setPassword("Password");
//        userEntity2.setTeams(new HashSet<>());
//
//        ArrayList<UserEntity> userEntityList = new ArrayList<>();
//        userEntityList.add(userEntity2);
//        userEntityList.add(userEntity);
//        when(userRepository.findAllById(Mockito.<Iterable<Long>>any())).thenReturn(userEntityList);
//
//        // Act
//        TeamResponse actualCreateResult = teamServiceImplementation.create(new TeamRequest());
//
//        // Assert
//        verify(teamEntity).getId();
//        verify(teamEntity).getName();
//        verify(teamEntity).setBoards(isA(Set.class));
//        verify(teamEntity).setId(eq(1L));
//        verify(teamEntity).setName(eq("Name"));
//        verify(teamEntity).setUsers(isA(Set.class));
//        verify(teamRepository).save(isA(TeamEntity.class));
//        verify(userRepository).findAllById(isNull());
//        assertEquals("Name", actualCreateResult.getName());
//        assertEquals(1L, actualCreateResult.getId().longValue());
//        assertEquals(2, actualCreateResult.getUsers().size());
//    }
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#create(TeamRequest)}
//     */
//    @Test
//    void testCreate5() {
//        // Arrange
//        TeamEntity teamEntity = mock(TeamEntity.class);
//        when(teamEntity.getId()).thenReturn(1L);
//        when(teamEntity.getName()).thenReturn("Name");
//        doNothing().when(teamEntity).setBoards(Mockito.<Set<BoardEntity>>any());
//        doNothing().when(teamEntity).setId(Mockito.<Long>any());
//        doNothing().when(teamEntity).setName(Mockito.<String>any());
//        doNothing().when(teamEntity).setUsers(Mockito.<Set<UserEntity>>any());
//        teamEntity.setBoards(new HashSet<>());
//        teamEntity.setId(1L);
//        teamEntity.setName("Name");
//        teamEntity.setUsers(new HashSet<>());
//        when(teamRepository.save(Mockito.<TeamEntity>any())).thenReturn(teamEntity);
//        UserEntity userEntity = mock(UserEntity.class);
//        when(userEntity.getId()).thenReturn(1L);
//        when(userEntity.getEmail()).thenReturn("jane.doe@example.org");
//        when(userEntity.getName()).thenReturn("Name");
//        doNothing().when(userEntity).setBoards(Mockito.<Set<BoardEntity>>any());
//        doNothing().when(userEntity).setEmail(Mockito.<String>any());
//        doNothing().when(userEntity).setId(Mockito.<Long>any());
//        doNothing().when(userEntity).setName(Mockito.<String>any());
//        doNothing().when(userEntity).setPassword(Mockito.<String>any());
//        doNothing().when(userEntity).setTeams(Mockito.<Set<TeamEntity>>any());
//        userEntity.setBoards(new HashSet<>());
//        userEntity.setEmail("jane.doe@example.org");
//        userEntity.setId(1L);
//        userEntity.setName("Name");
//        userEntity.setPassword("iloveyou");
//        userEntity.setTeams(new HashSet<>());
//
//        UserEntity userEntity2 = new UserEntity();
//        userEntity2.setBoards(new HashSet<>());
//        userEntity2.setEmail("jane.doe@example.org");
//        userEntity2.setId(1L);
//        userEntity2.setName("Name");
//        userEntity2.setPassword("iloveyou");
//        userEntity2.setTeams(new HashSet<>());
//
//        ArrayList<UserEntity> userEntityList = new ArrayList<>();
//        userEntityList.add(userEntity2);
//        userEntityList.add(userEntity);
//        when(userRepository.findAllById(Mockito.<Iterable<Long>>any())).thenReturn(userEntityList);
//
//        // Act
//        TeamResponse actualCreateResult = teamServiceImplementation.create(new TeamRequest());
//
//        // Assert
//        verify(teamEntity).getId();
//        verify(teamEntity).getName();
//        verify(teamEntity).setBoards(isA(Set.class));
//        verify(teamEntity).setId(eq(1L));
//        verify(teamEntity).setName(eq("Name"));
//        verify(teamEntity).setUsers(isA(Set.class));
//        verify(userEntity).getEmail();
//        verify(userEntity).getId();
//        verify(userEntity).getName();
//        verify(userEntity).setBoards(isA(Set.class));
//        verify(userEntity).setEmail(eq("jane.doe@example.org"));
//        verify(userEntity).setId(eq(1L));
//        verify(userEntity).setName(eq("Name"));
//        verify(userEntity).setPassword(eq("iloveyou"));
//        verify(userEntity).setTeams(isA(Set.class));
//        verify(teamRepository).save(isA(TeamEntity.class));
//        verify(userRepository).findAllById(isNull());
//        assertEquals("Name", actualCreateResult.getName());
//        assertEquals(1, actualCreateResult.getUsers().size());
//        assertEquals(1L, actualCreateResult.getId().longValue());
//    }
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#getAll()}
//     */
//    @Test
//    void testGetAll() {
//        // Arrange
//        when(teamRepository.findAll()).thenReturn(new ArrayList<>());
//
//        // Act
//        List<TeamResponse> actualAll = teamServiceImplementation.getAll();
//
//        // Assert
//        verify(teamRepository).findAll();
//        assertTrue(actualAll.isEmpty());
//    }
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#getAll()}
//     */
//    @Test
//    void testGetAll2() {
//        // Arrange
//        TeamEntity teamEntity = new TeamEntity();
//        teamEntity.setBoards(new HashSet<>());
//        teamEntity.setId(1L);
//        teamEntity.setName("Name");
//        teamEntity.setUsers(new HashSet<>());
//
//        ArrayList<TeamEntity> teamEntityList = new ArrayList<>();
//        teamEntityList.add(teamEntity);
//
//        TeamEntity teamEntity2 = new TeamEntity();
//        teamEntity2.setBoards(new HashSet<>());
//        teamEntity2.setId(1L);
//        teamEntity2.setName("Name");
//        teamEntity2.setUsers(new HashSet<>());
//        Optional<TeamEntity> ofResult = Optional.of(teamEntity2);
//        when(teamRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
//        when(teamRepository.findAll()).thenReturn(teamEntityList);
//
//        // Act
//        List<TeamResponse> actualAll = teamServiceImplementation.getAll();
//
//        // Assert
//        verify(teamRepository).findById(eq(1L));
//        verify(teamRepository).findAll();
//        assertEquals(1, actualAll.size());
//        TeamResponse getResult = actualAll.get(0);
//        assertEquals("Name", getResult.getName());
//        assertEquals(1L, getResult.getId().longValue());
//        assertTrue(getResult.getUsers().isEmpty());
//    }
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#getAll()}
//     */
//    @Test
//    void testGetAll3() {
//        // Arrange
//        TeamEntity teamEntity = new TeamEntity();
//        teamEntity.setBoards(new HashSet<>());
//        teamEntity.setId(1L);
//        teamEntity.setName("Name");
//        teamEntity.setUsers(new HashSet<>());
//
//        ArrayList<TeamEntity> teamEntityList = new ArrayList<>();
//        teamEntityList.add(teamEntity);
//        TeamEntity teamEntity2 = mock(TeamEntity.class);
//        when(teamEntity2.getId()).thenReturn(1L);
//        when(teamEntity2.getName()).thenReturn("Name");
//        when(teamEntity2.getUsers()).thenReturn(new HashSet<>());
//        doNothing().when(teamEntity2).setBoards(Mockito.<Set<BoardEntity>>any());
//        doNothing().when(teamEntity2).setId(Mockito.<Long>any());
//        doNothing().when(teamEntity2).setName(Mockito.<String>any());
//        doNothing().when(teamEntity2).setUsers(Mockito.<Set<UserEntity>>any());
//        teamEntity2.setBoards(new HashSet<>());
//        teamEntity2.setId(1L);
//        teamEntity2.setName("Name");
//        teamEntity2.setUsers(new HashSet<>());
//        Optional<TeamEntity> ofResult = Optional.of(teamEntity2);
//        when(teamRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
//        when(teamRepository.findAll()).thenReturn(teamEntityList);
//
//        // Act
//        List<TeamResponse> actualAll = teamServiceImplementation.getAll();
//
//        // Assert
//        verify(teamEntity2).getId();
//        verify(teamEntity2).getName();
//        verify(teamEntity2).getUsers();
//        verify(teamEntity2).setBoards(isA(Set.class));
//        verify(teamEntity2).setId(eq(1L));
//        verify(teamEntity2).setName(eq("Name"));
//        verify(teamEntity2).setUsers(isA(Set.class));
//        verify(teamRepository).findById(eq(1L));
//        verify(teamRepository).findAll();
//        assertEquals(1, actualAll.size());
//        TeamResponse getResult = actualAll.get(0);
//        assertEquals("Name", getResult.getName());
//        assertEquals(1L, getResult.getId().longValue());
//        assertTrue(getResult.getUsers().isEmpty());
//    }
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#getAll()}
//     */
//    @Test
//    void testGetAll4() {
//        // Arrange
//        TeamEntity teamEntity = new TeamEntity();
//        teamEntity.setBoards(new HashSet<>());
//        teamEntity.setId(1L);
//        teamEntity.setName("Name");
//        teamEntity.setUsers(new HashSet<>());
//
//        ArrayList<TeamEntity> teamEntityList = new ArrayList<>();
//        teamEntityList.add(teamEntity);
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setBoards(new HashSet<>());
//        userEntity.setEmail("jane.doe@example.org");
//        userEntity.setId(1L);
//        userEntity.setName("Name");
//        userEntity.setPassword("iloveyou");
//        userEntity.setTeams(new HashSet<>());
//
//        HashSet<UserEntity> userEntitySet = new HashSet<>();
//        userEntitySet.add(userEntity);
//        TeamEntity teamEntity2 = mock(TeamEntity.class);
//        when(teamEntity2.getId()).thenReturn(1L);
//        when(teamEntity2.getName()).thenReturn("Name");
//        when(teamEntity2.getUsers()).thenReturn(userEntitySet);
//        doNothing().when(teamEntity2).setBoards(Mockito.<Set<BoardEntity>>any());
//        doNothing().when(teamEntity2).setId(Mockito.<Long>any());
//        doNothing().when(teamEntity2).setName(Mockito.<String>any());
//        doNothing().when(teamEntity2).setUsers(Mockito.<Set<UserEntity>>any());
//        teamEntity2.setBoards(new HashSet<>());
//        teamEntity2.setId(1L);
//        teamEntity2.setName("Name");
//        teamEntity2.setUsers(new HashSet<>());
//        Optional<TeamEntity> ofResult = Optional.of(teamEntity2);
//        when(teamRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
//        when(teamRepository.findAll()).thenReturn(teamEntityList);
//
//        // Act
//        List<TeamResponse> actualAll = teamServiceImplementation.getAll();
//
//        // Assert
//        verify(teamEntity2).getId();
//        verify(teamEntity2).getName();
//        verify(teamEntity2).getUsers();
//        verify(teamEntity2).setBoards(isA(Set.class));
//        verify(teamEntity2).setId(eq(1L));
//        verify(teamEntity2).setName(eq("Name"));
//        verify(teamEntity2).setUsers(isA(Set.class));
//        verify(teamRepository).findById(eq(1L));
//        verify(teamRepository).findAll();
//        assertEquals(1, actualAll.size());
//        TeamResponse getResult = actualAll.get(0);
//        assertEquals("Name", getResult.getName());
//        assertEquals(1, getResult.getUsers().size());
//        assertEquals(1L, getResult.getId().longValue());
//    }
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#getAll()}
//     */
//    @Test
//    void testGetAll5() {
//        // Arrange
//        TeamEntity teamEntity = new TeamEntity();
//        teamEntity.setBoards(new HashSet<>());
//        teamEntity.setId(1L);
//        teamEntity.setName("Name");
//        teamEntity.setUsers(new HashSet<>());
//
//        ArrayList<TeamEntity> teamEntityList = new ArrayList<>();
//        teamEntityList.add(teamEntity);
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setBoards(new HashSet<>());
//        userEntity.setEmail("jane.doe@example.org");
//        userEntity.setId(1L);
//        userEntity.setName("Name");
//        userEntity.setPassword("iloveyou");
//        userEntity.setTeams(new HashSet<>());
//
//        UserEntity userEntity2 = new UserEntity();
//        userEntity2.setBoards(new HashSet<>());
//        userEntity2.setEmail("john.smith@example.org");
//        userEntity2.setId(2L);
//        userEntity2.setName("42");
//        userEntity2.setPassword("Password");
//        userEntity2.setTeams(new HashSet<>());
//
//        HashSet<UserEntity> userEntitySet = new HashSet<>();
//        userEntitySet.add(userEntity2);
//        userEntitySet.add(userEntity);
//        TeamEntity teamEntity2 = mock(TeamEntity.class);
//        when(teamEntity2.getId()).thenReturn(1L);
//        when(teamEntity2.getName()).thenReturn("Name");
//        when(teamEntity2.getUsers()).thenReturn(userEntitySet);
//        doNothing().when(teamEntity2).setBoards(Mockito.<Set<BoardEntity>>any());
//        doNothing().when(teamEntity2).setId(Mockito.<Long>any());
//        doNothing().when(teamEntity2).setName(Mockito.<String>any());
//        doNothing().when(teamEntity2).setUsers(Mockito.<Set<UserEntity>>any());
//        teamEntity2.setBoards(new HashSet<>());
//        teamEntity2.setId(1L);
//        teamEntity2.setName("Name");
//        teamEntity2.setUsers(new HashSet<>());
//        Optional<TeamEntity> ofResult = Optional.of(teamEntity2);
//        when(teamRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
//        when(teamRepository.findAll()).thenReturn(teamEntityList);
//
//        // Act
//        List<TeamResponse> actualAll = teamServiceImplementation.getAll();
//
//        // Assert
//        verify(teamEntity2).getId();
//        verify(teamEntity2).getName();
//        verify(teamEntity2).getUsers();
//        verify(teamEntity2).setBoards(isA(Set.class));
//        verify(teamEntity2).setId(eq(1L));
//        verify(teamEntity2).setName(eq("Name"));
//        verify(teamEntity2).setUsers(isA(Set.class));
//        verify(teamRepository).findById(eq(1L));
//        verify(teamRepository).findAll();
//        assertEquals(1, actualAll.size());
//        TeamResponse getResult = actualAll.get(0);
//        assertEquals("Name", getResult.getName());
//        assertEquals(1L, getResult.getId().longValue());
//        assertEquals(2, getResult.getUsers().size());
//    }
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#getAll()}
//     */
//    @Test
//    void testGetAll6() {
//        // Arrange
//        TeamEntity teamEntity = new TeamEntity();
//        teamEntity.setBoards(new HashSet<>());
//        teamEntity.setId(1L);
//        teamEntity.setName("Name");
//        teamEntity.setUsers(new HashSet<>());
//
//        ArrayList<TeamEntity> teamEntityList = new ArrayList<>();
//        teamEntityList.add(teamEntity);
//        Optional<TeamEntity> emptyResult = Optional.empty();
//        when(teamRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
//        when(teamRepository.findAll()).thenReturn(teamEntityList);
//
//        // Act
//        List<TeamResponse> actualAll = teamServiceImplementation.getAll();
//
//        // Assert
//        verify(teamRepository).findById(eq(1L));
//        verify(teamRepository).findAll();
//        assertTrue(actualAll.isEmpty());
//    }
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#getAll()}
//     */
//    @Test
//    void testGetAll7() {
//        // Arrange
//        TeamEntity teamEntity = new TeamEntity();
//        teamEntity.setBoards(new HashSet<>());
//        teamEntity.setId(1L);
//        teamEntity.setName("Name");
//        teamEntity.setUsers(new HashSet<>());
//
//        TeamEntity teamEntity2 = new TeamEntity();
//        teamEntity2.setBoards(new HashSet<>());
//        teamEntity2.setId(2L);
//        teamEntity2.setName("42");
//        teamEntity2.setUsers(new HashSet<>());
//
//        ArrayList<TeamEntity> teamEntityList = new ArrayList<>();
//        teamEntityList.add(teamEntity2);
//        teamEntityList.add(teamEntity);
//        TeamEntity teamEntity3 = mock(TeamEntity.class);
//        when(teamEntity3.getId()).thenReturn(1L);
//        when(teamEntity3.getName()).thenReturn("Name");
//        when(teamEntity3.getUsers()).thenReturn(new HashSet<>());
//        doNothing().when(teamEntity3).setBoards(Mockito.<Set<BoardEntity>>any());
//        doNothing().when(teamEntity3).setId(Mockito.<Long>any());
//        doNothing().when(teamEntity3).setName(Mockito.<String>any());
//        doNothing().when(teamEntity3).setUsers(Mockito.<Set<UserEntity>>any());
//        teamEntity3.setBoards(new HashSet<>());
//        teamEntity3.setId(1L);
//        teamEntity3.setName("Name");
//        teamEntity3.setUsers(new HashSet<>());
//        Optional<TeamEntity> ofResult = Optional.of(teamEntity3);
//        when(teamRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
//        when(teamRepository.findAll()).thenReturn(teamEntityList);
//
//        // Act
//        List<TeamResponse> actualAll = teamServiceImplementation.getAll();
//
//        // Assert
//        verify(teamEntity3, atLeast(1)).getId();
//        verify(teamEntity3, atLeast(1)).getName();
//        verify(teamEntity3, atLeast(1)).getUsers();
//        verify(teamEntity3).setBoards(isA(Set.class));
//        verify(teamEntity3).setId(eq(1L));
//        verify(teamEntity3).setName(eq("Name"));
//        verify(teamEntity3).setUsers(isA(Set.class));
//        verify(teamRepository, atLeast(1)).findById(Mockito.<Long>any());
//        verify(teamRepository).findAll();
//        assertEquals(2, actualAll.size());
//        TeamResponse getResult = actualAll.get(0);
//        assertEquals("Name", getResult.getName());
//        assertEquals(1L, getResult.getId().longValue());
//        assertTrue(getResult.getUsers().isEmpty());
//        assertEquals(getResult, actualAll.get(1));
//    }
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#getAll()}
//     */
//    @Test
//    void testGetAll8() {
//        // Arrange
//        TeamEntity teamEntity = mock(TeamEntity.class);
//        when(teamEntity.getId()).thenReturn(1L);
//        doNothing().when(teamEntity).setBoards(Mockito.<Set<BoardEntity>>any());
//        doNothing().when(teamEntity).setId(Mockito.<Long>any());
//        doNothing().when(teamEntity).setName(Mockito.<String>any());
//        doNothing().when(teamEntity).setUsers(Mockito.<Set<UserEntity>>any());
//        teamEntity.setBoards(new HashSet<>());
//        teamEntity.setId(1L);
//        teamEntity.setName("Name");
//        teamEntity.setUsers(new HashSet<>());
//
//        ArrayList<TeamEntity> teamEntityList = new ArrayList<>();
//        teamEntityList.add(teamEntity);
//        TeamEntity teamEntity2 = mock(TeamEntity.class);
//        when(teamEntity2.getId()).thenReturn(1L);
//        when(teamEntity2.getName()).thenReturn("Name");
//        when(teamEntity2.getUsers()).thenReturn(new HashSet<>());
//        doNothing().when(teamEntity2).setBoards(Mockito.<Set<BoardEntity>>any());
//        doNothing().when(teamEntity2).setId(Mockito.<Long>any());
//        doNothing().when(teamEntity2).setName(Mockito.<String>any());
//        doNothing().when(teamEntity2).setUsers(Mockito.<Set<UserEntity>>any());
//        teamEntity2.setBoards(new HashSet<>());
//        teamEntity2.setId(1L);
//        teamEntity2.setName("Name");
//        teamEntity2.setUsers(new HashSet<>());
//        Optional<TeamEntity> ofResult = Optional.of(teamEntity2);
//        when(teamRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
//        when(teamRepository.findAll()).thenReturn(teamEntityList);
//
//        // Act
//        List<TeamResponse> actualAll = teamServiceImplementation.getAll();
//
//        // Assert
//        verify(teamEntity2).getId();
//        verify(teamEntity).getId();
//        verify(teamEntity2).getName();
//        verify(teamEntity2).getUsers();
//        verify(teamEntity2).setBoards(isA(Set.class));
//        verify(teamEntity).setBoards(isA(Set.class));
//        verify(teamEntity2).setId(eq(1L));
//        verify(teamEntity).setId(eq(1L));
//        verify(teamEntity2).setName(eq("Name"));
//        verify(teamEntity).setName(eq("Name"));
//        verify(teamEntity2).setUsers(isA(Set.class));
//        verify(teamEntity).setUsers(isA(Set.class));
//        verify(teamRepository).findById(eq(1L));
//        verify(teamRepository).findAll();
//        assertEquals(1, actualAll.size());
//        TeamResponse getResult = actualAll.get(0);
//        assertEquals("Name", getResult.getName());
//        assertEquals(1L, getResult.getId().longValue());
//        assertTrue(getResult.getUsers().isEmpty());
//    }
//
//    /**
//     * Method under test: {@link TeamServiceImplementation#deleteById(Long)}
//     */
//    @Test
//    void testDeleteById() {
//        // Arrange
//        doNothing().when(teamRepository).deleteById(Mockito.<Long>any());
//
//        // Act
//        teamServiceImplementation.deleteById(1L);
//
//        // Assert that nothing has changed
//        verify(teamRepository).deleteById(eq(1L));
//    }
//}
