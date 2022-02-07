package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLInputElement;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments ("start-maximized"); //открытие полноэкранного формата
        options.addArguments ("--incognito"); //открытие страницы в режиме инкогнито
        options.addArguments ("disable-popup-blocking"); //блокировка всплывающих окон

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://galaxystore.ru/");

        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"header__bottom\"]/div/div[1]/div[2]/nav/nav/div[1]/a"));

        webElement.click();

        driver.findElement(By.linkText("Акции")).click();
        driver.findElement(By.linkText("Смартфоны")).click();
        driver.findElement(By.cssSelector("filter__block:nth-child(4) .g-link")).click();
        driver.findElement(By.cssSelector(".g-checkbox:nth-child(5) > label")).click();
        driver.findElement(By.cssSelector(".filter__block:nth-child(5) .g-link")).click();
        driver.findElement(By.cssSelector(".filter__block:nth-child(5) .g-checkbox:nth-child(5) > label")).click();
        driver.findElement(By.cssSelector(".focusing > label")).click();
        driver.findElement(By.cssSelector(".filter__apply")).click();
        driver.findElement(By.cssSelector(".card__image:nth-child(2) > img:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".swiper-slide-active .product-slider__thumb > img")).click();
        driver.findElement(By.cssSelector(".swiper-slide-active .product-slider__thumb > img")).click();
        driver.findElement(By.cssSelector(".swiper-slide-active .product-slider__thumb > img")).click();
        driver.findElement(By.cssSelector(".g-button:nth-child(4)")).click();



        driver.findElement(By.id("header-search-input")).sendKeys("Russia");

        driver.findElement(By.id("header-search-input")).submit();


        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));

        driver.quit();

    }

}


