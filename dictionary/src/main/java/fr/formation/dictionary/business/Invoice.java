package fr.formation.dictionary.business;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

public class Invoice {

    private Long id;
    @NotEmpty
    private String reference;
    @PastOrPresent
    private LocalDate date;
    @NotNull()
    private Double amount;
    private boolean paid = false;

    // constructor
    public Invoice(String reference, LocalDate date, Double amount) {
	this.reference = reference;
	this.date = date;
	this.amount = amount;
    }

    //
    public String getReference() {
	return reference;
    }

    public void setReference(String reference) {
	this.reference = reference;
    }

    public LocalDate getDate() {
	return date;
    }

    public void setDate(LocalDate date) {
	this.date = date;
    }

    public Double getAmount() {
	return amount;
    }

    public void setAmount(Double amount) {
	this.amount = amount;
    }

    public boolean isPaid() {
	return paid;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("{id=");
	builder.append(id);
	builder.append(", reference=");
	builder.append(reference);
	builder.append(", date=");
	builder.append(date);
	builder.append(", amount=");
	builder.append(amount);
	builder.append(", paid=");
	builder.append(paid);
	builder.append("}");
	return builder.toString();
    }

    public void setPaid(boolean paid) {
	this.paid = paid;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Invoice() {
    }
}
