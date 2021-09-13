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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenapex.quizapp.controller.UserQuizController;
import com.greenapex.quizapp.entity.UserQuiz;
import com.greenapex.quizapp.service.UserQuizService;

@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes= {UserQuizControllerTest.class})
public class UserQuizControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @Mock
    private UserQuizService userquizService;

    @InjectMocks
    private UserQuizController userquizController;
    
    @BeforeEach
    public void setUp() {
    	mockMvc=MockMvcBuilders.standaloneSetup(userquizController).build();
    }
    @Test
	@Order(1)
	public void insertUserQuizTest() throws Exception {
	UserQuiz userquiz = new UserQuiz();
	userquiz.setId(1);
	userquiz.setUser_id(3);
	userquiz.setQuiz_id(2);
	
	when(userquizService.insertUserquiz(userquiz)).thenReturn(userquiz);
    ObjectMapper mapper=new ObjectMapper();
    String jsonbody=mapper.writeValueAsString(userquiz);
    this.mockMvc.perform(post("/adduserquiz")
 		                    .accept(MediaType.APPLICATION_JSON)
 		                    .content(jsonbody)
 		                    .contentType(MediaType.APPLICATION_JSON)
 		                    )
                 .andExpect(status().isOk())
                 .andDo(print());
    }
    
    @Test
	@Order(2)
	public void updateUserQuizTest() throws Exception {
	UserQuiz userquiz = new UserQuiz();
	userquiz.setId(1);
	userquiz.setUser_id(3);
	userquiz.setQuiz_id(1);
	
	when(userquizService.updateUserquiz(userquiz)).thenReturn(userquiz);
    ObjectMapper mapper=new ObjectMapper();
    String jsonbody=mapper.writeValueAsString(userquiz);
    this.mockMvc.perform(put("/updateuserquiz")
 		                    .accept(MediaType.APPLICATION_JSON)
 		                    .content(jsonbody)
 		                    .contentType(MediaType.APPLICATION_JSON)
 		                    )
                 .andExpect(status().isOk())
                 .andDo(print());
    }
	
    @Test
	@Order(3)
	public void displayByUserIdTest() throws Exception {	
		UserQuiz userquiz = new UserQuiz();
		userquiz.setId(2);
		userquiz.setUser_id(1);
		userquiz.setQuiz_id(1);
		
		UserQuiz userquiz1 = new UserQuiz();
		userquiz.setId(3);
		userquiz.setUser_id(1);
		userquiz.setQuiz_id(2);
		
		List<UserQuiz> userlist = new ArrayList<>();
		userlist.add(userquiz);
		userlist.add(userquiz1);
		
		 when(userquizService.displayById(1)).thenReturn(userlist);
	        this.mockMvc.perform(get("/getuserquizbyid/{user_id}",1))
	                    .andExpect(status().isOk())
	                    .andDo(print());        
    }
    
    @Test
	@Order(4)
	public void getAllUserQuizTest() throws Exception {
		UserQuiz userquiz=new UserQuiz();
		userquiz.setId(5);
		userquiz.setUser_id(3);
		userquiz.setQuiz_id(1);
		
		UserQuiz userquiz1=new UserQuiz();
		userquiz.setId(6);
		userquiz.setUser_id(3);
		userquiz.setQuiz_id(2);
		
		List<UserQuiz> userlist=new ArrayList<>();
		userlist.add(userquiz);
		userlist.add(userquiz1);
		
		when(userquizService.displayAll()).thenReturn(userlist);
		this.mockMvc.perform(get("/alluserquiz"))
				                 .andExpect(status().isOk())
				                 .andDo(print());
    }

}
