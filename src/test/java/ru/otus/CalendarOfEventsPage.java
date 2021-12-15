package ru.otus;

import org.openqa.selenium.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CalendarOfEventsPage {
    WebDriver driver;

    public CalendarOfEventsPage(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка для выбора фильтров
    private By sortingEvents = By.xpath("//span[text()='Все мероприятия']");
    // даты событий
    private By dateEvents = By.xpath("//div[@class='dod_new-event__time']");
    // кнопка в списке фильтров : "День открытых дверей"
    private By dod = By.xpath("/html/body/div[1]/div/div[2]/div/section/header/div[1]/div/div[2]/a[3]");
    // список событий по фильтру "День открытых дверей"
    private By listDod = By.xpath("//div[text()='День открытых дверей']");
    // footer
    private By footer = By.xpath("//footer[@class='footer2 footer2_desktop  no-print']");
    // close banner
    private By closeBanner = By.xpath("//div[@class='sticky-banner__close js-sticky-banner-close']");

    public void enterFilter() {
        driver.findElement(closeBanner).click();
        driver.findElement(sortingEvents).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.findElement(dod).click();

    }

    public  void scrollToFooter() {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    public void ListOfEvents() {
        List<WebElement> listOfElements = driver.findElements(listDod);
        for (int i = 0; i < listOfElements.size(); i++) {
            System.out.println(listOfElements.get(i).getText());
        }
    }
    public void ListDateOfElements(){
        List<WebElement> dateOfElemets = driver.findElements(dateEvents);
        for (int i =0; i < dateOfElemets.size(); i++) {
            System.out.println(dateOfElemets.get(i).getText());
        }

    }

    // Метод по получению дат из карточек предстоящих событий
    public List<LocalDateTime> getDateOfCard() {
        List<String> listDateOfEvents = new ArrayList<>();
        List<WebElement> listDateOfElement = driver.findElements(dateEvents);
        for (WebElement webElement : listDateOfElement) {
            listDateOfEvents.add(webElement.getText());
        }
        List<LocalDateTime> listOfDates = new ArrayList<>();
        for (String listDateOfEvent : listDateOfEvents) {
            listOfDates.add(LocalDateTime.parse(listDateOfEvent + " " + Calendar.getInstance().get(Calendar.YEAR),
                    DateTimeFormatter.ofPattern("d MMMM HH:mm yyyy", new Locale("ru"))));
        }
        return listOfDates;
    }





// Метод по получению типа события "День открытых дверей"
    public List<String> getListOfDod() {

        List<String> listOfEventsOfDod = new ArrayList<>();
        List<WebElement> listOfElements = driver.findElements(listDod);
        for (int i = 0; i < listOfElements.size(); i++) {
            listOfEventsOfDod.add(listOfElements.get(i).getText());
        }

        return listOfEventsOfDod;
    }




}
