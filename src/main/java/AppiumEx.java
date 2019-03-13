import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumEx {

    private static AndroidDriver driver;

    public static void main(String[] args) {


        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName","POCOPHONE_F1");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("noReset", true);
//        capabilities.setCapability("skipUnlock", true);
        capabilities.setCapability("appPackage", "com.cocacola.app.cee.dev");
        capabilities.setCapability("appActivity", "com.cocacola.stories.main.MainActivity");

        try {
            driver = new AndroidDriver(new URL("http://172.18.0.2:4723/wd/hub"),capabilities);
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
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MobileElement enter_code = (MobileElement) driver.findElementById("magic_link_button_enter_code");
        enter_code.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //OVDE IDE KOD ZA CHUPANJE MAILA

        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String username = "johnnycashccapp@gmail.com";// change accordingly
        String password = "cocacolapb1";// change accordingly
        String code = "";
        CheckingMails cm = new CheckingMails();
        try {
           code = cm.writePart(cm.fetch(host, mailStoreType, username, password));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        MobileElement text_value = (MobileElement) driver.findElementById("text_value");
        text_value.click();
        text_value.sendKeys(code);

        MobileElement text_confirm = (MobileElement) driver.findElementById("text_confirm");
        text_confirm.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MobileElement tutorial_skip = (MobileElement) driver.findElementById("tutorial_skip");
        tutorial_skip.click();

//        Date start = new java.util.Date(); // Date of the start of the script;
//        System.out.println(start);
//        Date mailDate = null; // date on which mail arrived. It should be later the start date.
//        String from = "";
//
//        String host = "pop.gmail.com";// change accordingly
//        String mailStoreType = "pop3";
//        String username = "johnnycashccapp@gmail.com";// change accordingly
//        String password = "cocacolapb1";// change accordingly
//
//
//
//
//        CheckingMails cm = new CheckingMails();
//
//        // Get mailDate
////        try {
////          mailDate = cm.retrieveSendDate(cm.fetch(host, mailStoreType, username,password));
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////        // get sender
////        try {
////            from = cm.getSender(cm.fetch(host, mailStoreType, username,password));
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
   }
}
