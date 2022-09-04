package AutomationTests;

import AutomationTestPages.BookYourHotelNowPage;
import AutomationTestPages.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import static AutomationTests.BaseSetup.driver;

public class BaseTest {

    private static MainPage mainPage;
    private static BookYourHotelNowPage bookYourHotelNowPage;

    @BeforeAll
    static void init() {
        BaseSetup baseSetUp = new BaseSetup();
        mainPage = PageFactory.initElements(driver, MainPage.class);
        bookYourHotelNowPage = PageFactory.initElements(driver, BookYourHotelNowPage.class);
    }

    @Test
    public void listOfApartments() throws InterruptedException {
        //GIVEN
        String existingCity = "New York";

        //WHEN
        mainPage.openBookingSite();
        mainPage.clickButtonLanguage();
        mainPage.clickChoiceLanguage();
        mainPage.setCityInField(existingCity);
        mainPage.clickCity();
        mainPage.clickSelectDates();
        mainPage.choiceDate1();
        mainPage.choiceDate2();
        mainPage.clickSearchButton();
        bookYourHotelNowPage.checkTitle();
        bookYourHotelNowPage.titlesWithNewYork();
        bookYourHotelNowPage.cityNameCheck();
        bookYourHotelNowPage.clickCalendar1();
        bookYourHotelNowPage.data1Check();
        bookYourHotelNowPage.clickCalendar1();
        bookYourHotelNowPage.clickCalendar2();
        bookYourHotelNowPage.data2Check();
        bookYourHotelNowPage.clickCalendar2();
        bookYourHotelNowPage.pageCheck();
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}