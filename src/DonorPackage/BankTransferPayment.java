package DonorPackage;
public class BankTransferPayment implements IPaymentStrategy {
    private String bankAccountNumber;
    private String bankName;
    private String name = "Bank Transfer";

    @Override
    public boolean pay(double amount) {
        return true;
    }

    // SETTERS AND GETTERS
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}