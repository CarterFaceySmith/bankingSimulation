import java.util.*;

public class bankApplication {

    public static void printALItem(int position){

        //Print all account variables general
        System.out.println("Username: " + usernames.get(position));
        System.out.println("Password: " + passwords.get(position));
        System.out.println("Account balance: " + accountBalances.get(position));
        System.out.println("Wallet balance: " + walletBalances.get(position));
        System.out.println("Accumulated interest: " + interestReturns.get(position));


    }

public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);

    boolean running = true;

    //Define arraylist for each variable, match positions for each so customer gets arraylist identifier
    ArrayList<String> usernames = new ArrayList<String>();
    ArrayList<String> passwords = new ArrayList<String>();
    ArrayList<Double> accountBalances = new ArrayList<Double>();
    ArrayList<Double> walletBalances = new ArrayList<Double>();
    ArrayList<Double> interestReturns = new ArrayList<Double>();


    BANK:
    while(running){

        boolean loggedIn = false;

            while(!loggedIn){
                
                //main menu
                    System.out.println("Welcome to Bank(all rights reserved), the world's leading bank.\n");
                    System.out.println("Please select from one of the following options: \n");
                        
                        System.out.println("\t1. Login");
                        System.out.println("\t2. Sign up");
                        System.out.println("\t3. Exit\n");
                        System.out.println("Please enter one of the above options: \n");
                        String userInput = scnr.nextLine();
                        if (!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3")){
                            System.out.println("Invalid selection.");
                            continue BANK;
                        }
                    

                if (userInput.equals("2")){

                    //Entered information to be stored in arraylists, then test retrieval via print info method

                    //Sign up process
                    System.out.println("Please enter a username: ");
                    String nameTemp = scnr.nextLine().toString();
                    usernames.add(nameTemp);
                    System.out.println();
                    System.out.println("Please enter a password: ");
                    String wordTemp = scnr.nextLine().toString();
                    passwords.add(wordTemp);
                    System.out.println();
                    System.out.println("Please enter your current external wallet amount to two decimal places: ");
                    Double walletTemp = scnr.nextDouble();
                    walletBalances.add(walletTemp);
                    System.out.println();
                    accountBalances.add(0.00);
                    interestReturns.add(0.00);
                    System.out.println("Your account has been opened successfully.\n");
                    System.out.println("Thank you for opening an account with Bank(all rights reserved), we recommend you store your information in a safe location.\n");
                    continue BANK;
                }

                else if (userInput.equals("1")){

                    //login process
                    System.out.println("Please enter your username: \n");
                    String tempUserName = scnr.nextLine();

                    System.out.println("Please enter your password: \n");
                    String tempPassword = scnr.nextLine();

                    for (String element : usernames){
                        if (element.contains(tempUserName)){
                            int tempPosition = usernames.indexOf(element);

                            if (passwords.get(tempPosition).contains(tempPassword)){
                                System.out.println("Welcome back, " + tempUserName + ".");
                                loggedIn = true;
                                int currUserIdentity = tempPosition;
                            }

                            else {
                                System.out.println("Invalid login credentials.");
                                continue BANK;
                            }
                        }
                    }            
                }

                //exit
                else if (userInput.equals("3")){
                    System.out.println("Thank you for your patronage.");
                    System.exit(0);
                }
            
            }

            LOGGEDBANK:
            while(loggedIn){

                //main menu
                System.out.println("Hello, " + usernames.get(currUserIdentity) + "\n");
                System.out.println("Welcome back to Bank(all rights reserved), the world's leading bank.\n");
                System.out.println("Please select from one of the following options: \n");
                    
                    System.out.println("\t1. Check account balance");
                    System.out.println("\t2. Withdraw funds");
                    System.out.println("\t3. Deposit funds");
                    System.out.println("\t4. Update external wallet amount");
                    System.out.println("\t5. Generate account report");
                    System.out.println("\t6. Logout\n");
                    System.out.println("Please enter one of the above options: \n");
                    
                    String userInput = scnr.nextLine();
                    if (!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3")&& !userInput.equals("4")&& !userInput.equals("5")){
                        System.out.println("Invalid selection.");
                        continue BANK;
                    }

                    if (userInput.equals("1")){
                        System.out.println("Your current account balance is: $" + accountBalances.get(currUserIdentity) + "\n");
                        continue LOGGEDBANK;
                    }

                    if (userInput.equals("2")){
                        System.out.println("How much would you like to withdraw? Please provide two decimal places.");
                        Double withdrawAmount = scnr.nextDouble();

                        if (withdrawAmount > accountBalances.get(currUserIdentity)){
                            System.out.println("You have insufficient funds in your account for this withdrawal.\n");
                        }

                        else {
                            accountBalances.set(currUserIdentity, ((accountBalances.get(currUserIdentity) - withdrawAmount)));
                            walletBalances.set(currUserIdentity, (walletBalances.get(currUserIdentity) + withdrawAmount));
                        }
                        continue LOGGEDBANK;
                    }

                    if (userInput.equals("3")){
                        System.out.println("How much would you like to deposit? Please provide two decimal places.\n");
                        Double depositAmount = scnr.nextDouble();

                        if (depositAmount > walletBalances.get(currUserIdentity)){
                            System.out.println("You have insufficient funds in your account for this withdrawal.\n");
                        }

                        else {
                            walletBalances.set(currUserIdentity, ((walletBalances.get(currUserIdentity) - depositAmount)));
                            accountBalances.set(currUserIdentity, (accountBalances.get(currUserIdentity) + depositAmount));
                        }
                        continue LOGGEDBANK;
                    }

                    if (userInput.equals("4")){
                        System.out.println("Please enter your updated external wallet amount to two deminal places: ");
                        Double updatedAmount = scnr.nextDouble();
                        walletBalances.set(currUserIdentity, updatedAmount);
                    }

                    if (userInput.equals("5")){
                        //generate account report
                        for(int k = 0; k < 5; ++k){
                            printALItem(currUserIdentity);
                        }
                        continue LOGGEDBANK;
                    }

                    if (userInput.equals("6")){
                        System.out.println("Thank you for your patronage.\n");
                        loggedIn = false;
                        System.exit(0);
                    }

            }


        }

    }
}