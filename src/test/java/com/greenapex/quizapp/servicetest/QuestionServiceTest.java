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
import com.greenapex.quizapp.entity.QuestionModule;
import com.greenapex.quizapp.repository.QuestionRepository;
import com.greenapex.quizapp.service.QuestionService;

@SpringBootTest(classes= {QuestionServiceTest.class})
public class QuestionServiceTest {
	@Mock
	QuestionRepository questionRepo;
	
	@InjectMocks
	QuestionService questionService;
	
    @Test
    @Order(1)
    public void test_addQuestion() {
		QuestionModule question = new QuestionModule(1,"What is used to find and fix bugs in the java programs? (A)JVM (B)JRE (C)JDK (D)JDB", 1);
		when(questionRepo.save(question)).thenReturn(question);
		assertEquals(question,questionService.addQuestion(question));
	}
    
    @Test
    @Order(2)
    public void test_updateQuestion() {
		QuestionModule question = new QuestionModule(1,"What is used to find and fix bugs in the java programs? (A)JVM (B)JRE (C)JDK (D)JDB", 1);
		when(questionRepo.save(question)).thenReturn(question);
		assertEquals(question,questionService.updateQuestion(question));
	}
    
    @Test
    @Order(3)
    public void test_getQuestionById() {
    	QuestionModule question = new QuestionModule(2,"Java is a Successor to which programming language? (A) C (B) C++ (C) Python (D) Perl ",1);
    	Optional<QuestionModule> optional = Optional.ofNullable(question);

    	when(questionRepo.findById(2)).thenReturn(optional);
    	assertEquals(question,questionService.getQuestionById(2));
    }
    
    @Test
    @Order(4)
    public void test_getQuestionByQuizId() {
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

        when(questionRepo.findQuestionByQuiz_id(1)).thenReturn(questions);
        assertEquals(questions,questionService.getAllQuestion(1));
    }

}
