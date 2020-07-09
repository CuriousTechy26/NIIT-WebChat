package com.niit.webchat.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.webchat.model.Authorization;
import com.niit.webchat.model.UserData;

@Repository(value = "userDataDao")
@Transactional
public class UserDataDaoImpl implements UserDataDao {
	private static final Logger log = LoggerFactory.getLogger(UserDataDaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public boolean addUser(UserData user) {
		log.debug("user data is going to end");
		try {
			Session session = sessionFactory.getCurrentSession();
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			session.save(user);
			Authorization auth = new Authorization();
			auth.setName(user.getEmail());
			session.save(auth);
			log.debug("user data added successfully");
			return true;
		} catch (HibernateException exception) {
			log.error(exception.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateUser(UserData user) {
		log.debug("user data is going to update");
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			Session session = sessionFactory.getCurrentSession();
			session.update(user);
//			Authorization auth = new Authorization();
//			auth.setName(user.getEmail());
//
//			session.save(auth);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUser(UserData userData) {
		log.debug("user data is going to delete");
		try {
			sessionFactory.getCurrentSession().delete(userData);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<UserData> getAllUsers() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from UserData where name!='admin'").list();
		}

		catch (HibernateException e) {

			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public UserData getUserByUserId(int userId) {
		log.debug("user by Id is going to run");
		try {
			UserData user = (UserData) sessionFactory.getCurrentSession()
					.createQuery("from UserData where userId=:userId").setParameter("userId", userId).uniqueResult();
			System.out.println("dao user by id" + user.getName());
			return user;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean validate(int id, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserData getUserByEmail(String email) {
		log.debug("user by Email is going to run");
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from UserData where email=:email");
			UserData user = (UserData) query.setParameter("email", email).getSingleResult();
			return user;
		} catch (HibernateException e) {

			e.printStackTrace();
			return null;
		}
	}
}
