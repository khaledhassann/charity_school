package School;

public class BankTransferPayment implements IPaymentStrategy {
    private String bankAccountNumber;
    private String bankName;

    public BankTransferPayment(String bankAccountNumber, String bankName) {
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
    }

    @Override
    public boolean pay(double amount) {
        return validate(bankAccountNumber, bankName);
    }

    private boolean validate(String bankAccountNumber, String bankName) {
        // validate card details
        if (bankAccountNumber.length() == 16 && bankName instanceof String) {
            return true;
        } else {
            return false;
        }
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
