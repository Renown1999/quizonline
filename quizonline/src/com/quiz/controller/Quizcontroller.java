package com.quiz.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.model.Question;
import com.quiz.model.User;
import com.quiz.service.QuizappService;

@Controller
public class Quizcontroller {
	@Autowired
	QuizappService w;

	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}

	@RequestMapping(value = "login")
	public String login() {
		System.out.println("hello");
		return "login";
	}
     
	@RequestMapping(value = "signup")
	public String signup() {
		return "signup";
	}

	@RequestMapping(value = "Loginselect")
	public String Loginselect(HttpServletRequest req) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String usertype = req.getParameter("usertype");
		int a = w.Loginselect(email, pass, usertype);
		System.out.println(a);
		if (a == 1) {
			if (usertype.equals("student")) {
				System.out.println("Here");
				List<Question> list=w.getQuestion();
				req.setAttribute("list", list);
				return "question";
			} 
			else
					{
				return "editquestion";
			}
		} else {
			
			return "login";
		}

	}

	@RequestMapping(value = "Signupselect")
	public String addUser(User u) {
		w.addUser(u);
		return "login";
	}
	
	@RequestMapping(value = "Edit_Question")
	public String Edit_Question(Question q) {
		System.out.println("SDdds");
		w.Edit_Question(q);
		return "editquestion";
	}
	@RequestMapping(value="result")
	public String result()
	{
		return "result";
	}
	@RequestMapping(value="question")
	public String question(HttpServletRequest req){
		List<Question> list=w.getQuestion();
		req.setAttribute("list", list);
		return "question";
	}
	@RequestMapping(value="index")
	public String home1(){
		return "index";
	}
	@RequestMapping(value="Exit")
	public String exit()
	{
		return "index";
	}

	@RequestMapping(value = "submitTest")
	public String submitTest(HttpServletRequest req) {
		int count=0;
		ArrayList<String> l = new ArrayList<String>();
		ArrayList<String> answer=w.correct_answer();
		System.out.println("Hi"+answer);
		for(int i=1;i<=10;i++)
		{
			
		 l.add(req.getParameter("option"+i));
		 System.out.println(req.getParameter("option"+i));
		 }
		
		 
		  int i=0;
		  for(String s:answer)
		  {   
			
			if(answer.get(i).equalsIgnoreCase(l.get(i)))
			{
				count++;
				
			}
			i++;
		}
			System.out.println(count);
			
		
		req.setAttribute("count",count);
		return "result";
	}


}
