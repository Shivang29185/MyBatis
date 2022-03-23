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
		List<User> users = null;
		try {
			session = UserUtil.getSqlSessionFactory().openSession();
			users = session.selectList("getAllUsers");
		} catch (Exception e) {
			System.out.println("user list not found"+ e);
		}	
		finally {
			session.close();
		}	
		return users;
	}

	public void saveData(User user) {
		try {
			session = UserUtil.getSqlSessionFactory().openSession();
			session.insert("saveUser", user);
			session.commit();
		} catch (Exception e) {
			System.out.println("user not inserted"+ e);
			if (session !=  null) {
				session.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void deleteData(int id) {
		try {
			session = UserUtil.getSqlSessionFactory().openSession();
			session.delete("deleteUser", id);
			session.commit();
		} catch (Exception e) {
			System.out.println("user not updated"+ e);
			if (session != null) {
				session.rollback();
			}
		} finally {
			session.close();
		}
	}

	public User findSingleUser(int id) {
		User user = null;
		try {
			session = UserUtil.getSqlSessionFactory().openSession();
			user = session.selectOne("findById", id);
		} catch (Exception e) {
			System.out.println("user not found"+ e);
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
		} catch (Exception e) {
			System.out.println("user not updated"+ e);
			if (session != null) {
				session.rollback();
			}
		} finally {
			
			session.close();
		}
	}

}
