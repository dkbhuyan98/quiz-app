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
import com.greenapex.quizapp.controller.AnswerController;
import com.greenapex.quizapp.entity.AnswerModule;
import com.greenapex.quizapp.service.AnswerService;

@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes= {AnswerControllerTest.class})
public class AnswerControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @Mock
    private AnswerService answerService;

    @InjectMocks
    private AnswerController answerController;
    
    @BeforeEach
    public void setUp() {
    	mockMvc=MockMvcBuilders.standaloneSetup(answerController).build();
    }
    
    @Test
	@Order(1)
    public void insertAnswerTest() throws Exception {
        AnswerModule answer = new AnswerModule();
        answer.setAnswer_id(1);
        answer.setAnswer("JDK");
        answer.setIs_correct(true);
        answer.setQuestion_id(1);

        when(answerService.addAnswer(answer)).thenReturn(answer);
        ObjectMapper mapper=new ObjectMapper();
        String jsonbody=mapper.writeValueAsString(answer);
        this.mockMvc.perform(post("/addanswer")
     		                    .accept(MediaType.APPLICATION_JSON)
     		                    .content(jsonbody)
     		                    .contentType(MediaType.APPLICATION_JSON)
     		                    )
                     .andExpect(status().isOk())
                     .andDo(print());
        System.out.println("Answer added Successfully");
    }
     
    @Test
	@Order(2)
    public void updateAnswerTest() throws Exception {
        AnswerModule answer = new AnswerModule();
        answer.setAnswer_id(1);
        answer.setAnswer("JRE");
        answer.setIs_correct(true);
        answer.setQuestion_id(1);

        when(answerService.updateAnswer(answer)).thenReturn(answer);
        ObjectMapper mapper=new ObjectMapper();
        String jsonbody=mapper.writeValueAsString(answer);
        this.mockMvc.perform(put("/updateanswer")
     		                    .accept(MediaType.APPLICATION_JSON)
     		                    .content(jsonbody)
     		                    .contentType(MediaType.APPLICATION_JSON)
     		                    )
                     .andExpect(status().isOk())
                     .andDo(print());
        System.out.println("Answer Updted Successfully");
    }
    
    @Test
    @Order(3)
    public void getAnswerByIdTest() throws Exception {
    	AnswerModule answer = new AnswerModule();
	    answer.setAnswer_id(1);
	    answer.setAnswer("Dynamic");
	    answer.setIs_correct(true);
	    answer.setQuestion_id(1);
	    
	    when(answerService.getAnswerById(1)).thenReturn(answer);
        this.mockMvc.perform(get("/getanswerbyansid/{answer_id}",1))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath(".answer_id").value(1))
                    .andExpect(MockMvcResultMatchers.jsonPath(".answer").value("Dynamic"))
                    .andExpect(MockMvcResultMatchers.jsonPath(".is_correct").value(true))
                    .andExpect(MockMvcResultMatchers.jsonPath(".question_id").value(1))
                    .andDo(print());   
    }
    
    @Test
    @Order(4)
    public void getQuestionByQuizIdTest() throws Exception {
    	  AnswerModule answer = new AnswerModule();
		  answer.setAnswer_id(1);
		  answer.setAnswer("C");
		  answer.setQuestion_id(1);
		  answer.setIs_correct(false);
		  
		  AnswerModule answer1 = new AnswerModule();
		  answer1.setAnswer_id(2);
		  answer1.setAnswer("C++");
		  answer1.setQuestion_id(1);
		  answer1.setIs_correct(true);
		  
		  AnswerModule answer2 = new AnswerModule();
		  answer2.setAnswer_id(3);
		  answer2.setAnswer("Python");
		  answer2.setQuestion_id(1);
		  answer2.setIs_correct(false);
		  
		  AnswerModule answer3 = new AnswerModule();
		  answer3.setAnswer_id(4);
		  answer3.setAnswer("Perl");
		  answer3.setQuestion_id(1);
		  answer3.setIs_correct(false);
		 
		  List<AnswerModule> answers = new ArrayList<>();
		  answers.add(answer);
		  answers.add(answer1);
		  answers.add(answer2);
		  answers.add(answer3);
		  
		  when(answerService.getAnswer(1)).thenReturn(answers);
		  this.mockMvc.perform(get("/getanswerbyqnid/{question_id}",1))
                      .andExpect(status().isOk())
                      .andDo(print());
    }
    
}
