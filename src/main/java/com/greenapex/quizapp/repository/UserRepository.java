package com.greenapex.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.greenapex.quizapp.entity.UserModule;

@Repository
public interface UserRepository extends JpaRepository<UserModule, Integer> {

}
