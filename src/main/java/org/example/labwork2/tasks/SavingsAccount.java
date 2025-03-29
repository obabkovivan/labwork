package org.example.labwork2.tasks;

import org.example.labwork2.tasks.Supports.BankAccount;

public class SavingsAccount implements BankAccount {
    private double balance;

    public SavingsAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Сумма депозита должна быть положительной");
        } else {
            balance += amount;
            System.out.println("На счет внесено: " + amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Сумма для снятия должна быть положительной");
        } else if (amount > balance) {
            System.out.println("Недостаточно средств для снятия");
        } else {
            balance -= amount;
            System.out.println("Со счета снято: " + amount);
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
