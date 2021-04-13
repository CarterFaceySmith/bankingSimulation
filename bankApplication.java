import java.util.*;

public class bankApplication {
public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);

    boolean running = true;

    BANK:
    while(running){

            System.out.println("Welcome to Bank(all rights reserved), the world's leading bank.\n");
            System.out.println("If you are a new user, please type 'sign up', otherwise type 'login'\n");
            String userInput = scnr.nextLine();

            if (userInput.equals("sign up")){

                //Sign up process
                System.out.println("Please enter a username: ");
                String nameTemp = scnr.nextLine();
                System.out.println();
                System.out.println("Please enter a password: ");
                String wordTemp = scnr.nextLine();
                System.out.println();
                System.out.println("Please enter your external current wallet amount to two decimal places: ");
                Double walletTemp = scnr.nextDouble();
                System.out.println();
                System.out.println("Your account has been opened successfully.\n");
                System.out.println("Thank you for opening an account with Bank(all rights reserved), we recommend you store your information in a safe location.\n");
                continue BANK;
            }

            else if (userInput.equals("login")){

                //login process
                System.out.println("Please enter your username: \n");
        
            }
        
            //x

        }


    }
}