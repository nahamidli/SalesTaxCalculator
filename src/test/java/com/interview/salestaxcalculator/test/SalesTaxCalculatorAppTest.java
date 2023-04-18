package com.interview.salestaxcalculator.test;

import com.interview.salestaxcalculator.Item;
import com.interview.salestaxcalculator.SalesTaxCalculatorApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class SalesTaxCalculatorAppTest {

    @InjectMocks
    private SalesTaxCalculatorApp salesTaxCalculatorApp;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testParseInput(){

        // Test case 1: Valid input
        String input1 = "1 book at 12.49";
        Item item1 = salesTaxCalculatorApp.parseInput(input1);
        assertNotNull(item1);
        assertEquals(1, item1.getQuantity());
        assertEquals("book", item1.getName());
        assertEquals(new BigDecimal("12.49"), item1.getPrice());
        assertFalse(item1.isImported());

        // Test case 2: Valid input with imported item
        String input2 = "1 imported box of chocolates at 10.00";
        Item item2 = salesTaxCalculatorApp.parseInput(input2);
        assertNotNull(item2);
        assertEquals(1, item2.getQuantity());
        assertEquals("box of chocolates", item2.getName());
        assertEquals(new BigDecimal("10.00"), item2.getPrice());
        assertTrue(item2.isImported());

        // Test case 3: Invalid input
        String input3 = "invalid input";
        Item item3 = salesTaxCalculatorApp.parseInput(input3);
        assertNull(item3);
    }
}