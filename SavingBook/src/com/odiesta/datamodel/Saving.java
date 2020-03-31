package com.odiesta.datamodel;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Saving {
    private SimpleStringProperty date;
    private SimpleLongProperty amountSaved;
    private final SimpleLongProperty totalSaving = new SimpleLongProperty();

    public static long counter = 0;

    public Saving(long amount) {
        this.date = new SimpleStringProperty(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(this.date.get());
        this.amountSaved = new SimpleLongProperty(amount);
        counter += amountSaved.get();
        totalSaving.set(counter);
    }

    public Saving() {
        this.date = new SimpleStringProperty();
        this.amountSaved = new SimpleLongProperty();
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public long getAmountSaved() {
        return amountSaved.get();
    }

    public void setAmountSaved(long amount) {
        amountSaved.set(amount);
    }

    public long getTotalSaving() {
        return totalSaving.get();
    }

    public void setTotalSaving(long total) {
        totalSaving.set(total);
    }

}
