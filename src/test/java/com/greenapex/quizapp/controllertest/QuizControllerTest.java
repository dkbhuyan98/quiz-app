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
import com.greenapex.quizapp.controller.QuizController;
import com.greenapex.quizapp.entity.QuizModule;
import com.greenapex.quizapp.service.QuizService;

@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes= {QuizControllerTest.class})
public class QuizControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @Mock
    private QuizService quizService;

    @InjectMocks
    private QuizController quizController;
    
    @BeforeEach
    public void setUp() {
    	mockMvc=MockMvcBuilders.standaloneSetup(quizController).build();
    }
    
    @Test
    @Order(1)
    public void createQuizTest() throws Exception {
     QuizModule quiz = new QuizModule();
     quiz.setQuiz_id(1);
     quiz.setQuiz_name("Science");
     
     when(quizService.createQuiz(quiz)).thenReturn(quiz);
     ObjectMapper mapper=new ObjectMapper();
     String jsonbody=mapper.writeValueAsString(quiz);
     this.mockMvc.perform(post("/createquiz")
  		                    .accept(MediaType.APPLICATION_JSON)
  		                    .content(jsonbody)
  		                    .contentType(MediaType.APPLICATION_JSON)
  		                    )
                  .andExpect(status().isOk())
                  .andDo(print());
     System.out.println("Quiz Created Successfully");
   } 
    
    @Test
    @Order(2)
    public void updateQuizTest() throws Exception {
     QuizModule quiz = new QuizModule();
     quiz.setQuiz_id(1);
     quiz.setQuiz_name("General Knowledge");
     
     when(quizService.updateQuiz(quiz)).thenReturn(quiz);
     ObjectMapper mapper=new ObjectMapper();
     String jsonbody=mapper.writeValueAsString(quiz);
     this.mockMvc.perform(put("/updatequiz")
  		                    .accept(MediaType.APPLICATION_JSON)
  		                    .content(jsonbody)
  		                    .contentType(MediaType.APPLICATION_JSON)
  		                    )
                  .andExpect(status().isOk())
                  .andDo(print());
     System.out.println("Quiz Updated Successfully");
   } 
    
    @Test
    @Order(3)
    public void getQuizByIdTest() throws Exception{
        QuizModule quiz = new QuizModule(1,"Java");
       
        when(quizService.getQuizById(1)).thenReturn(quiz);
        
        this.mockMvc.perform(get("/getquizbyid/{quiz_id}",1))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath(".quiz_id").value(1))
                    .andExpect(MockMvcResultMatchers.jsonPath(".quiz_name").value("Java"))
                    .andDo(print());   
    }
    
    @Test
	@Order(4)
	public void getAllQuizTest() throws Exception {
    	 QuizModule quiz1 = new QuizModule();
         quiz1.setQuiz_id(1);
         quiz1.setQuiz_name("Java");
         
         QuizModule quiz2 = new QuizModule();
         quiz2.setQuiz_id(2);
         quiz2.setQuiz_name("Python");
         
		List<QuizModule> quiz=new ArrayList<>();
		quiz.add(quiz1);
		quiz.add(quiz2);
		
		when(quizService.getAllQuiz()).thenReturn(quiz);
		this.mockMvc.perform(get("/getallquiz"))
				                 .andExpect(status().isOk())
				                 .andDo(print());
    } 

}