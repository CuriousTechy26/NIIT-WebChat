/*
package com.niit.webchat;

import static org.junit.Assert.*;

import java.util.List;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.niit.webchat.config.ApplicationContextConfig;
import com.niit.webchat.dao.UserDataDao;
import com.niit.webchat.model.UserData;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
@ContextConfiguration(classes= {ApplicationContextConfig.class})
public class UserDataDaoTestCase {

	@Autowired
	private  UserDataDao userDataDao;
	@Autowired
	private  UserData userData;
	
	@Test
	@Rollback(false)
	/*public void testAddUser()
	{
		
		userData.setUserId(9);
		userData.setName("Harshit");
		userData.setEmail("harshit.nv@hotmail.com");
		userData.setPassword("12345");
		userData.setAddress("Delhi");
		userData.setPhone(27524);
		
		assertEquals("successfully added user",true,userDataDao.addUser(userData));
	}
}
	public void testUpdateUser()
	{
		userData=userDataDao.getUserById(2);
		userData.setName("kanav");
		userData.setEmail("kanavg@157.com");
		userData.setPassword("6789");
		userData.setAddress("punjab");
		userData.setPhone(76756778);
		
		assertEquals("successfully updated user",true,userDataDao.updateUser(userData));
	}
	/*
	@Test
	public void testGetAllUser()
	{
		List<UserData> list=userDataDao.getAllUsers();
		assertEquals("reteriving data from table by id",true,list.size()>0);
	}
	@Test
	public void testgetUserByUserId()
	{
		List<UserData> list=userDataDao.getAllUsers();
		for(UserData u:list)
		{
			if(u.getName().equals("kanav")&& u.getPassword().equals("6789"))
			{
				
			}
		}
		user=userDataDao.getUserByUserId(13);
		assertEquals("reteriving data from table by id",true,userData.getName());
	}
	
	
	
	@Test
	public void testDeleteUser()
	{
		assertEquals("successfully deleted user",true,userDataDao.deleteUser(13));
	}	
	
*/
