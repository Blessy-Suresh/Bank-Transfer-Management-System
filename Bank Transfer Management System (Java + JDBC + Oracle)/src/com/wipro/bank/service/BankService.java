package com.wipro.bank.service;

import com.wipro.bank.dao.BankDAO;
import com.wipro.bank.bean.TransferBean;

public class BankService {

    public String checkBalance(String accountNumber) {

        BankDAO bankDAO = new BankDAO();

        if (bankDAO.validateAccount(accountNumber)) {
            float balance = bankDAO.findBalance(accountNumber);
            return "BALANCE " + balance;
        }
        return "ACCOUNT NUMBER IS INVALID";
    }

    public String transfer(TransferBean transferBean) {

        BankDAO bankdao = new BankDAO();

        if (transferBean == null) {
            return "INVALID";
        }

        if (bankdao.validateAccount(transferBean.getFromAccountNumber())
                && bankdao.validateAccount(transferBean.getToAccountNumber())) {

            float fromAccountBalance =bankdao.findBalance(transferBean.getFromAccountNumber());

            float toAccountBalance = bankdao.findBalance(transferBean.getToAccountNumber());

            if (fromAccountBalance >= transferBean.getAmount()) {

                fromAccountBalance = fromAccountBalance - transferBean.getAmount();
                toAccountBalance = toAccountBalance + transferBean.getAmount();
                bankdao.updateBalance( transferBean.getFromAccountNumber(),fromAccountBalance);
                bankdao.updateBalance(transferBean.getToAccountNumber(),toAccountBalance);
                bankdao.transferMoney(transferBean);

                return "SUCCESS";
            } else {
                return "INSUFFICIENT FUNDS";
            }
        } else {
            return "INVALID ACCOUNT";
        }
    }
}
