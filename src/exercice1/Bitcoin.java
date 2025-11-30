package exercice1;

public class Bitcoin implements IPaymentMethod {

    private String walletAddress;
    private double balance;


    public Bitcoin(String walletAddress, double balance) {
        this.walletAddress = walletAddress;
        this.balance = balance;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= balance*91442) {
            balance -= amount/91442;
            System.out.printf("Bitcoin (%s) : payé %.4f Dollar, reste %.4f BTC %n",
                    walletAddress, amount, balance);
            return true;
        }
        System.out.printf("Bitcoin (%s) : fond insuffisant (%.4f)<%.4f> BTC %n",
                walletAddress, amount, balance);
        return false;
    }

    @Override
    public boolean refund(double amount) {
        balance += amount/91442;
        System.out.printf("Bitcoin (%s) : remboursé %.4f Dollar, solde %.4f%n", walletAddress, amount, balance);
        return true;
    }

    @Override
    public String getName() {
        return "Bitcoin[" + walletAddress + "]";
    }
}
