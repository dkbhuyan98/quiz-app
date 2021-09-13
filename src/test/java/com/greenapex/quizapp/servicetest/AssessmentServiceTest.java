package com.greenapex.quizapp.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.greenapex.quizapp.entity.AssessmentModule;
import com.greenapex.quizapp.repository.AssessmentRepository;
import com.greenapex.quizapp.service.AssessmentService;

@SpringBootTest(classes= {AssessmentServiceTest.class})
public class AssessmentServiceTest {
	@Mock
	AssessmentRepository assessmentRepo;
	
	@InjectMocks
	AssessmentService assessmentService;
	
	@Test
	@Order(1)
    public void test_addAssessment() {
        AssessmentModule assessment = new AssessmentModule();
        assessment.setUser_id(1);
        assessment.setAnswer_id(1);

        when(assessmentRepo.save(assessment)).thenReturn(assessment);
        assertEquals(assessment,assessmentService.addAssessment(assessment));
    }
	
	@Test
	@Order(2)
    public void test_AssessmentByUserId() {
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
      
       when(assessmentRepo.assessmentDetail(1)).thenReturn(asslist);
       assertEquals(asslist,assessmentService.assessmentRes(1));
	}
	
	@Test
	@Order(3)
    public void test_AssessmentByUseridQuizid() {
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
       
       when(assessmentRepo.assessmentDetails(1, 1)).thenReturn(asslist);
       assertEquals(asslist,assessmentService.displayAllAss(1, 1));
	}
	
}
