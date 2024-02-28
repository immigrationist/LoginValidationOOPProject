import java.util.Scanner;

public class LoginValidation {
    private String expectedUsername;
    private String expectedPassword;
    private int maxAttempts;
    public int curAttempts;

    public LoginValidation(String initExpectedUsername, String initExpectedPassword, int initMaxAttempts){
        expectedUsername = initExpectedUsername;
        expectedPassword = initExpectedPassword;
        maxAttempts = initMaxAttempts;
        curAttempts = maxAttempts;
    }

    public boolean setParameters(String correctUserName, String correctPassword, int maxAttempts){
        boolean validation = false;

        if(correctUserName.equals(""))
            validation = true;
        if(correctPassword.equals(""))
            validation = true;

        if(maxAttempts > 0) {
            validation = true;
        }

        if(validation) {
            curAttempts = maxAttempts;
            expectedUsername = correctUserName;
            expectedPassword = correctPassword;
        }

        return validation;
    }

    public int validateLogin(String username, String password ){
        int count = 0  ;

        if(!username.equals(expectedUsername) && !password.equals(expectedPassword)) {
            count = 3;
        }
        else if(!username.equals(expectedUsername)) {
            count = 1;
        }
        else if(!password.equals(expectedPassword)) {
            count = 2;
        }
        else if(username.equals(expectedUsername) && password.equals(expectedPassword))
            count = 0;


        return count;
    }

    public void output(int count){
        if (count == 3) {
            System.out.println("The username and password are both incorrect!!");
            curAttempts--;
        }
        else if (count == 1) {
            System.out.println("The username is incorrect!");
            curAttempts--;
        }
        else if (count == 2) {
            System.out.println("The password is incorrect!");
            curAttempts--;
        }
        else if(count == 0)
            System.out.println("Successful login!!!");
    }
}
