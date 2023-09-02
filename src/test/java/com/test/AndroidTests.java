package com.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import static com.proj.libs.Actions.*;

class AndroidTests {

    @Test
    void androidTestLaunch() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");//optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("rv-test-device");
        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(e -> e.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]")));
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("tesssttt");
        driver.quit();
    }

    @Test
    void tapTest() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");//optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("rv-test-device");
        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        WebElement openMenu = driver.findElement(AppiumBy.accessibilityId("open menu"));
        tapFunctionality(openMenu, driver);
        driver.quit();
    }

    @Test
    void doubleTapTest() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");//optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("rv-test-device");
        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        WebElement openMenu = driver.findElement(AppiumBy.accessibilityId("open menu"));
        doubleTapFunctionality(openMenu, driver);
    }

    @Test
    void longPressByActions() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");//optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("rv-test-device");
        options.setApp(System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();
        driver.findElement(AppiumBy.xpath(".//*[@text='Expandable Lists']")).click();
        driver.findElement(AppiumBy.xpath(".//*[@text='1. Custom Adapter']")).click();
        WebElement element = driver.findElement(AppiumBy.xpath(".//*[@text='People Names']"));
        new Actions(driver).clickAndHold(element).perform();
    }

    @Test
    void longPressBySequence() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");//optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("rv-test-device");
        options.setApp(System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();
        driver.findElement(AppiumBy.xpath(".//*[@text='Expandable Lists']")).click();
        driver.findElement(AppiumBy.xpath(".//*[@text='1. Custom Adapter']")).click();
        WebElement element = driver.findElement(AppiumBy.xpath(".//*[@text='People Names']"));
        longPress(element, driver);
    }

    @Test
    void zoom() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");//optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("rv-test-device");
        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='menu item drawing']")).click();
        WebElement element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drawing screen\"]"));
        Point centerOfElement = getCenterOfElement(element.getLocation(), element.getSize());
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
        driver.perform(Arrays.asList(sequence1(finger1, centerOfElement), sequence2(finger2, centerOfElement)));

    }

    @Test
    void swipeOrScroll() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");//optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("rv-test-device");
        options.setApp(System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getWidth() * 0.25);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));

    }


}
