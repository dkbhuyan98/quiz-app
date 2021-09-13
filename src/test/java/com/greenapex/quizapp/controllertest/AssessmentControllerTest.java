package com.greenapex.quizapp.controllertest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import com.greenapex.quizapp.controller.AssessmentController;
import com.greenapex.quizapp.entity.AssessmentModule;
import com.greenapex.quizapp.service.AssessmentService;

@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes= {AssessmentControllerTest.class})
public class AssessmentControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @Mock
    private AssessmentService assessmentService;

    @InjectMocks
    private AssessmentController assessmentController;
    
    @BeforeEach
    public void setUp() {
    	mockMvc=MockMvcBuilders.standaloneSetup(assessmentController).build();
    }
    
    @Test
    @Order(1)
    public void addAssessmentTest() throws Exception {
    	AssessmentModule assessment = new AssessmentModule();
        assessment.setUser_id(1);
        assessment.setAnswer_id(1);
        
        when(assessmentService.addAssessment(assessment)).thenReturn(assessment);
        ObjectMapper mapper=new ObjectMapper();
        String jsonbody=mapper.writeValueAsString(assessment);
        this.mockMvc.perform(post("/addassessment")
     		                    .accept(MediaType.APPLICATION_JSON)
     		                    .content(jsonbody)
     		                    .contentType(MediaType.APPLICATION_JSON)
     		                    )
                     .andExpect(status().isOk())
                     .andDo(print());
        System.out.println("Assessment added Successfully");
      
    }
    
    @Test
	@Order(2)
    public void getAssessmentByUserIdTest() throws Exception {
	   Map<String,Object> ass1= new HashMap<String,Object>();
       ass1.put("username", "Deepak");
       ass1.put("quiz_id","1");
       ass1.put("question","Java is a Successor to which programming language? (A) C (B)C++ (C)Python (D)D");
       ass1.put("answer","Python");
       ass1.put("is_correct",true);
       
       Map<String,Object> ass2= new HashMap<String,Object>();
       ass2.put("username", "Deepak");
       ass2.put("quiz_id","2");
       ass2.put("question","Which among the following is not a Data Type in Java? (A)short (B)int (C)long double (D)double");
       ass2.put("answer","long double");
       ass2.put("is_correct",true);
	   
       ArrayList<Map<String, Object>> asslist= new ArrayList<>();
       asslist.add(ass1);
       asslist.add(ass2);
       
       when(assessmentService.assessmentRes(1)).thenReturn(asslist);
       this.mockMvc.perform(get("/assessmentresult/{user_id}",1))
                   .andExpect(status().isOk())
                   .andDo(print());        
    }
    
    @Test
	@Order(3)
    public void assessmentByUseridQuizidTest() throws Exception {
	   Map<String,Object> ass1= new HashMap<String,Object>();
       ass1.put("username", "Deepak");
       ass1.put("quiz_id","1");
       ass1.put("question","Java is a Successor to which programming language? (A) C (B)C++ (C)Python (D)D");
       ass1.put("answer","Python");
       ass1.put("is_correct",true);
       
       Map<String,Object> ass2= new HashMap<String,Object>();
       ass2.put("username", "Deepak");
       ass2.put("quiz_id","1");
       ass2.put("question","What is the precision after decimal points offered by a float data type in Java? (A)3 digits (B)6 digits (C)10 digits (D)15 digits");
       ass2.put("answer","3 digits");
       ass2.put("is_correct",false);
	   
       ArrayList<Map<String, Object>> asslist= new ArrayList<>();
       asslist.add(ass1);
       asslist.add(ass2);
       
       when(assessmentService.displayAllAss(1, 1)).thenReturn(asslist);
       this.mockMvc.perform(get("/allassessmentbyid/{user_id}/{quiz_id}",1,1))
                   .andExpect(status().isOk())
                   .andDo(print());        
    }

}