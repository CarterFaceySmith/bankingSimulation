public class user {
    String name = "null";
    String password = "null";
    Double accountBalance = 0.00;
    Double walletBalance = 0.00;
    Double interestReturn = 0.00;

    public user(String userName, String userPassword, Double acctBalance, Double wallBalance, Double interestRet){
        this.name = userName;
        this.password = userPassword;
        this.accountBalance = acctBalance;
        this.walletBalance = wallBalance;
        this.interestReturn = interestRet;
    }
}