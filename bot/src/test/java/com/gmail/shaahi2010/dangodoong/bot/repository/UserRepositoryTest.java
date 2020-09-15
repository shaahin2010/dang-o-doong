package com.gmail.shaahi2010.dangodoong.bot.repository;

import com.gmail.shaahi2010.dangodoong.bot.base.BaseTest;

import com.gmail.shaahi2010.dangodoong.bot.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.awt.font.ShapeGraphicAttribute;

@SpringBootTest
class UserRepositoryTest extends BaseTest {
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void userRepositoryNotNull(){
        Assert.notNull(userRepository,"userRepository must not null");
    }
    @Test
    public void crudUser(){
        userRepository.deleteAll();
        User user = User.of( null,"Shaahin", "Yazarloo", "shaahin2010@gmail.com", "989122339338");
        userRepository.save(user);
        userRepository.delete(user);
    }
}