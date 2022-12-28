package webapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Nativeapp {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
    DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	
	}
	
	@Test(enabled=false)
	public void test() throws InterruptedException
	{
		System.out.println("native app");
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		Thread.sleep(4000);
		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("Dipak1234");
		Thread.sleep(4000);
		driver.findElement(MobileBy.id("android:id/button1")).click();
		
	}
	@Test (enabled=false)
	public void tapnlongpress()
	{
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		AndroidElement tp= driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter"));
		TouchAction ta= new TouchAction(driver);
		ta.tap(tapOptions().withElement(element(tp))).perform();
		
		AndroidElement lp= driver.findElementByAndroidUIAutomator("text(\"Fish Names\")");
		ta.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();
		
	}
		
	@Test(enabled=true)
	public void scroll()
	{
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElementByAccessibilityId("new Uiscrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))").click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		
	}
	@Test (enabled=true)
	public void SwipeActions()
	{
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		
		driver.findElement(MobileBy.AccessibilityId("2.Inline")).click();
		
		driver.findElement(MobileBy.AccessibilityId("12")).click();
		
		AndroidElement ele1 = driver.findElement(MobileBy.AccessibilityId("15"));
		
		AndroidElement ele2 = driver.findElement(MobileBy.AccessibilityId("5"));
		
		TouchAction ta = new TouchAction<>(driver);
		
		ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSecond(3))).moveTo(element(ele2)).release().perform();
		
		driver.findElementByAndroidUIAutomator("text(\"AM\")").click();
	}
	@Test(enabled = true)
	public void DragAndDrop()
	{
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		
		
		
	}
}
