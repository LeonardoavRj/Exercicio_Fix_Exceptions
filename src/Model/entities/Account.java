package Model.entities;

import Model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private double balance;
	private double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, double balance, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) {
		if(withdrawLimit < amount) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if(balance < amount) {
			throw new DomainException("Not enough balance");
		}
		balance -= amount;
	}
	@Override
	public String toString() {
		return "New Balance: "+ String.format("%.2f%n",getBalance());
	}
}
