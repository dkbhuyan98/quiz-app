package com.greenapex.quizapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greenapex.quizapp.entity.UserModule;
import com.greenapex.quizapp.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    UserRepository userRepo;
    
       public UserModule insertUser(UserModule user) {
	    userRepo.save(user);
		return user;
		}

		public UserModule updateUser(UserModule user) {
			userRepo.save(user);
			return user;
		}
		
		public UserModule getUserById(Integer user_id) {
		        Optional<UserModule> result = userRepo.findById(user_id);
		        UserModule user = null;
		        if(result.isPresent())
		            user = result.get();
		        else
		            throw new RuntimeException("Didn't find User with Id "+user_id);
		       
		        return user;
		    }
		
		public List<UserModule> getAllUser() {
			List<UserModule> disp=userRepo.findAll();
			return disp ;
		}	
		
}