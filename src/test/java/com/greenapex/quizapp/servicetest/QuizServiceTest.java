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

import com.greenapex.quizapp.entity.QuizModule;
import com.greenapex.quizapp.repository.QuizRepository;
import com.greenapex.quizapp.service.QuizService;

@SpringBootTest(classes= {QuizServiceTest.class})
public class QuizServiceTest {
	@Mock
    QuizRepository quizRepo;
	
	@InjectMocks
	QuizService quizService;
	
	@Test
    @Order(1)
    public void test_createQuiz() {
     QuizModule quiz = new QuizModule();
     quiz.setQuiz_id(1);
     quiz.setQuiz_name("Science");
     
     when(quizRepo.save(quiz)).thenReturn(quiz);
     assertEquals(quiz,quizService.createQuiz(quiz));
    }
	
	@Test
    @Order(2)
    public void test_updateQuiz() {
     QuizModule quiz = new QuizModule();
     quiz.setQuiz_id(1);
     quiz.setQuiz_name("GK");
     
     when(quizRepo.save(quiz)).thenReturn(quiz);
     assertEquals(quiz,quizService.updateQuiz(quiz));
    }
	
	@Test
	@Order(3)
	public void test_getAllQuiz() {
		List<QuizModule> quiz=new ArrayList<QuizModule>();
		quiz.add(new QuizModule(1,"Science"));
		
		when(quizRepo.findAll()).thenReturn(quiz);
		assertEquals(quiz,quizService.getAllQuiz());
	}
	
	@Test
    @Order(4)
    public void test_getQuizById() {
        QuizModule quiz = new QuizModule(1,"Java");
        Optional<QuizModule> quiz1 = Optional.ofNullable(quiz);
       
        when(quizRepo.findById(1)).thenReturn(quiz1);
        assertEquals(quiz,quizService.getQuizById(1));
    }

}
