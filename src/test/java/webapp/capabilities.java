package webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
public class capabilities {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
    DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"C:/chromedriver.exe");
		dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c",false));
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	
	}
	
	@Test
	public void testcase() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.get("https://www.google.com");
		System.out.println("Hello Let's do Appium");
		driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("MoolyaEd");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		
		driver.findElement(By.xpath("//*[@class='ynAwRc q8U8x MBeuO oewGkc LeUQr htnRc']")).click();
        List<AndroidElement> links= driver.findElements(By.tagName("a"));   //a= anchor tag
	
		
//number of links
		System.out.println(links.size());  //link size
		for(int i=0;i<links.size();i++)    // print link
		{
		
	  System.out.println(links.get(i).getText());
	  System.out.println(links.get(i).getAttribute("href"));
		}
		
	    driver.navigate().back();
	   

	
	    //JavascriptExecutor js = (JavascriptExecutor)driver;
	    //js.executeScript("document.getElementsByClassName('ynAwRc q8U8x MBeuO oewGkc LeUQr htnRc')[1].scrollIntoView()");
	    WebElement ele= driver.findElement(By.xpath("//*[contains(text(),'MoolyaEd | Linkdin')]"));
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    //driver.findElement(By.xpath("//*[@href='https://in.linkedin.com/company/moolyaed']")).click();
	    
	    js.executeScript("arguments[0].scrollIntoview(true)",ele);
	    ele.click();
	    
	String ss=	  driver.getTitle();
	System.out.println(ss);
		
		

	}
}












