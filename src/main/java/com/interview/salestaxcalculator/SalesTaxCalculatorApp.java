package com.interview.salestaxcalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesTaxCalculatorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> basket = new ArrayList<>();
        System.out.println("Welcome to Sales Tax Calculator App!\n");
        System.out.println("Enter the items in the basket (one item per line, format: '<quantity> <item> at <price>'): ");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            Item item = parseInput(input);
            if (item != null) {
                basket.add(item);
            }
        }
        scanner.close();
        printReceipt(basket);
    }

    public static Item parseInput(String input) {
        String[] parts = input.split(" ");
        if (parts.length >= 4) {
            int quantity = Integer.parseInt(parts[0]);
            BigDecimal price = new BigDecimal(parts[parts.length - 1]);
            boolean isImported = input.contains("imported");
            String name = input.substring(quantity + 1, input.indexOf(" at")).trim();
            return new Item(quantity, name, price, isImported);
        }
        return null;
    }

    public static void printReceipt(List<Item> basket) {
        BigDecimal totalTax = BigDecimal.ZERO;
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (Item item : basket) {
            String itemDetails = item.getQuantity() + " " + (item.isImported() ? "imported " : "") + item.getName() + ": " + item.getPriceWithTax();
            System.out.println(itemDetails);
            totalTax = totalTax.add(item.getTaxAmount());
            totalAmount = totalAmount.add(item.getPriceWithTax());
        }

        System.out.println("Sales Taxes: " + totalTax);
        System.out.println("Total: " + totalAmount);
    }
}