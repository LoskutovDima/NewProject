package ru.otus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class TestingCoursesPage {
    WebDriver driver;

    public TestingCoursesPage(WebDriver driver) {

        this.driver = driver;
    }
// количетсво курсов по тестирования
    private  By numberOfCourses = By.xpath("//div[@class='title-new__info-item']");
// карточка курса "Game QA Engineer"
    private  By courseCardGameQaEngineer = By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div/a[1]/div/div[1]");

    // Метод получения колличесва курсов по тестированию
    public String  getNumbersOfCourses (){
        String numbersOfCourses = driver.findElement(numberOfCourses).getText();
        System.out.println(numbersOfCourses);
        return numbersOfCourses;

    }

    // Метод открывающий карточку курса Game QA Engineer (не кликается)
    public void openCardOfCourse() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        driver.findElement(courseCardGameQaEngineer).click();
    }




}
