package com.greenapex.quizapp.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.greenapex.quizapp.entity.AnswerModule;
import com.greenapex.quizapp.repository.AnswerRepository;
import com.greenapex.quizapp.service.AnswerService;

@SpringBootTest(classes= {AnswerServiceTest.class})
public class AnswerServiceTest {
	@Mock
	AnswerRepository answerRepo;
	
	@InjectMocks
	AnswerService ansService;
	
	@Test
	@Order(1)
    public void test_insertAnswer() {
        AnswerModule answer = new AnswerModule();
        answer.setAnswer_id(1);
        answer.setAnswer("JDK");
        answer.setIs_correct(true);
        answer.setQuestion_id(1);

        when(answerRepo.save(answer)).thenReturn(answer);
        assertEquals(answer,ansService.addAnswer(answer));
     }
	
	 @Test
	 @Order(2)
	 public void test_updateAnswer() {
		 AnswerModule answer = new AnswerModule();
	     answer.setAnswer_id(1);
	     answer.setAnswer("JRE");
	     answer.setIs_correct(true);
	     answer.setQuestion_id(1);

	     when(answerRepo.save(answer)).thenReturn(answer);
	     assertEquals(answer,ansService.updateAnswer(answer));
	 }
	 
	 @Test
	 @Order(3)
	 public void test_getAnswer() {
	     AnswerModule answer = new AnswerModule();
	     answer.setAnswer_id(1);
	     answer.setAnswer("Dynamic");
	     answer.setIs_correct(true);
	     answer.setQuestion_id(1);
	     
	     Optional<AnswerModule> answer1 = Optional.ofNullable(answer);
	     when(answerRepo.findById(1)).thenReturn(answer1);
	     assertEquals(answer,ansService.getAnswerById(1));
	  }
	 
	 @Test
	 @Order(4)
	 public void test_getAnsByQuestionId() {
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
		  
		  when(answerRepo.findAnswerByQuestion_id(1)).thenReturn(answers);
		  assertEquals(answers, ansService.getAnswer(1));
	   }

}