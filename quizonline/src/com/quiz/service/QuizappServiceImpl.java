package com.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.QuizappDao;
import com.quiz.model.Question;
import com.quiz.model.User;
@Service
 public class QuizappServiceImpl implements QuizappService {
    @Autowired
    QuizappDao d;
     
	@Override
	public void addUser(User u) {

		d.addUser(u);
	}

	@Override
	public int Loginselect(String email, String pass, String usertype) {
	return	d.Loginselect(email,pass,usertype);
		
	}
    
	@Override
	public void Edit_Question(Question q) {
		d.Edit_Question(q);
		
	}

	@Override
	public List<Question> getQuestion() {
		return d.getQuestion();
	}

	@Override
	public ArrayList<String> correct_answer() {
		return d.correct_answer();
	    }
	}
