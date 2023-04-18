# Sales Tax Calculator App
This is a simple Java console application that calculates the total price and tax amount for a list of items in a shopping basket. 
The application takes input from the user in the format of "\<quantity> \<item> at \<price>" for each item, and calculates the total tax and amount for the entire basket. 
The application also takes into account basic sales tax (10%) and import duty (5%) for items that are not exempted.


## Features
The Sales Tax Calculator App provides the following features:

- User-friendly console interface for inputting items in the basket
- Basic sales tax calculation (10%) for non-exempted items
- Import duty calculation (5%) for imported items
- Rounding to the nearest 0.05 for tax amounts
- Display of item details, tax amount, and total amount in the receipt


## Usage

To use the Sales Tax Calculator App, follow these steps:

1. Compile and run the `SalesTaxCalculatorApp.java` file using a Java compiler or integrated development environment (IDE).
2. Enter the items in the basket one by one in the format "\<quantity> \<item> at \<price>".
3. Press Enter after each item to add it to the basket.
4. Press Enter without entering any input to calculate the total tax and amount for the basket and display the receipt.
5. Review the receipt to see the item details, tax amount, and total amount.


### Example Input:

Here's an example of how to enter items in the basket:



`Welcome to Sales Tax Calculator App! ` <br>
`Enter the items in the basket (one item per line, format: '<quantity> <item> at <price>'):` <br>

`1 book at 12.49` <br>
`1 music CD at 14.99` <br>
`1 chocolate bar at 0.85` <br>

### Example Output:

`1 book: 12.49`<br>
`1 music CD: 16.49`<br>
`1 chocolate bar: 0.85`<br>
`Sales Taxes: 1.50`<br>
`Total: 29.83`<br>

## Adding Additional Exempted Items

Currently, the following items are exempted from sales tax:
- Chocolate
- Books
- Pills

To add additional exempted items, you can modify the item-types.properties file.
The item-types.properties file contains a list of exempted items, with each item specified as a comma-separated value in the format: 
`exempt.item.types=BOOK,CHOCOLATE,PILL`

## Testing

The Sales Tax Calculator App includes unit tests for the Item class in the ItemTests.java file. 
These tests can be run using a testing framework such as JUnit.