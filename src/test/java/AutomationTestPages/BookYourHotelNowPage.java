package AutomationTestPages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BookYourHotelNowPage {
    private WebDriver driver;

    public BookYourHotelNowPage (WebDriver driver) {
        this.driver = driver;
    }
    By titles= By.xpath("//div[@class=\"fcab3ed991 a23c043802\"]");
    By cityNewYork= By.xpath("//div[@class=\"ab090fee6e cc6f7f2b89\"]/descendant::input");
    By dataElement1= By.xpath("//span[@class=\"b21c1c6c83 e505d9d049 e5f46f434c\"]");
    By dataElement2= By.xpath("//span[@class=\"b21c1c6c83 e505d9d049 fed31314a4\"]");
    By page= By.cssSelector("li[class=\"f32a99c8d1 ebd02eda9e\"] button");
    @FindBy(how = How.XPATH,using ="//button[@class=\"d47738b911 fb1847d86a\" and @data-testid=\"date-display-field-start\"]")
    private WebElement calendar1;
    @FindBy(how = How.XPATH,using ="//button[@class=\"d47738b911 fb1847d86a\" and @data-testid=\"date-display-field-end\"]")
    private WebElement calendar2;

    public BookYourHotelNowPage cityNameCheck (){
        String expectedNameNewYork = "New York";
        WebElement cityName = driver.findElement(cityNewYork);
        String actualNameNewYork = cityName.getAttribute("value");
        Assertions.assertEquals(expectedNameNewYork, actualNameNewYork);
        return this;
    }
    public BookYourHotelNowPage clickCalendar1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1500L));
        wait.until(ExpectedConditions.elementToBeClickable(calendar1)).click();
        return this;
    }
    public BookYourHotelNowPage clickCalendar2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1500L));
        wait.until(ExpectedConditions.elementToBeClickable(calendar2)).click();
        return this;
    }
    public BookYourHotelNowPage data1Check (){
        String expectedData1Label = "1 December 2022";
        String expectedData1Checked = "true";
        WebElement data1Name = driver.findElement(dataElement1);
        String actualData1Label = data1Name.getAttribute("aria-label");
        String actualData1Checked = data1Name.getAttribute("aria-checked");
        Assertions.assertEquals(expectedData1Label, actualData1Label);
        Assertions.assertEquals(expectedData1Checked, actualData1Checked);
        return this;
    }
    public BookYourHotelNowPage data2Check (){
        String expectedData2Label = "31 December 2022";
        String expectedData2Checked = "true";
        WebElement data2Name = driver.findElement(dataElement2);
        String actualData2Label  = data2Name.getAttribute("aria-label");
        String actualData2Checked = data2Name.getAttribute("aria-checked");
        Assertions.assertEquals(expectedData2Label, actualData2Label);
        Assertions.assertEquals(expectedData2Checked, actualData2Checked);
        return this;
    }
    public BookYourHotelNowPage pageCheck (){
        String expectedPage = "1";
        WebElement cityName = driver.findElement(page);
        String actualPage = cityName.getText();
        Assertions.assertEquals(expectedPage, actualPage);
        return this;
    }
    public BookYourHotelNowPage checkTitle (){
        String expectedPageTitle = "Booking.com : Hotels in New York . Book your hotel now!";
        String actualPageTitle = driver.getTitle();
        Assertions.assertEquals(expectedPageTitle, actualPageTitle);
        return this;
    }
    public void titlesWithNewYork () {
        List<WebElement> hotelLists = driver.findElements(titles);
        List<String> collectWithFilter = hotelLists.stream().map(e -> e.getText()).filter(e -> e.contains("New York")).collect(Collectors.toList());
        List<String> collectWithoutFilter = hotelLists.stream().map(e -> e.getText()).collect(Collectors.toList());

        System.out.println(hotelLists.size());
        System.out.println("Without a filter" + collectWithoutFilter.size());
        System.out.println("With a filter" + collectWithFilter.size());
        org.assertj.core.api.Assertions.assertThat(collectWithFilter.size()).isNotEqualTo(collectWithoutFilter.size());
    }
}
