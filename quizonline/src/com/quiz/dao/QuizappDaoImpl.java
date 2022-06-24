package com.quiz.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.quiz.model.Question;
import com.quiz.model.User;

@Repository
public class QuizappDaoImpl implements QuizappDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void addUser(User u) {

		final String procedureCall = "{Call Proc_App1(?,?,?,?,?,?,?)}";
		Connection con = null;
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs = con.prepareCall(procedureCall);
			cs.setString(1, "insert_details");
			cs.setString(2, u.getUname());
			cs.setString(3, u.getPassword());
			cs.setString(4, u.getFname());
			cs.setString(5, u.getLname());
			cs.setString(6, u.getEmail());
			cs.setString(7, u.getUsertype());
			cs.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int Loginselect(String email, String pass, String usertype) {
		int flag = 0;
		final String procedureCall = "{Call Proc_App1(?,?,?,?,?,?,?)}";
		Connection con = null;
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs = con.prepareCall(procedureCall);
			cs.setString(1, "login_select");
			cs.setString(2, null);
			cs.setString(3, null);
			cs.setString(4, null);
			cs.setString(5, null);
			cs.setString(6, email);
			cs.setString(7, usertype);
			ResultSet rs = cs.executeQuery();
			System.out.println(email);
			System.out.println(pass);
			if (rs.next()) {
				
				System.out.println(rs.getString("password"));
				if (rs.getString("password").equals(pass)) {
					System.out.println("Password Correct");
					flag = 1;

				} else {
					flag = 2;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(flag);
		return flag;
	}

	@Override
	public void Edit_Question(Question q) {
		
		final String procedureCall = "{Call Proc_App4(?,?,?,?,?,?,?)}";
		Connection con = null;
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs = con.prepareCall(procedureCall);
			cs.setString(1, "edit_question");
			cs.setString(2, q.getQuestion());
			cs.setString(3, q.getOption1());
			cs.setString(4, q.getOption2());
			cs.setString(5, q.getOption3());
			cs.setString(6, q.getOption4());
			cs.setString(7, q.getCorrect_answer());
			cs.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Question> getQuestion() {

		final String procedureCall = "{Call Proc_App4(?)}";
		Connection con = null;
		List<Question> list =new ArrayList<Question>();
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs = con.prepareCall(procedureCall);
			cs.setString(1, "getQuestion");
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				Question q= new Question();
				q.setQuestion(rs.getString("question"));
				q.setOption1(rs.getString("option1"));		
				q.setOption2(rs.getString("option2"));
				q.setOption3(rs.getString("option3"));
				q.setOption4(rs.getString("option4"));
				list.add(q);
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<String> correct_answer() {
		final String procedureCall = "{Call Proc_App4(?,?,?,?,?,?,?)}";
		Connection con = null;
		ArrayList<String> l= new ArrayList<String>();
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs = con.prepareCall(procedureCall);
			cs.setString(1, "correct_answer");
			cs.setString(2, null);
			cs.setString(3, null);
			cs.setString(4, null);
			cs.setString(5, null);
			cs.setString(6, null);
			cs.setString(7, null);
			ResultSet rs = cs.executeQuery();
			while(rs.next()){
				
				l.add(rs.getString("correct_answer"));
		    
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

}
