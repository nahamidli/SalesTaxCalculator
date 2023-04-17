package com.interview.salestaxcalculator.test;

import com.interview.salestaxcalculator.Item;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void testGetTaxAmount() {
        // Create an item with quantity 1, name "book", price $12.49, not imported
        Item item = new Item(1, "book", new BigDecimal("12.49"), false);

        // Expected tax amount for the item with no tax rate
        BigDecimal expectedTaxAmount = BigDecimal.ZERO.setScale(2);

        // Assert that the calculated tax amount matches the expected value
        assertEquals(expectedTaxAmount, item.getTaxAmount());
    }

    @Test
    public void testGetPriceWithTax() {
        // Create an item with quantity 1, name "music CD", price $14.99, not imported
        Item item = new Item(1, "music CD", new BigDecimal("14.99"), false);

        // Expected price with tax for the item with 10% tax rate
        BigDecimal expectedPriceWithTax = new BigDecimal("16.49").setScale(2); // Update here

        // Assert that the calculated price with tax matches the expected value
        assertEquals(expectedPriceWithTax, item.getPriceWithTax());
    }

    @Test
    public void testGetPriceWithTaxForExemptItem() {
        // Create an item with quantity 1, name "chocolate bar", price $0.85, not imported
        Item item = new Item(1, "chocolate bar", new BigDecimal("0.85"), false);

        // Expected price with tax for the exempt item with no tax rate
        BigDecimal expectedPriceWithTax = new BigDecimal("0.85").setScale(2);

        // Assert that the calculated price with tax matches the expected value
        assertEquals(expectedPriceWithTax, item.getPriceWithTax());
    }

    @Test
    public void testGetPriceWithTaxForImportedItem() {
        // Create an item with quantity 1, name "imported box of chocolates", price $10.00, imported
        Item item = new Item(1, "imported box of chocolates", new BigDecimal("10.00"), true);

        // Expected price with tax for the imported item with 5% tax rate and import tax rate
        BigDecimal expectedPriceWithTax = new BigDecimal("10.50").setScale(2); // Update here

        // Assert that the calculated price with tax matches the expected value
        assertEquals(expectedPriceWithTax, item.getPriceWithTax());
    }

    @Test
    public void testGetPriceWithTaxForExemptImportedItem() {
        // Create an item with quantity 1, name "imported book", price $15.00, imported
        Item item = new Item(1, "imported book", new BigDecimal("15.00"), true);

        // Expected price with tax for the imported item with no tax rate and import tax rate
        BigDecimal expectedPriceWithTax = new BigDecimal("15.75").setScale(2); // Update here

        // Assert that the calculated price with tax matches the expected value
        assertEquals(expectedPriceWithTax, item.getPriceWithTax());
    }
}
