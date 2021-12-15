package ru.otus;


import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

import java.time.LocalDateTime;

import java.util.List;

public class TestNewProject extends BasePageTest {
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(Test.class);



// Тест проверяющий количество курсов
    @Test
    public void numberOfCurses (){
        driver.get("https://otus.ru/");
        logger.info("Главная страница онлайн-обучения Отус успешно загружена");
        HomePage navigate = new HomePage(driver);
        navigate.clickToTesting();
        logger.info("Осуществлен переход на страницу с курсами по Тестированию");
        TestingCoursesPage testingCoursesPage = new TestingCoursesPage(driver);
        String actualCounterOfCourses = testingCoursesPage.getNumbersOfCourses();
        Assert.assertEquals("Количество курсов не соответсвует","Курсов: 11",actualCounterOfCourses);
        logger.info("Проверка количества курсов по тестированию прошла успешно");
    }
    // Тест проверяющий карточку курса
    @Test
    public void cardOfCourse() {
            driver.get("https://otus.ru/lessons/avtomatizaciya-web-testirovaniya/?int_source=courses_catalog&int_term=testing");
            logger.info("Страница курса по тестированию успешно загружена");
            CourseCards courseCards = new CourseCards(driver);
            List<String> actualParameters =  courseCards.getParameterOfCourse();
            Assert.assertEquals("5 месяцев",actualParameters.get(0));
            Assert.assertEquals("Online",actualParameters.get(1));
            Assert.assertEquals("27 декабря",actualParameters.get(2));
            logger.info("Проверка длительности, формата и начала обучения курса успешно пройдена");
            courseCards.getNameOfCourse();
            Assert.assertEquals("Python QA Engineer", courseCards.getNameOfCourse());
            logger.info("Проверка названия курса успешно пройдена");
    }
    // Тест проверяющий события по фильтру ДОД
    @Test
    public void event () {

        driver.get("https://otus.ru/");
        logger.info("Главная страница онлайн-обучения Отус успешно загружена");
        HomePage navigate = new HomePage(driver);
        navigate.clickToCalendar();
        logger.info("Страница с календарем мероприятий успешно загружена");
        CalendarOfEventsPage pageEvents = new CalendarOfEventsPage(driver);
        pageEvents.enterFilter();
        pageEvents.scrollToFooter();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Установлен фильтр 'День открытых дверей'");
        List<String> resultOfDod = pageEvents.getListOfDod();
        for (String item:resultOfDod)
        Assert.assertEquals("Событие не соответсвует фильтру","День открытых дверей",item);
        logger.info("Проверка событий по фильтру успешно завершена");
    }

    // Тест проверяющий события по датам
    @Test
    public void dateOfEvent () {

        driver.get("https://otus.ru/");
        logger.info("Главная страница онлайн-обучения Отус успешно загружена");
        HomePage pageEvents = new HomePage(driver);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        pageEvents.clickToCalendar();
        logger.info("Страница с предстоящими событиями успешно загружена");
        CalendarOfEventsPage pageOfCalendarEvents = new CalendarOfEventsPage(driver);
        pageOfCalendarEvents.scrollToFooter();
        List<LocalDateTime> actualDates = pageOfCalendarEvents.getDateOfCard();
        LocalDateTime now = LocalDateTime.now();
        for( LocalDateTime item: actualDates){
            Assert.assertTrue("Одна из дат не соответсвует проверке",item.isAfter(now));
        }
    }
}

