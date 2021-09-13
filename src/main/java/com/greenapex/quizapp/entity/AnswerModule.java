package com.greenapex.quizapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class AnswerModule {
	@Id
	@Column(name = "answer_id")
	private int answer_id;
	@Column(name = "answer")
	private String answer;
	@Column(name = "question_id")
	private int question_id;
	@Column(name = "is_correct")
	private boolean is_correct;
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public boolean isIs_correct() {
		return is_correct;
	}
	public void setIs_correct(boolean is_correct) {
		this.is_correct = is_correct;
	}
	public AnswerModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnswerModule(int answer_id, String answer, int question_id, boolean is_correct) {
		super();
		this.answer_id = answer_id;
		this.answer = answer;
		this.question_id = question_id;
		this.is_correct = is_correct;
	}
	@Override
	public String toString() {
		return "AnswerModule [answer_id=" + answer_id + ", answer=" + answer + ", question_id=" + question_id
				+ ", is_correct=" + is_correct + "]";
	}

}
