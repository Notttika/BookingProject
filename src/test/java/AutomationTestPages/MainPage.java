package AutomationTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "img[class=\"bui-avatar__image\"]")
    private WebElement buttonLanguage;
    @FindBy(how = How.XPATH,using ="(//div[@class=\"bui-inline-container__main\" and contains(.,'English (UK)')])[2]")
    private WebElement choiceLanguage;
    @FindBy(id = "ss")
    private WebElement textInput;
    @FindBy(css = "li[class=\"c-autocomplete__item sb-autocomplete__item sb-autocomplete__item-with_photo sb-autocomplete__item__item--elipsis sb-autocomplete__item--icon_revamp sb-autocomplete__item--city \"]")
    private WebElement city;
    @FindBy(css = "div[class=\"xp__dates-inner\"]")
    private WebElement selectDates;
    @FindBy(css = "[class=\"bui-calendar__control bui-calendar__control--next\"] svg")
    private WebElement followButton;
    @FindBy(css = "button[class=\"sb-searchbox__button \"]")
    private WebElement searchButton;
    By monthInCalendar= By.xpath("(//div[@class=\"bui-calendar__month\" ])[1]");
    By dayInCalendar= By.xpath("(//tbody)[1]//tr//td/span");


    public MainPage openBookingSite() {
        driver.get("https://www.booking.com");
        return this;
    }
    public MainPage clickButtonLanguage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.elementToBeClickable(buttonLanguage)).click();
        return this;
    }
    public MainPage clickChoiceLanguage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.elementToBeClickable(choiceLanguage)).click();
        return this;
    }

    public MainPage setCityInField(String Text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1500L));
        wait.until(ExpectedConditions.elementToBeClickable(textInput)).sendKeys(Text);
        return this;
    }
    public MainPage clickCity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1500L));
        wait.until(ExpectedConditions.elementToBeClickable(city)).click();
        return this;
    }

    public MainPage clickSelectDates() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.elementToBeClickable(selectDates)).click();
        return this;
    }
    public MainPage choiceDate1() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait1.until(ExpectedConditions.elementToBeClickable(selectDates)).click();
        String checkInMonth = "December 2022";
        String dateVal1 = "1";
        while (true) {
            String month = driver.findElement(monthInCalendar).getText();
            if (month.equals(checkInMonth)) {
                break;
            } else {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
                wait.until(ExpectedConditions.elementToBeClickable(followButton)).click();
            }
        }
            List<WebElement> ele = driver.findElements(dayInCalendar);
         for (WebElement element: ele){
            String date =  element.getText();
            if (date.equals(dateVal1)){
                element.click();
            }
         }
        return this;
        }

    public MainPage choiceDate2() {
        String checkInMonth = "December 2022";
        String dateVal2 = "31";
       while (true) {
            String month = driver.findElement(monthInCalendar).getText();
            if (month.equals(checkInMonth)) {
                break;
            } else {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
                wait.until(ExpectedConditions.elementToBeClickable(followButton)).click();
            }
        }
        List<WebElement> ele = driver.findElements(dayInCalendar);
        for (WebElement element: ele){
            String date =  element.getText();
            if (date.equals(dateVal2)){
                element.click();
            }
        }
        return this;
    }
    public MainPage clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return this;
    }
  }












