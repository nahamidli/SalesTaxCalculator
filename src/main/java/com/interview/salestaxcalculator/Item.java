package com.interview.salestaxcalculator;

import com.interview.salestaxcalculator.helper.ItemPropertiesReader;
import java.math.BigDecimal;

public class Item {
    private int quantity;
    private String name;
    private BigDecimal price;
    private boolean isImported;

    public Item(int quantity, String name, BigDecimal price, boolean isImported) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.isImported = isImported;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public BigDecimal getTaxAmount() {
        BigDecimal taxAmount = BigDecimal.ZERO;
        BigDecimal taxRate = BigDecimal.ZERO;

        // Add 10% basic sales tax
        if (!isExempt()) {
            taxRate = taxRate.add(BigDecimal.valueOf(10));
        }

        // Add 5% import duty
        if (isImported) {
            taxRate = taxRate.add(BigDecimal.valueOf(5));
        }

        taxAmount = getPrice().multiply(taxRate).divide(BigDecimal.valueOf(100));
        return roundToNearestFiveCents(taxAmount);
    }

    public BigDecimal getPriceWithTax() {
        return getPrice().add(getTaxAmount());
    }

    private boolean isExempt() {

        String[] exemptTypes = ItemPropertiesReader.getExemptItemTypes();

        for (String exemptType : exemptTypes) {
            if (name.contains(exemptType.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    // Method to round a BigDecimal value to the nearest multiple of 0.05
    private BigDecimal roundToNearestFiveCents(BigDecimal value) {
        BigDecimal roundedValue = value.divide(BigDecimal.valueOf(0.05)).setScale(0, BigDecimal.ROUND_UP);
        return roundedValue.multiply(BigDecimal.valueOf(0.05));
    }
}