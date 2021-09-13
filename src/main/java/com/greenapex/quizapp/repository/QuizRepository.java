package com.greenapex.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.greenapex.quizapp.entity.QuizModule;

@Repository
public interface QuizRepository extends JpaRepository<QuizModule, Integer> {

}
