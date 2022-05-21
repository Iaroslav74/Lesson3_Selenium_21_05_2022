package hw5_Smirnov_Afisha;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class WindowsTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://okno.ru/");
    }

    @Test
    void likeWindowsTest() throws InterruptedException {
        List<WebElement> WindowsList = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[1]/div/div/div[1]/span/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WindowsList.stream().filter(f -> f.getText().contains("Двухстворчатое окно 1300x1400")).findFirst().get());
        WindowsList.stream().filter(f -> f.getText().contains("Двухстворчатое окно 1300x1400")).findFirst().get().click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[3]/div/div[1]/div[1]/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/span/a")));
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div/div[1]/div[1]/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/span/a")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[3]/a")));

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("Перейти в корзину")));
        Assertions.assertEquals(driver.findElement(By.id("Перейти в корзину")).isDisplayed(), true);
        assertThat(driver.findElement(By.id("Перейти в корзину")), is(not(isDisplayed())));
//    }
//
//    @Test
//    void hoverMenuTest() {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.xpath("//a[.='КИНО']")))
//                .build()
//                .perform();
//
//        driver.findElement(By.xpath("//div[@data-test='SUGGEST']//a[.='Скоро онлайн в Okko']")).click();
//
//        Assertions.assertTrue(driver.getCurrentUrl().contains("okko-soon"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
