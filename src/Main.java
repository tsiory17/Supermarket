import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        SupplierWarehouse supplierWarehouse = new SupplierWarehouse();
        Warehouse warehouse = new Warehouse();
        warehouse.setBudget(100000);
        double totalExpenses = warehouse.getMoneySpent() + warehouse.getTotalPaidToEmployees();

        //Hire two employees to the market.
        Employee employee1 = new Employee(1, 2600.0);

        warehouse.addEmployee(employee1);


        while (true) {
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTime = currentTime.format(formatter);
            System.out.println("Date & Time: " + formattedTime);



            System.out.println("Your budget: $ " + warehouse.getBudget());
            System.out.println("Choose an option:");
            System.out.println("1. Buy items from the supplier");
            System.out.println("2. Sell items");
            System.out.println("3. View market inventory");
            System.out.println("4. Pay Employees");
            System.out.println("5. Expenses");
            System.out.println("6. Profit");
            System.out.println("7. Exit");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    buyItems(supplierWarehouse, warehouse, scanner);
                    break;
                case "2":
                    sellItems(warehouse, scanner);
                    break;
                case "3":
                    System.out.println("Warehouse inventory:");
                    warehouse.displayWarehouseInventory();
                    break;
                case "4":
                    warehouse.payEmployees();
                    break;
                case "5":
                    totalExpenses = warehouse.getMoneySpent() + warehouse.getTotalPaidToEmployees();//mod T
                    System.out.println("\nTotal spent on purchases: $ " + warehouse.getMoneySpent());
                    System.out.println("Employee payments: $ " + warehouse.getTotalPaidToEmployees());
                    System.out.println("Total expenses: $ " + totalExpenses + "\n");
                    break;
                case "6":
                    double totalEarnings = warehouse.getEarnings();
                    totalExpenses = warehouse.getTotalExpenses();// Mod T
                    double profit = totalEarnings - totalExpenses; // Lucro = Ganho Total - Despesas Total
                    System.out.println("Total earnings: $ " + totalEarnings);
                    System.out.println("Total expenses: $ " + totalExpenses);
                    System.out.println("Profit: $ " + profit + "\n");
                    break;
                case "7":
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void buyItems(SupplierWarehouse supplierWarehouse, Warehouse warehouse, Scanner scanner) {
        while (true) {
            //Display Suplier's inventory.
            System.out.println("Available items from the supplier:");
            Item[] items = supplierWarehouse.getItems();
            for (int i = 0; i < items.length; i++) {
                System.out.println(i + ". " + items[i].getName() + " - Price: $" + items[i].getPrice() + " - Quantity: " + items[i].getQuantity());
            }


            System.out.println("Enter the index of the item you want to buy or enter 'exit' to quit:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {

                break;
            }

            try {
                int itemIndex = Integer.parseInt(input);
                if (itemIndex >= 0 && itemIndex < items.length) {
                    //Ask the quantity
                    System.out.print("Enter the quantity you want to buy: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    // Buy the items
                    warehouse.buyItemsByIndex(supplierWarehouse, itemIndex, quantity);
                } else {
                    System.out.println("Invalid item index. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid item index or 'exit'.");
            }
        }

        // Display the warehouse stock.
        System.out.println("Warehouse inventory after shopping:");
        warehouse.displayWarehouseInventory();
        // Display the budget and the money spent.
        System.out.println("Remaining budget: $" + warehouse.getBudget());
        System.out.println("Total money spent: $" + warehouse.getMoneySpent());
    }

    private static void sellItems(Warehouse warehouse, Scanner scanner) {

        double totalEarnings=0;
        System.out.println("Items available for sale:");
        warehouse.displayWarehouseInventory();
        System.out.println("Enter the names of items you want to sell (comma-separated) or enter 'exit' to quit:");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("exit")) {
            return;
        }

        String[] itemNames = input.split(",");
        for (String itemName : itemNames) {
            itemName = itemName.trim();
            boolean itemFound = false;

            for (Item item : warehouse.getItemStored()) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    itemFound = true;
                    System.out.print("Enter the quantity of " + item.getName() + " you sold: ");
                    int quantitySold = Integer.parseInt(scanner.nextLine());

                    if (quantitySold <= item.getQuantity()) {
                        item.setQuantity(item.getQuantity() - quantitySold);
                        double earningsFromItem = item.getPrice() * quantitySold;
                        totalEarnings += earningsFromItem;
                        warehouse.setBudget(warehouse.getBudget() + earningsFromItem);
                        System.out.println(quantitySold + " units of " + item.getName() + " sold for $" + earningsFromItem);
                    } else {
                        System.out.println("Invalid quantity. Not enough in inventory.");
                    }

                    break;
                }
            }

            if (!itemFound) {
                System.out.println("Item not found: " + itemName);
            }

            warehouse.setTotalExpenses(warehouse.getTotalExpenses() + totalEarnings);


            warehouse.setEarning(warehouse.getEarnings() + totalEarnings);
        }


        System.out.println("Remaining budget: $" + warehouse.getBudget());
    }
}
