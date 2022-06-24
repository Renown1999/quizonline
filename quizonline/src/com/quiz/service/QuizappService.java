package com.quiz.service;
import java.util.ArrayList;
import java.util.List;

import com.quiz.model.Question;
import com.quiz.model.User;

public interface QuizappService {

	void addUser(User u);

	int Loginselect(String email, String pass, String usertype);

	void Edit_Question(Question q);
	ArrayList<String> correct_answer();

	List<Question> getQuestion();

}
