import java.util.Scanner;
import java.math.BigInteger;
import java.util.HashMap;

public class AtmApplication {
    public static void main(String[] args) {
        HashMap<BigInteger, Integer> bankAccounts = new HashMap<>();

        bankAccounts.put(new BigInteger("123456789"), 1234);
        bankAccounts.put(new BigInteger("258741369"), 2587);
        bankAccounts.put(new BigInteger("369852147"), 3698);

        HashMap<BigInteger, Double> bankBalance = new HashMap<>();
        bankBalance.put(new BigInteger("123456789"), 10000.00);
        bankBalance.put(new BigInteger("258741369"), 25000.00);
        bankBalance.put(new BigInteger("369852147"), 50000.00);

        System.out.println("Enter your account number");
        Scanner obj = new Scanner(System.in);
        BigInteger accountNumber = obj.nextBigInteger();
        if (bankAccounts.containsKey(accountNumber)) {
            System.out.println("Thanks for entering the account number");
            System.out.println("Please enter your PIN");
        } else {
            System.out.println("Incorrect account number entered");
            System.out.println("Please try again");
            System.exit(0);
        }

        int pin = obj.nextInt();
        int correctPin = bankAccounts.get(accountNumber);

        if (pin == correctPin) {
            System.out.println("Authentication Successful");
            System.out.println("Choose 1 to Check balance");
            System.out.println("Choose 2 to Withdraw Money");
            System.out.println("Choose 3 to Deposit Money");
            System.out.println("Choose 4 to Exit");

        } else {
            System.out.println("Incorrect PIN entered");
            System.out.println("Please try again");
        }
        int activity = obj.nextInt();
        switch (activity) {
            case 1:
                System.out.println("Balance :" + bankBalance.get(accountNumber));
                break;

            case 2:
                System.out.println("Enter the amount to withdraw");
                Double withdrawamount = obj.nextDouble();
                if (withdrawamount > bankBalance.get(accountNumber)) {
                    System.out.println("Insufficient Funds");
                    System.exit(0);
                } else {
                    Double newBalance = bankBalance.get(accountNumber) - withdrawamount;
                    bankBalance.put(accountNumber, newBalance);
                    System.out.println("Withdrawal successful. Remaining balance: " + bankBalance.get(accountNumber));
                    break;
                }
            case 3:
                System.out.println("Enter the amount to deposit");
                Double depositamount = obj.nextDouble();
                Double newBalance = bankBalance.get(accountNumber) + depositamount;
                bankBalance.put(accountNumber, newBalance);
                System.out.println("Deposit Succesful. New Balance: " + bankBalance.get(accountNumber));
                break;

            case 4:
                System.out.println("Thank you for visiting");
                System.exit(0);

        }
    }
}
