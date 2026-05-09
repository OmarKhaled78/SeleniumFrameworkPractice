package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
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
/*
Todo app credentials: email: todoapp@example.com password: 123456@Todo
 */
@Listeners({io.qameta.allure.testng.AllureTestNg.class})
@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Login with email and password")
    @Test(description = "Test Login functionality using email & password")
    @Description("Login by filling email and password and navigating to the todo page")
    public void ShouldBeAbleToLoginWithEmailAndPassword(){
       // String email = "todoapp@example.com";
       // String password = "123456@Todo";
        LoginPage loginPage = new LoginPage(getDriver());
        Boolean isWelcomeDisplayed =  loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .isWelcomeMessagedisplayed();
        assertTrue(isWelcomeDisplayed);

    }



}
