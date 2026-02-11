package com.wipro.bank.bean;
import java.util.Date;

public class TransferBean {
      private int transactionID;
      private String fromAccountNumber;
      private String toAccountNumber;
      private Date dateOFTransaction;
      private float amount;
      
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public String getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public String getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public Date getDateOFTransaction() {
		return dateOFTransaction;
	}
	public void setDateOFTransaction(Date dateOFTransaction) {
		this.dateOFTransaction = dateOFTransaction;
	}
	public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
}
