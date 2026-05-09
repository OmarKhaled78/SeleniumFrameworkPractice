package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.time.Duration;
@Listeners({io.qameta.allure.testng.AllureTestNg.class})
@Feature("Todo Feature")
public class AddTodoTest extends BaseTest {
    @Story("Add Todo")
    @Test (description = "Test adding a new Todo")
    @Description("Registering a new user then adding a new todo then asserting that the text shown is the same as the added todo name")
    public void AddNewTodo(){
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

       NewTodoPage newTodoPage = new NewTodoPage(getDriver());

        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredcookies());
       String result =  newTodoPage
                .load()
                .addNewTodo("Practice Selenium")
                .getTodoText();

        assertEquals(result, "Practice Selenium");
    }
    @Story("Delete Todo")
    @Test (description = "Test deleting a new Todo")
    @Description("Registering a new user and adding a new todo through the API and then testing the deletion functionality through the UI")
    public void DeleteTodo(){
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getAccessToken());
        TodoPage todoPage = new TodoPage(getDriver());

        todoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredcookies());
        boolean NoAvailableTodosTextIsDisplayed =  todoPage
                .load()
                .clickDeleteButton()
                .isNoTodosMessageDisplayed();
        assertTrue(NoAvailableTodosTextIsDisplayed);
    }
}
