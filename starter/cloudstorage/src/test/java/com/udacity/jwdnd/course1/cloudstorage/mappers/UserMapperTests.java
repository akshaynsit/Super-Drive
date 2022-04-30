package com.udacity.jwdnd.course1.cloudstorage.mappers;

import com.udacity.jwdnd.course1.cloudstorage.CloudStorageApplication;
import com.udacity.jwdnd.course1.cloudstorage.models.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(CloudStorageApplication.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserMapperTests {
    private Logger logger = LoggerFactory.getLogger(UserMapperTests.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUser() {
        User newUser = new User(
                "ab",
                "sdfsdf",
                "sdf123",
                "hello",
                "world");

        this.userMapper.insert(newUser);
        Integer userId = newUser.getUserid();
        Assertions.assertNotNull(userId);
        User user = this.userMapper.getUserById(userId);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(newUser.getFirstname(), user.getFirstname());
        Assertions.assertEquals(newUser.getLastname(), user.getLastname());
    }

    @Test
    public void getAllUsers(){
        User newUser = new User(
                "ab",
                "sdfsdf",
                "sdf123",
                "hello",
                "world");

        this.userMapper.insert(newUser);

        List<User> userList = this.userMapper.getAllUsers();

        Assertions.assertFalse(userList.isEmpty());
        Assertions.assertTrue(userList.size() == 1);
        User user = userList.get(0);
        Assertions.assertEquals(newUser.getUsername(), user.getUsername());
    }

    @Test
    public void deleteUser(){
        User newUser = new User(
                "ab",
                "sdfsdf",
                "sdf123",
                "hello",
                "world");

        this.userMapper.insert(newUser);
        Integer userId = newUser.getUserid();
        this.userMapper.delete(userId);
        User user = this.userMapper.getUserById(userId);

        Assertions.assertNull(user);
    }
}
