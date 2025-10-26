//You have been tasked with writing a program for a popular bank that will automate all its incoming transactions (transfer, deposit, and withdraw). The bank has n accounts numbered from 1 to n. The initial balance of each account is stored in a 0-indexed integer array balance, with the (i + 1)th account having an initial balance of balance[i].
//Execute all the valid transactions. A transaction is valid if:
//The given account number(s) are between 1 and n, and
//The amount of money withdrawn or transferred from is less than or equal to the balance of the account.
//Implement the Bank class:
//Bank(long[] balance) Initializes the object with the 0-indexed integer array balance.
//boolean transfer(int account1, int account2, long money) Transfers money dollars from the account numbered account1 to the account numbered account2. Return true if the transaction was successful, false otherwise.
//boolean deposit(int account, long money) Deposit money dollars into the account numbered account. Return true if the transaction was successful, false otherwise.
//boolean withdraw(int account, long money) Withdraw money dollars from the account numbered account. Return true if the transaction was successful, false otherwise.

class Bank {
    long [] balance;
    int n;
    public Bank(long[] balance) {
        this.balance=balance;
        this.n=balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (account1>n||account2>n||balance[account1-1]<money) 
            return false;
        balance[account1-1]-=money;
        balance[account2-1]+=money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if (account>n) return false;
        balance[account-1]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (account>n||balance[account-1]<money) 
            return false;
        balance[account-1]-=money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
