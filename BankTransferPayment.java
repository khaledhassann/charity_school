public class BankTransferPayment implements IPaymentStrategy {
    private String bankAccountNumber;
    private String bankName;

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

}
