package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class NewTodoPage extends BasePage {

    public NewTodoPage(WebDriver driver){


        super(driver);

    }

    @FindBy(css ="[data-testid=\"new-todo\"]" )
    private WebElement newTodoInput;
    @FindBy(css ="[data-testid=\"submit-newTask\"]" )
    private WebElement newTodoSubmit;
    @Step
    public NewTodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.NEW_TODO_ENDPOINT);
        return this;

    }

    @Step
    public TodoPage addNewTodo(String newTodoName){
        newTodoInput.sendKeys(newTodoName);
        newTodoSubmit.click();
        return new TodoPage(driver);

    }
}
