package org.example.labwork2.tasks.Supports;

public interface BankAccount {
    void deposit(double amount);  // метод для депозита
    void withdraw(double amount); // метод для снятия денег
    double getBalance();          // метод для получения текущего баланса
}
