package ru.otus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;


public class CourseCards   {
    WebDriver driver;

    public CourseCards(WebDriver driver) {

        this.driver = driver;
    }
    private By duration = By.xpath("//p[@class='course-header2-bottom__item-text']");
    private By nameOfCourses = By.xpath("//div[@class='course-header2__title']");

    public void chekingCardOfCourse (){
        List<WebElement> listOfElements = driver.findElements(duration);
        for (int i = 0; i<listOfElements.size(); i++) {
            System.out.println(listOfElements.get(i).getText());
        }
    }
    public List<String> getParameterOfCourse() {
        List<String> parameters = new ArrayList<>();
        List<WebElement> listOfElements = driver.findElements(duration);
        for (int i = 0; i<listOfElements.size(); i++) {
            parameters.add(listOfElements.get(i).getText());
        }
        return parameters;
    }
    public String getNameOfCourse() {
      String nameCourse = driver.findElement(nameOfCourses).getText();
      return nameCourse;
    }


}
