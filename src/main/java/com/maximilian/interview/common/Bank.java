package com.maximilian.interview.common;

/**
 * You have been tasked with writing a program for a popular bank that will
 * automate all its incoming transactions (transfer, deposit, and withdraw).
 * The bank has n accounts numbered from 1 to n. The initial balance of each
 * account is stored in a 0-indexed integer array balance, with the (i + 1)th
 * account having an initial balance of balance[i].
 * <p>
 * Execute all the valid transactions. A transaction is valid if:
 * <p>
 * The given account number(s) are between 1 and n, and
 * The amount of money withdrawn or transferred from is less than or equal to
 * the balance of the account.
 * Implement the Bank class:
 * <p>
 * Bank(long[] balance) Initializes the object with the 0-indexed integer array balance.
 * boolean transfer(int account1, int account2, long money) Transfers money
 * dollars from the account numbered account1 to the account numbered account2.
 * Return true if the transaction was successful, false otherwise.
 * boolean deposit(int account, long money) Deposit money dollars into the
 * account numbered account. Return true if the transaction was successful, false otherwise.
 * boolean withdraw(int account, long money) Withdraw money dollars from the
 * account numbered account. Return true if the transaction was successful, false otherwise.
 * <p>
 * Constraints:
 * <p>
 * n == balance.length
 * 1 <= n, account, account1, account2 <= 10^5
 * 0 <= balance[i], money <= 10^12
 * At most 10^4 calls will be made to each function transfer, deposit, withdraw.
 */
public class Bank {

    private final long[] accountBalances;

    public Bank(long[] balance) {
        this.accountBalances = new long[balance.length];
        System.arraycopy(balance, 0, accountBalances, 0, balance.length);
    }

    public boolean transfer(int account1, int account2, long money) {
        account1--;
        account2--;
        if (!isAccountValid(account1) || !isAccountValid(account2) ||
                accountBalances[account1] < money || money < 0) {
            return false;
        }
        accountBalances[account1] -= money;
        accountBalances[account2] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        account--;
        if (!isAccountValid(account) || money < 0) {
            return false;
        }
        accountBalances[account] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        account--;
        if (!isAccountValid(account) || accountBalances[account] < money || money < 0) {
            return false;
        }
        accountBalances[account] -= money;
        return true;
    }

    private boolean isAccountValid(int account) {
        return account >= 0 && account < accountBalances.length;
    }

}
