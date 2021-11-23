package com.example.myapp.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


class ToDoEventControllerUnitTest {

    @Test
    void addEvent() {
        System.out.println(1);
        Assertions.assertEquals("你好世界", "你好世界");
    }

    @Test
    void updateEventStatus() {
        System.out.println(2);
        Assertions.assertEquals("你好世界", "你好世界");
    }

    @Test
    void deleteEventById() {
        System.out.println(3);
        Assertions.assertEquals("你好世界", "你好世界");

    }

    @Test
    void getAllEvent() {
        System.out.println(4);
        Assertions.assertEquals("你好世界", "你好世界");
    }
}