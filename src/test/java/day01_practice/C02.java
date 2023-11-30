package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    // https://www.techproeducation.com/ sayfasina gidin
    // Title ve Url'ini alın ve yazdırın
    // Title'in "Techpro" kelimesini içerip içermedigini test edin
    // Url'in "techproeducation" kelimesini içerip içermedigini test edin
    // https://www.amazon.com/ sayfasına gidin
    // Title'ini alın ve yazdırın
    // Title'in "more" kelimesini içerip içermedigini test edin
    // techproeducation.com'a geri dönün
    // sayfayı yenileyin
    // amazon.com'a tekrar gelin
WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
      driver.get("https://www.techproeducation.com/");

        // https://www.techproeducation.com/ sayfasina gidin
        // Title ve Url'ini alın ve yazdırın
        String techproeducationTitle=driver.getTitle();
        System.out.println("Techproeducation Title : "+ techproeducationTitle);
      Thread.sleep(2000);
        String techpurl=driver.getCurrentUrl();
        System.out.println("tecpurl: "+ techpurl);
   Thread.sleep(2000);
        // Title'in "Techpro" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techproeducationTitle.contains("Techpro"));


        // Url'in "techproeducation" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techpurl.contains("techproeducation"));




        // https://www.amazon.com/ sayfasına gidin
        driver.get("https://www.amazon.com/");

        // Title'ini alın ve yazdırın
        String amazonTitle=driver.getTitle();
        System.out.println("amazon tıtle: " +amazonTitle);
        Thread.sleep(2000);
        // Title'in "more" kelimesini içerip içermedigini test edin
        Assert.assertTrue(amazonTitle.contains("more"));
        Thread.sleep(2000);
        // techproeducation.com'a geri dönün
        driver.navigate().back();
        Thread.sleep(2000);
        // sayfayı yenileyin
        driver.navigate().forward();
        Thread.sleep(2000);
        // amazon.com'a tekrar gelin
        driver.navigate().forward();
        Thread.sleep(2000);



    }
}
