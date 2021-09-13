package com.greenapex.quizapp.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.greenapex.quizapp.entity.UserQuiz;
import com.greenapex.quizapp.repository.UserQuizRepository;
import com.greenapex.quizapp.service.UserQuizService;

@SpringBootTest(classes= {UserServiceTest.class})
public class UserQuizServiceTest {
	@Mock
	UserQuizRepository userquizRepo;
	
	@InjectMocks
	UserQuizService userquizService;
	
	@Test
	@Order(1)
	public void test_insertUserQuiz() {
	UserQuiz userquiz = new UserQuiz();
	userquiz.setId(1);
	userquiz.setUser_id(3);
	userquiz.setQuiz_id(2);
	
	when(userquizRepo.save(userquiz)).thenReturn(userquiz);
	assertEquals(userquiz,userquizService.insertUserquiz(userquiz));
	}
	
	@Test
	@Order(2)
	public void test_updateUserQuiz() {
	UserQuiz userquiz = new UserQuiz();
	userquiz.setId(1);
	userquiz.setUser_id(3);
	userquiz.setQuiz_id(1);
	
	when(userquizRepo.save(userquiz)).thenReturn(userquiz);
	assertEquals(userquiz,userquizService.updateUserquiz(userquiz));
	}
	
	@Test
	@Order(3)
	public void test_displayByUserId() {	
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
		
		when(userquizRepo.findByUserId(1)).thenReturn(userlist);
		assertEquals(userlist, userquizService.displayById(1));
	}
	
	@Test
	@Order(4)
	public void test_getAllUserQuiz() {
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
		
		when(userquizRepo.findAll()).thenReturn(userlist);
		assertEquals(userlist,userquizService.displayAll());
	}

}
