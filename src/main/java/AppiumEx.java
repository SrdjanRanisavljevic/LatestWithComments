import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumEx {

    private static AndroidDriver driver;
    public static Date testStart = new Date();

    public static void main(String[] args) {


        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName","POCOPHONE_F1");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("noReset", true);
//        capabilities.setCapability("skipUnlock", true);
        capabilities.setCapability("appPackage", "com.cocacola.app.cee.dev");
        capabilities.setCapability("appActivity", "com.cocacola.stories.main.MainActivity");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        // -------- LOGIN ---------//

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MobileElement log_in = (MobileElement) driver.findElementById("welcome_button_log_in");
        log_in.click();


        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ------- FIND LOGIN FIELD AND SEND KEYS - email address SUBMIT------------//

        MobileElement enter_email = (MobileElement) driver.findElementById("auto_generated_edit_text");
        enter_email.click();
        enter_email.sendKeys("johnnycashccapp@gmail.com");

        MobileElement submit_buton = (MobileElement) driver.findElementById("next_lottie_button");
        submit_buton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MobileElement enter_code = (MobileElement) driver.findElementById("magic_link_button_enter_code");
        enter_code.click();

        try {
            Thread.sleep(8000);   // WAITS 8 SECONDS FOR THE ARRIVAL OF THE MAIL
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //COPIES CODE SNIPPET TO ENTER VERIFICATION CODE FIELD
        CheckingMails cm = new CheckingMails();
        String code = cm.returnCodeSnippet();


        MobileElement text_value = (MobileElement) driver.findElementById("text_value");
        text_value.click();
        text_value.sendKeys(code);

        MobileElement text_confirm = (MobileElement) driver.findElementById("text_confirm");
        text_confirm.click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // SKIPS TUTORIAL
        MobileElement tutorial_skip = (MobileElement) driver.findElementById("tutorial_skip");
        tutorial_skip.click();


   }
}
