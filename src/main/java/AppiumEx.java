import javax.mail.Message;
import java.util.Date;

public class AppiumEx {



    public static void main(String[] args) {


        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String username = "johnnycashccapp@gmail.com";// change accordingly
        String password = "cocacolapb1";// change accordingly


        //Call method fetch
//        CheckingMails cm = new CheckingMails();
        String codeSnipetFromMail = CheckingMails.fetch(host, mailStoreType, username, password);
        System.out.println("OVO JE CODE SNIPET: " + codeSnipetFromMail);

    }
}
