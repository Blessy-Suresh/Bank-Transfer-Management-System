**Bank Transfer Management System (Java + JDBC + Oracle)**

The Bank Transfer Management System is a console-based Java application that performs secure bank account operations such as:

* Checking account balance
* Validating account numbers
* Transferring money between accounts
* Updating balances
* Recording transactions in database

 **layered architecture**:

```
Main → Service → DAO → Database
```


**Project Architecture**

```
com.wipro.bank
│
├── bean
│   └── TransferBean.java
│
├── dao
│   └── BankDAO.java
│
├── service
│   └── BankService.java
│
├── util
│   ├── DBUtil.java
│   └── InsufficientFundsException.java
│
└── main
    └── BankMain.java
```


**Layer Explanation**

 **1. Bean Layer**

* `TransferBean`
* Stores transaction details
* Uses getters and setters
* Represents transfer data object



 **DAO Layer (Database Access)**

* `BankDAO`
* Handles:

  * Account validation
  * Balance retrieval
  * Balance update
  * Transfer record insertion
  * Sequence generation

Uses:

* `PreparedStatement`
* `ResultSet`
* Oracle SQL queries


 **3. Service Layer**

* `BankService`
* Contains business logic:

  * Validate accounts
  * Check sufficient funds
  * Update balances
  * Record transfer
* Returns status messages:

  * SUCCESS
  * INVALID ACCOUNT
  * INSUFFICIENT FUNDS


 **4. Utility Layer**

* `DBUtil` → Creates Oracle DB connection
* `InsufficientFundsException` → Custom exception



**Features**

* Validate account number
* Check account balance
* Transfer money
* Prevent transfer if insufficient funds
* Store transaction history
* Auto-generate transaction ID using sequence

  ![WhatsApp Image 2026-02-11 at 9 44 32 PM](https://github.com/user-attachments/assets/d1c96a7a-a8be-46ea-b46f-c982aac734a4)


  <img width="568" height="225" alt="image" src="https://github.com/user-attachments/assets/9df8f266-6e33-4d53-b4e4-cd1e72123de4" />


