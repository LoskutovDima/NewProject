package ru.otus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class TestNewProject extends BasePageTest {
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(Test.class);




    @Test
    public void numberOfCurses (){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://otus.ru/");
        logger.info("Главная страница онлайн-обучения Отус успешно загружена");
        HomePage navigate = new HomePage(driver);
        navigate.clickToTesting();
        logger.info("Осуществлен переход на страницу с курсами по Тестированию");
        TestingCoursesPage testingCoursesPage = new TestingCoursesPage(driver);
        String actualCounterOfCourses = testingCoursesPage.getNumbersOfCourses();
        Assert.assertEquals("Курсов: 11",actualCounterOfCourses);
        logger.info("Проверка количества курсов по тестированию прошла успешно");
    }

    @Test
    public void cardOfCourse() {
           ChromeOptions option = new ChromeOptions();
            option.addArguments("start-maximized");
            driver = new ChromeDriver(option);
            driver.get("https://otus.ru/lessons/qa-game/?int_source=courses_catalog&int_term=testing");
            logger.info("Страница курса по тестированию успешно загружена");
            CourseCards courseCards = new CourseCards(driver);
            List<String> actualParameters =  courseCards.getParameterOfCourse();
            Assert.assertEquals("4 месяца",actualParameters.get(0));
            Assert.assertEquals("Online",actualParameters.get(1));
            Assert.assertEquals("17 ноября",actualParameters.get(2));
            logger.info("Проверка длительности, формата и начала обучения курса успешно пройдена");
            courseCards.getNameOfCourse();
            Assert.assertEquals("Game QA Engineer", courseCards.getNameOfCourse());
            logger.info("Проверка названия курса успешно пройдена");
    }

    @Test
    public void event () {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        /*driver.get("https://otus.ru/");
        logger.info("Главная страница онлайн-обучения Отус успешно загружена");
        HomePage navigate = new HomePage(driver);
        navigate.clickToCalendar();*/
        driver.get("https://otus.ru/events/near/open_doors/");
        logger.info("Страница с календарем мероприятий успешно загружена");
        CalendarOfEventsPage pageEvents = new CalendarOfEventsPage(driver);
        //pageEvents.enterFilter();
        pageEvents.scrollTo();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Установлен фильтр 'День открытых дверей'");
        List<String> resultOfDod = pageEvents.getListOfDod();
        for (String item:resultOfDod)
        Assert.assertEquals("","День открытых дверей",item);
        logger.info("Проверка событий по фильтру успешно завершена");
    }

    @Test
    public void dateOfEvent () {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://otus.ru/");
        logger.info("Главная страница онлайн-обучения Отус успешно загружена");
        HomePage pageEvents = new HomePage(driver);
        pageEvents.clickToCalendar();
        CalendarOfEventsPage pageOfCalendarEvents = new CalendarOfEventsPage(driver);

        pageOfCalendarEvents.getDateOfCard();
        List<Instant> actualDates = pageOfCalendarEvents.getDateOfCard();
        Instant date = Instant.now();
        for( Instant item: actualDates){
            Assert.assertTrue("Одна из дат",item.isAfter(date));
        };



    }




    }

