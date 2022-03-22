package com.crud.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.crud.model.User;
import com.crud.util.UserUtil;

@Repository
public class UserMapper {

	SqlSession session;
	public List<User> getAllUsers() {
		try {
			session = UserUtil.getSqlSessionFactory().openSession();
			List<User> users = session.selectList("getAllUsers");
			session.commit();
			return users;
		} finally {
			session.close();
		}
	}

	public void saveData(User user) {
		try {
			session = UserUtil.getSqlSessionFactory().openSession();
			session.insert("saveUser", user);
			session.commit();
		} finally {
			session.close();
		}
	}

	public void deleteData(int id) {
		try {
			session = UserUtil.getSqlSessionFactory().openSession();
			session.delete("deleteUser", id);
			session.commit();
		} finally {
			session.close();
		}
	}

	public User findSingleUser(int id) {
		User user;
		try {
			session = UserUtil.getSqlSessionFactory().openSession();
			user = session.selectOne("findById", id);
			session.commit();
		} finally {
			session.close();
		}
		return user;
	}

	public void updateData(User user) {
		try {
			session = UserUtil.getSqlSessionFactory().openSession();
			session.update("updateUser", user);
			session.commit();
		} finally {
			session.close();
		}
	}

}
