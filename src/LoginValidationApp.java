import java.sql.SQLOutput;
import java.util.Scanner;

public class LoginValidationApp {
    public static void main(String[] args) {
        String username = "";
        String password = "";
        final String correctUsername = "Ice";
        final String correctPassword = "Fire";
        String answer = "yes";
        int count = 0;
        final int maxAttempts = 2;
        String respond = "yes";
        Scanner scanner = new Scanner(System.in);

        LoginValidation loginValidation = new LoginValidation(correctUsername, correctPassword, maxAttempts);

        // && loginValidation.validateLogin(username, password) != 0

        System.out.println("You have: " + maxAttempts + " tries!");

        while(loginValidation.curAttempts != 0 && respond.equalsIgnoreCase("yes")) {
            while (answer.equalsIgnoreCase("yes") && loginValidation.curAttempts > 0
                    && loginValidation.validateLogin(username, password) != 0) {

                    System.out.println("Enter username");
                    username = scanner.next();
                    System.out.println("Enter password");
                    password = scanner.next();

                    count = loginValidation.validateLogin(username, password);
                    loginValidation.output(count);

                    if (loginValidation.curAttempts > 0 && loginValidation.validateLogin(username, password) != 0) {
                        System.out.println("Would you like to try again, yes/no?");
                        answer = scanner.next();
                    }

                    if (loginValidation.validateLogin(username, password) != 0 && loginValidation.curAttempts > 0)
                        System.out.println("You have " + loginValidation.curAttempts + " tries left");



            }
            System.out.println("Would you like to change the username and password? yes/no");
            respond = scanner.next();

            if (respond.equalsIgnoreCase("yes")) {
                loginValidation.curAttempts = maxAttempts;
                System.out.println("reset username");
                String resetU = scanner.next();
                System.out.println("reset password");
                String resetP = scanner.next();
                System.out.println("Max attempts");
                int newMaxAttempts = scanner.nextInt();

                loginValidation.setParameters(resetU, resetP, newMaxAttempts);
                if(loginValidation.setParameters(resetU, resetP, newMaxAttempts)) {
                    username = "";
                    password = "";
                }

            }
        }

        if(!respond.equalsIgnoreCase("yes")){
            System.out.println("ERROR 404");


        }
        else if (loginValidation.curAttempts <= 0 && loginValidation.validateLogin(username, password) != 0)
            System.out.println("You have reached the maximum amount of tries!");
    }
}