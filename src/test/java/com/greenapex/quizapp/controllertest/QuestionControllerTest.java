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
import com.greenapex.quizapp.controller.QuestionController;
import com.greenapex.quizapp.entity.QuestionModule;
import com.greenapex.quizapp.service.QuestionService;

@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes= {QuestionControllerTest.class})
public class QuestionControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private QuestionController questionController;
    
    @BeforeEach
    public void setUp() {
    	mockMvc=MockMvcBuilders.standaloneSetup(questionController).build();
    }
    
    @Test
    @Order(1)
    public void addQuestionTest() throws Exception {
    	QuestionModule question = new QuestionModule();
        question.setQuestion_id(1);
        question.setQuestion("What is used to find and fix bugs in the java programs? (A)JVM (B)JRE (C)JDK (D)JDB");
        question.setQuiz_id(1);  
        
     when(questionService.addQuestion(question)).thenReturn(question);
     ObjectMapper mapper=new ObjectMapper();
     String jsonbody=mapper.writeValueAsString(question);
     this.mockMvc.perform(post("/addquestion")
  		                    .accept(MediaType.APPLICATION_JSON)
  		                    .content(jsonbody)
  		                    .contentType(MediaType.APPLICATION_JSON)
  		                    )
                  .andExpect(status().isOk())
                  .andDo(print());
     System.out.println("Question added Successfully");
   }
    
    @Test
    @Order(2)
    public void updateQuestionTest() throws Exception {
    	QuestionModule question = new QuestionModule();
        question.setQuestion_id(1);
        question.setQuestion("Java is a Successor to which programming language? (A) C (B) C++ (C) Python (D) Perl");
        question.setQuiz_id(1);   
     
     when(questionService.updateQuestion(question)).thenReturn(question);
     ObjectMapper mapper=new ObjectMapper();
     String jsonbody=mapper.writeValueAsString(question);
     this.mockMvc.perform(put("/updatequestion")
  		                    .accept(MediaType.APPLICATION_JSON)
  		                    .content(jsonbody)
  		                    .contentType(MediaType.APPLICATION_JSON)
  		                    )
                  .andExpect(status().isOk())
                  .andDo(print());
     System.out.println("Question updated Successfully");
   }
	
    @Test
    @Order(3)
    public void getQuestionByIdTest() throws Exception {
    	QuestionModule question = new QuestionModule();
        question.setQuestion_id(2);
        question.setQuestion("Java is a Successor to which programming language? (A) C (B) C++ (C) Python (D) Perl");
        question.setQuiz_id(1);   
        
        when(questionService.getQuestionById(2)).thenReturn(question);
        this.mockMvc.perform(get("/getquestionbyid/{question_id}",2))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath(".question_id").value(2))
                    .andExpect(MockMvcResultMatchers.jsonPath(".question").value("Java is a Successor to which programming language? (A) C (B) C++ (C) Python (D) Perl"))
                    .andExpect(MockMvcResultMatchers.jsonPath(".quiz_id").value(1))
                    .andDo(print());   
    }
    
    @Test
    @Order(4)
    public void getQuestionByQuizIdTest() throws Exception {
        QuestionModule question = new QuestionModule();
        question.setQuestion_id(1);
        question.setQuestion("Java language was originally developed for operating? (A)TV (B)TV Set-top box (C)Embedded System equipment (D)All the above");
        question.setQuiz_id(1);
        
        QuestionModule question1 = new QuestionModule();
        question.setQuestion_id(2);
        question.setQuestion("Byte code is the result of? (A)Compiling a Java file (B)Compiling a Class file (C)Interpreting a Java file (D)Interpreting a Class file");
        question.setQuiz_id(1);

        List<QuestionModule> questions = new ArrayList<>();
        questions.add(question);
        questions.add(question1);
        
        when(questionService.getAllQuestion(1)).thenReturn(questions);
        this.mockMvc.perform(get("/getquestionbyquizid/{quiz_id}",1))
                    .andExpect(status().isOk())
                    .andDo(print());        
     }
   
}
