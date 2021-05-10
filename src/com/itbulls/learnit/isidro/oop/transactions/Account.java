package com.itbulls.learnit.isidro.oop.transactions;

import java.util.Arrays;

public class Account {
	
	private static final int DEFAULT_TRANSACTIONS_CAPACITY = 20;
	private static int transactionIndex;
	
	private int id;
	private Transaction[] transactions;
	
	{
		transactions = new Transaction[DEFAULT_TRANSACTIONS_CAPACITY];
	}
	
	public Account() {
		
	}
	
	public Account(int id)
	{
		this.id = id;
	}
	
	public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
		
		if(accountTo == null) {
			return;
		}
		if(moneyAmount <= 0) {
			return;
		}
		
		Transaction incomingTransaction = new Transaction(this, accountTo, moneyAmount,
				StandardAccountOperations.MONEY_TRANSFER_SEND);
		accountTo.receivedMoney(this, moneyAmount);
		setTransaction(incomingTransaction);
		
	}
	
	public void receivedMoney(Account accountFrom, double moneyAmount) {
		if(accountFrom == null) {
			return;
		}
		if(moneyAmount <= 0) {
			return;
		}
		
		Transaction incomingTransaction = new Transaction(accountFrom, this, moneyAmount,
				StandardAccountOperations.MONEY_TRANSFER_RECEIVE);
		setTransaction(incomingTransaction);
		
	}
	
	public void withdrawMoney(double moneyAmount) {
		if(moneyAmount <= 0) {
			return;
		}
		Transaction incomingTransaction = new Transaction(this, null, moneyAmount,
				StandardAccountOperations.WITHDRAW);
		setTransaction(incomingTransaction);
	}
	
	public void setTransaction(Transaction transaction) {
		if(transaction == null) {
			return;
		}
		
		if(transactions.length <= transactionIndex + 1) {
			transactions = Arrays.copyOf(transactions, transactions.length << 1);
		}
		transactions[transactionIndex++] = transaction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Transaction[] getTransactions() {
		int validTransactions = 0;
		
		for(Transaction transaction : transactions) {
			if(transaction != null) {
				validTransactions++;
			}
		}
		
		Transaction[] noNullTransactions = new Transaction[validTransactions];
		int i = 0;
		
		for(Transaction transaction : transactions) {
			if(transaction != null) {
				noNullTransactions[i] = transaction;
			}
		}
		
		return noNullTransactions;
	}

	
	@Override
	public String toString() {
		return "Account [id=" + id + "]";
	}


	public static class Transaction{
		
		private Account accountFrom;
		private Account accountTo;
		private double moneyAmount;
		StandardAccountOperations operation;
		
		{
			moneyAmount = 0;
		}
		
		public Transaction() {
			
		}
		
		public Transaction(Account accountFrom, Account accountTo, double moneyAmount,
				StandardAccountOperations operation) {
			this.accountFrom = accountFrom;
			this.accountTo = accountTo;
			this.moneyAmount = moneyAmount;
			this.operation = operation;
		}
		
		public Account getAccountFrom() {
			return accountFrom;
		}
		public void setAccountFrom(Account accountFrom) {
			this.accountFrom = accountFrom;
		}
		public Account getAccountTo() {
			return accountTo;
		}
		public void setAccountTo(Account accountTo) {
			this.accountTo = accountTo;
		}
		public double getMoneyAmount() {
			return moneyAmount;
		}
		public void setMoneyAmount(double moneyAmount) {
			this.moneyAmount = moneyAmount;
		}
		public StandardAccountOperations getOperation() {
			return operation;
		}
		public void setOperation(StandardAccountOperations operation) {
			this.operation = operation;
		}

		@Override
		public String toString() {
			return "Transaction [accountFrom=" + accountFrom + ", accountTo=" + accountTo
					+ ", moneyAmount=" + moneyAmount + ", operation=" + operation + "]";
		}
		
		
	}

}
