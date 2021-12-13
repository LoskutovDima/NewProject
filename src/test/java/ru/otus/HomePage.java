package ru.otus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends BasePageTest {
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
// навигация сайта : вкладка "Курсы"
    private By buttCourses = By.xpath("//p[text()='Курсы']");
// навигация сайта : вкладка "События"
    private By buttDevelopments = By.xpath("//p[text()='События']");
// вкладка "Тестирование"
    private By testing = By.xpath("//a[@title='Тестирование']");
// вкладка "Календарь мероприятий
    private By calendar = By.xpath("//a[@title='Календарь мероприятий']");
    // Метод отркрытия страницы с курсами по тестированию
    public  void clickToTesting () {
    driver.findElement(buttCourses).click();
    driver.findElement(testing).click();
    }
    // Метод открытия страницы предстоящих событий
    public void clickToCalendar() {
        driver.findElement(buttDevelopments).click();
        driver.findElement(calendar).click();
    }

}
