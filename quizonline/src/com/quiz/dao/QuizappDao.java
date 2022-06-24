package com.quiz.dao;
import java.util.ArrayList;
import java.util.List;

import com.quiz.model.Question;
import com.quiz.model.User;

public interface QuizappDao {

	void addUser(User u);

	int Loginselect(String email, String pass, String usertype);

	void Edit_Question(Question q);

	List<Question> getQuestion();

	ArrayList<String> correct_answer();

}
