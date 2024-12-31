package com.example.carbooking.controller;

import com.example.carbooking.entities.UserEntity;
import com.example.carbooking.exception.ConflictException;
import com.example.carbooking.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    @Mock
    private UserServiceImpl userServiceImpl;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;
    private UserEntity userEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        userEntity = new UserEntity();
        userEntity.setCustomerid(1);
        userEntity.setName("John Doe");
    }

    /*@Test
    void testCreateUser_Success() throws Exception {
        // Arrange
        when(userServiceImpl.create(userEntity)).thenReturn(userEntity);

        // Act & Assert
        mockMvc.perform(post("/api/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userEntity)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerid").value(1))
                .andExpect(jsonPath("$.name").value("John Doe"));

        verify(userServiceImpl, times(1)).create(userEntity);
    }*/

    /*@Test
    void testCreateUser_UserAlreadyExists() throws Exception {
        // Arrange
        when(userServiceImpl.create(userEntity)).thenThrow(new ConflictException("User already exists"));

        // Act & Assert
        mockMvc.perform(post("/api/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userEntity)))
                .andExpect(status().isConflict())
                .andExpect(content().string("User already exists"));

        verify(userServiceImpl, times(1)).create(userEntity);
    }*/

    @Test
    void testGetUserById_Success() throws Exception {
        // Arrange
        when(userServiceImpl.getById(1)).thenReturn(userEntity);

        // Act & Assert
        mockMvc.perform(get("/api/user/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerid").value(1))
                .andExpect(jsonPath("$.name").value("John Doe"));

        verify(userServiceImpl, times(1)).getById(1);
    }

    /*@Test
    void testGetUserById_UserNotFound() throws Exception {
        // Arrange
        when(userServiceImpl.getById(1)).thenThrow(new ConflictException("Add the User details"));

        // Act & Assert
        mockMvc.perform(get("/api/user/{id}", 1))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Add the User details"));

        verify(userServiceImpl, times(1)).getById(1);
    }*/


}