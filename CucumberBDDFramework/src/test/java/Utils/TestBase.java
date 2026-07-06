package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver dr;
	
public  WebDriver WebDriverManager() throws IOException {
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties pro=new Properties();
        pro.load(fis);
        String url=pro.getProperty("QAUrl");
        String browser_properties=pro.getProperty("browser");
        String browser_mvn=System.getProperty("browser");
        //java ternary operator--syntax is--result--test condition? value1 : value2
         String browser=browser_mvn!=null ? browser_mvn :browser_properties;
        
		
		if(dr==null) {
			if(browser.equalsIgnoreCase("Chrome")) {
		dr= new ChromeDriver();
			}
			if(browser.equalsIgnoreCase("firefox")) {
		dr=new FirefoxDriver();
				
			}
		dr.get(url);
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return dr;
		
	}

}
