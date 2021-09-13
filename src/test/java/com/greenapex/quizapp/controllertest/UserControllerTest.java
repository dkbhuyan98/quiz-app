package com.greenapex.quizapp.controllertest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenapex.quizapp.controller.UserController;
import com.greenapex.quizapp.entity.UserModule;
import com.greenapex.quizapp.service.UserService;

@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes= {UserControllerTest.class})
public class UserControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;
    
    @BeforeEach
    public void setUp() {
    	mockMvc=MockMvcBuilders.standaloneSetup(userController).build();
    }
    
    @Test
    @Order(1)
    public void insertUserTest() throws Exception {
    	UserModule user = new UserModule();
        user.setUser_id(1);
        user.setUsername("Deepak");
        user.setEmail("dkb@green.com");
        user.setPassword("Dk23");
        
       when(userService.insertUser(user)).thenReturn(user);
       ObjectMapper mapper=new ObjectMapper();
       String jsonbody=mapper.writeValueAsString(user);
       this.mockMvc.perform(post("/insertuser")
    		                    .accept(MediaType.APPLICATION_JSON)
    		                    .content(jsonbody)
    		                    .contentType(MediaType.APPLICATION_JSON)
    		                    )
                    .andExpect(status().isOk())
                    .andDo(print());
       System.out.println("User added Successfully");
    } 
    
    @Test
    @Order(2)
    public void updateUserTest() throws Exception {
    	UserModule user = new UserModule();
        user.setUser_id(1);
        user.setUsername("Deepak Kumar");
        user.setEmail("dkb@green.com");
        user.setPassword("Dk23");
        
       when(userService.updateUser(user)).thenReturn(user);
       ObjectMapper mapper=new ObjectMapper();
       String jsonbody=mapper.writeValueAsString(user);
       this.mockMvc.perform(put("/updateuser")
    		                    .accept(MediaType.APPLICATION_JSON)
    		                    .content(jsonbody)
    		                    .contentType(MediaType.APPLICATION_JSON)
    		                    )
                    .andExpect(status().isOk())
                    .andDo(print());
       System.out.println("User Updated Successfully");
    } 
    
    @Test
    @Order(3)
    public void getUserByIdTest() throws Exception{
        UserModule user = new UserModule(1,"Sachi","sac@gmail.com","sc123");
       
        when(userService.getUserById(1)).thenReturn(user);
        
        this.mockMvc.perform(get("/getuserbyid/{user_id}",1))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath(".user_id").value(1))
                    .andExpect(MockMvcResultMatchers.jsonPath(".username").value("Sachi"))
                    .andExpect(MockMvcResultMatchers.jsonPath(".email").value("sac@gmail.com"))
                    .andExpect(MockMvcResultMatchers.jsonPath(".password").value("sc123"))
                    .andDo(print());   
    }
    
    @Test
	@Order(4)
	public void getAllUserTest() throws Exception {
    	UserModule user = new UserModule();
        user.setUser_id(1);
        user.setUsername("Deepak Kumar");
        user.setEmail("dkb@green.com");
        user.setPassword("Dk23");
        
        UserModule user1 = new UserModule();
        user1.setUser_id(2);
        user1.setUsername("Soumya");
        user1.setEmail("sm@green.com");
        user1.setPassword("Sou23");
        
		List<UserModule> users=new ArrayList<>();
		users.add(user);
		users.add(user1);
		
		when(userService.getAllUser()).thenReturn(users);
		this.mockMvc.perform(get("/getalluser"))
				                 .andExpect(status().isOk())
				                 .andDo(print());
    }
    
}