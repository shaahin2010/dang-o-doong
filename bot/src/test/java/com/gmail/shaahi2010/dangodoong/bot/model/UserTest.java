package com.gmail.shaahi2010.dangodoong.bot.model;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class UserTest {

    @Test
    public void createUser(){
        User user=new User();
        Assert.notNull(user,"User object created (no-args)");
    }

}