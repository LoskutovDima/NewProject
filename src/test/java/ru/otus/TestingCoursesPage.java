package ru.otus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestingCoursesPage {
    WebDriver driver;

    public TestingCoursesPage(WebDriver driver) {

        this.driver = driver;
    }
// количетсво курсов по тестирования
    private  By numberOfCourses = By.xpath("//div[@class='title-new__info-item']");
// карточка курса "Game QA Engineer"
    private  By courseCardGameQaEngineer = By.xpath("//a[@class='js-stats lessons__new-item lessons__new-item_hovered']");

    // Метод получения колличесва курсов по тестированию
    public String  getNumbersOfCourses (){
        String numbersOfCourses = driver.findElement(numberOfCourses).getText();
        System.out.println(numbersOfCourses);
        return numbersOfCourses;

    }

    // Метод открывающий карточку курса Game QA Engineer (не кликается)
    public void openCardOfCourse() {
        driver.findElement(courseCardGameQaEngineer).click();
    }




}
