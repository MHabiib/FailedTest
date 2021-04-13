import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setProxyType(Proxy.ProxyType.MANUAL);
        proxy.setSslProxy("http://192.168.56.1:8081");
        proxy.setHttpProxy("http://192.168.56.1:8081");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("proxy", proxy);

        options.addArguments("start-maximized");

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(capabilities);
        driver.get("https://www.imdb.com/registration/signin");
        driver.findElement(By.xpath("//span[contains(text(),'Sign in with IMDb')]")).click();
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("mhabibofficial@yahoo.com");
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Dbca4321");
        driver.findElement(By.cssSelector("#signInSubmit")).click();
        driver.findElement(By.xpath("//body/div[@id='IMDbHomepageSiteReactViews']/nav[@id='imdbHeader']/div[2]/div[5]/div[1]/label[2]/div[1]/span[1]")).click();
        driver.get("https://www.imdb.com/user/ur128765674/lists?ref_=nv_usr_lst_3");
        driver.findElement(By.cssSelector("body.fixed:nth-child(2) div.redesign div.pagecontent:nth-child(2) div.user-profile.userId div.article.listo ul.ipl-zebra-list.user-lists.lists-for-user:nth-child(6) li.ipl-zebra-list__item.user-list div.overflow-menu:nth-child(2) div.circle div.vertical-ellipsis > svg:nth-child(1)")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Delete this list')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Cancel')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body.fixed:nth-child(2) div.redesign div.pagecontent:nth-child(2) div.user-profile.userId div.article.listo ul.ipl-zebra-list.user-lists.lists-for-user:nth-child(6) li.ipl-zebra-list__item.user-list div.overflow-menu:nth-child(2) div.circle div.vertical-ellipsis > svg:nth-child(1)")).click();
        driver.findElement(By.cssSelector("body.fixed:nth-child(2) div.redesign div.pagecontent:nth-child(2) div.user-profile.userId div.article.listo ul.ipl-zebra-list.user-lists.lists-for-user:nth-child(6) li.ipl-zebra-list__item.user-list div.overflow-menu:nth-child(2) div.circle div.vertical-ellipsis > svg:nth-child(1)")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Delete this list')]")).click();
    }
}
