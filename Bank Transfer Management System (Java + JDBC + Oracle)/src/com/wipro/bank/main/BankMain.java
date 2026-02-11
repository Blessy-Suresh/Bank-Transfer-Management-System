package com.wipro.bank.main;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.service.BankService;

public class BankMain {
	public static void main(String[] args) {

	    BankService bankService = new BankService();
	    System.out.println(bankService.checkBalance("123456789"));
	    TransferBean transferBean = new TransferBean();
	    transferBean.setFromAccountNumber("123456789");
	    transferBean.setToAccountNumber("344453455");
	    transferBean.setAmount(400);
	    transferBean.setDateOFTransaction(new java.util.Date());
	    System.out.println(bankService.transfer(transferBean));
	}
}
