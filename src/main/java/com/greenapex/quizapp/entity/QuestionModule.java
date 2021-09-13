package com.greenapex.quizapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class QuestionModule {
	@Id
	@Column(name = "question_id")
	private int question_id;
	@Column(name = "question")
	private String question;
	@Column(name = "quiz_id")
	private int quiz_id;
	
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}
	public QuestionModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionModule(int question_id, String question, int quiz_id) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.quiz_id = quiz_id;
	}
	@Override
	public String toString() {
		return "QuestionModule [question_id=" + question_id + ", question=" + question + ", quiz_id=" + quiz_id + "]";
	}
	
	

}
