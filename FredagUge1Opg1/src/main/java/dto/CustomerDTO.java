
package dto;

import entities.BankCustomer;


public class CustomerDTO {
    private long customerId;
    private String fullName;
    private String accountNumber;
    private double balance;

    public CustomerDTO(BankCustomer bankCustomer) {
        this.customerId = bankCustomer.getId();
        this.fullName = bankCustomer.getFirstName() + " " + bankCustomer.getLastName();
        this.accountNumber = bankCustomer.getAccountNumber();
        this.balance = bankCustomer.getBalance();
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
