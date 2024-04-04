package edu.pitt.cs;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class D3Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    driver = new ChromeDriver(options);

    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void tEST5RENTACAT() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//a[contains(text(),\'Rent-A-Cat\')]")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[@onclick=\'rentSubmit()\']"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[@onclick=\'returnSubmit()\']"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void tEST1LINKS() {
    String url = "http://localhost:8080/";
    driver.get(url);
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    {
      WebElement element = driver.findElement(By.xpath("//li[8]/a"));
      String attribute = element.getAttribute("href");
      vars.put("linktoreset", attribute);
    }
    assertEquals(vars.get("linktoreset").toString(), url+"reset");
  }
  @Test
  public void tEST3CATALOG() {
    String url = "http://localhost:8080/";
    driver.get(url);
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    {
      WebElement element = driver.findElement(By.xpath("//img[@alt=\'Old Deuteronomy\']"));
      String attribute = element.getAttribute("src");
      vars.put("imageSource", attribute);
    }
    assertEquals(vars.get("imageSource").toString(), url+"images/cat2.jpg");
  }
  @Test
  public void tEST7RETURN() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=true\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//a[contains(text(),\'Rent-A-Cat\')]")).click();
    driver.findElement(By.id("returnID")).click();
    driver.findElement(By.id("returnID")).sendKeys("2");
    driver.findElement(By.xpath("//button[@onclick=\'returnSubmit()\']")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
    assertThat(driver.findElement(By.id("returnResult")).getText(), is("Success!"));
  }
  @Test
  public void tEST9FEED() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//a[contains(text(),\'Feed-A-Cat\')]")).click();
    driver.findElement(By.id("catnips")).click();
    driver.findElement(By.id("catnips")).sendKeys("6");
    driver.findElement(By.xpath("//button[@onclick=\'feedSubmit()\']")).click();
    assertThat(driver.findElement(By.id("feedResult")).getText(), is("Nom, nom, nom."));
  }
  @Test
  public void tEST11GREETACATWITHNAME() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.get("http://localhost:8080/greet-a-cat/Jennyanydots");
    assertThat(driver.findElement(By.cssSelector("#greeting > h4")).getText(), is("Meow! from Jennyanydots."));
  }
  @Test
  public void tEST2RESET() {
    driver.get("http://localhost:8080/rent-a-cat");
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    driver.findElement(By.id("rentID")).sendKeys("2");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    driver.findElement(By.id("rentID")).sendKeys("3");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    driver.get("http://localhost:8080/reset");
    assertThat(driver.findElement(By.cssSelector("div#listing li:nth-child(1)")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.cssSelector("div#listing li:nth-child(2)")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.cssSelector("div#listing li:nth-child(3)")).getText(), is("ID 3. Mistoffelees"));
  }
  @Test
  public void tEST4LISTING() {
    driver.get("http://localhost:8080/");
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("div#listing li:nth-child(3)"));
      assert(elements.size() > 0);
    }
    assertThat(driver.findElement(By.cssSelector("div#listing li:nth-child(3)")).getText(), is("ID 3. Mistoffelees"));
  }
  @Test
  public void tEST6RENT() {
    driver.get("http://localhost:8080/rent-a-cat");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    assertThat(driver.findElement(By.cssSelector("div#listing li:nth-child(1)")).getText(), is("Rented out"));
    assertThat(driver.findElement(By.cssSelector("div#listing li:nth-child(2)")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.cssSelector("div#listing li:nth-child(3)")).getText(), is("ID 3. Mistoffelees"));
    assertThat(driver.findElement(By.id("rentResult")).getText(), is("Success!"));
  }
  @Test
  public void tEST8FEEDACAT() {
    driver.get("http://localhost:8080/feed-a-cat");
    assertThat(driver.findElement(By.xpath("//button[@onclick=\'feedSubmit()\']")).getText(), is("Feed"));
  }
  @Test
  public void tEST10GREETACAT() {
    driver.get("http://localhost:8080/greet-a-cat");
    assertThat(driver.findElement(By.cssSelector("#greeting > h4")).getText(), is("Meow!Meow!Meow!"));
  }
  
}