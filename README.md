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

1. Make sure you have JDK (Java Development Kit) installed on your computer. If you don't have it, you can download and install it from the official Oracle website..
2. Download the Sales Tax Calculator App source code from the repository and unzip it to a directory of your choice.
3. Open a terminal or command prompt window and navigate to the root directory of the unzipped project.
4. Run the following command to build the project:
   ` ./gradlew build ` <br>
5. Once the build is successful, navigate to the build/libs directory.
6. Run the following command to start the Sales Tax Calculator App:
 `java -jar SalesTaxCalculator-1.0-SNAPSHOT.jar`
7. Alternatively, you can run the app directly from Gradle by running the following command:
 `./gradlew run`
8. Once the app starts, enter the items in the basket one by one in the format `<quantity> <item> at <price>`.
9. Press Enter after each item to add it to the basket.
10. Press Enter without entering any input to calculate the total tax and amount for the basket and display the receipt. 
11. Review the receipt to see the item details, tax amount, and total amount.

`NOTE:` You can also run the SalesTaxCalculatorApp.java file in IntelliJ IDEA or any other IDE and follow the same steps to use the app.

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