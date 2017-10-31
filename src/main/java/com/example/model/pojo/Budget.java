package com.example.model.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Budget {
	private long budgedId;
	private String name;
    private BigDecimal initialAmount;
	private BigDecimal amount;
	private LocalDateTime fromDate;
	private LocalDateTime toDate;
    private long walletId;
	private long categoryID;
	private List<Transaction> transactions;

    public Budget(long budgedId, String name, BigDecimal initialAmount, BigDecimal amount, LocalDateTime fromDate, LocalDateTime toDate, long walletId, long categoryID, List<Transaction> transactions) {
        this(name, initialAmount, amount, fromDate, toDate, walletId, categoryID, transactions);
        this.budgedId = budgedId;
    }

    public Budget(String name, BigDecimal initialAmount, BigDecimal amount, LocalDateTime fromDate, LocalDateTime toDate, long walletId, long categoryID, List<Transaction> transactions ) {
        this.name = name;
        this.initialAmount = initialAmount;
        this.amount = amount;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.walletId = walletId;
        this.categoryID = categoryID;
        this.transactions = transactions;
    }

    public long getBudgedId() {
        return budgedId;
    }

    public void setBudgetId(long budgedId) {
        this.budgedId = budgedId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getInitialAmount() {
        return initialAmount;
    }

    public long getWalletId() {
        return walletId;
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
