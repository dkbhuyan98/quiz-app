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

import com.greenapex.quizapp.entity.UserModule;
import com.greenapex.quizapp.repository.UserRepository;
import com.greenapex.quizapp.service.UserService;

@SpringBootTest(classes= {UserServiceTest.class})
public class UserServiceTest {
	@Mock
	UserRepository userRepo;
	
	@InjectMocks
	UserService userService;
	
    @Test
    @Order(1)
    public void test_insertUser() {
     UserModule user = new UserModule();
     user.setUser_id(1);
     user.setUsername("Deepak Kumar");
     user.setEmail("dkb@green.com");
     user.setPassword("dk1234");
     
     when(userRepo.save(user)).thenReturn(user);
     assertEquals(user,userService.insertUser(user));
    }
    
    @Test
    @Order(2)
    public void test_updateUser() {
     UserModule user = new UserModule();
     user.setUser_id(3);
     user.setUsername("Deepak");
     user.setEmail("dkb@green.com");
     user.setPassword("Dk1234");
     
     when(userRepo.save(user)).thenReturn(user);
     assertEquals(user,userService.updateUser(user));
    }
    
	@Test
	@Order(3)
	public void test_getAllUser() {
		List<UserModule> user=new ArrayList<UserModule>();
		user.add(new UserModule(1,"Deepak","dkb@gmail.com","1234"));
		user.add(new UserModule(2,"Soumya","sm@gmail.com","sou1234"));
		
		when(userRepo.findAll()).thenReturn(user);
		assertEquals(user,userService.getAllUser());
	}
	
	@Test
    @Order(4)
    public void test_getUserById(){
        UserModule user = new UserModule(1,"Sachi","sac@gmail.com","sc123");
        Optional<UserModule> user1 = Optional.ofNullable(user);
       
        when(userRepo.findById(1)).thenReturn(user1);
        assertEquals(user,userService.getUserById(1));
    }
}