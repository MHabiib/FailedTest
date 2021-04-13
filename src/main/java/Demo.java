import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
    private WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
    }

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.get("https://id.wikipedia.org/wiki/Halaman_Utama");
    }

    /*@Test
    public void test() {
        driver.findElement(By.id("searchInput")).sendKeys("java");
        Assert.assertEquals("Wikipedia bahasa Indonesia, ensiklopedia bebas", driver.getTitle());
    }

    @Test
    public void test2() {
        driver.findElement(By.id("searchButton")).click();
    }*/

    @After
    public void after() {
        driver.quit();
    }
}
