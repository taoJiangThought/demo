package com.example.myapp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.myapp.entity.TododItem;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ContextConfiguration(initializers = {TodoItemControllerIntegrationTest.Initializer.class})
@SpringBootTest
class TodoItemControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @ClassRule
    public static PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres:11.1")
            .withDatabaseName("root")
            .withUsername("test")
            .withPassword("123456");

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            postgresqlContainer.start();
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgresqlContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgresqlContainer.getUsername(),
                    "spring.datasource.password=" + postgresqlContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void test_whenMockMVC_thenVerifyResponse() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/todoItem/test"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello World!!!"))
                .andReturn();

        Assert.assertEquals("application/json",
                mvcResult.getResponse().getContentType());
    }

    @Test
    public void test_add_todoItem_whenMockMVC_thenVerifyResponse()throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(post("/todoItem").contentType(MediaType.APPLICATION_JSON_VALUE).content(
                "{\n" +
                        "  \"eventName\":\"test7\",\n" +
                        "  \"status\":0\n" +
                        "}"))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.id").isNumber()).andReturn();
        Assert.assertEquals("application/json",
                mvcResult.getResponse().getContentType());
    }

    @Test
    public void test_get_todoItem_whenMockMVC_thenVerifyResponse()throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(get("/todoItem"))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        Assert.assertEquals("application/json",
                mvcResult.getResponse().getContentType());
    }


    @Test
    public  void test_update_todoItem_whenMockMVC_thenVerifyResponse() throws Exception{
        //先创建一个todoItem
        MvcResult addMvcResult = this.mockMvc.perform(post("/todoItem").contentType(MediaType.APPLICATION_JSON_VALUE).content(
                        "{\n" +
                                "  \"eventName\":\"test_update\",\n" +
                                "  \"status\":0\n" +
                                "}"))
                .andDo(print()).andExpect(status().isOk()).andReturn();
        String contentAsString = addMvcResult.getResponse().getContentAsString();
        TododItem tododItem = JSONObject.parseObject(contentAsString, TododItem.class);
        //在更新
        MvcResult mvcResult = this.mockMvc.perform(put("/todoItem?id={id}&status={status}",tododItem.getId(),1))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    public  void test_delete_todoItem_whenMockMVC_thenVerifyResponse() throws Exception{
        //先创建一个todoItem
        MvcResult addMvcResult = this.mockMvc.perform(post("/todoItem").contentType(MediaType.APPLICATION_JSON_VALUE).content(
                        "{\n" +
                                "  \"eventName\":\"test_update\",\n" +
                                "  \"status\":0\n" +
                                "}"))
                .andDo(print()).andExpect(status().isOk()).andReturn();
        String contentAsString = addMvcResult.getResponse().getContentAsString();
        TododItem tododItem = JSONObject.parseObject(contentAsString, TododItem.class);
        //删除
        MvcResult mvcResult = this.mockMvc.perform(delete("/todoItem/{id}",tododItem.getId()))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }

}