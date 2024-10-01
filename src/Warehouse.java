import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Warehouse {

    private ArrayList<Item> itemStored;
    private ArrayList<SoldItem> itemsSold;
    private List<Employee> employees = new ArrayList<>();
    private long lastPaymentTimeMinutes = System.currentTimeMillis() / (60 * 1000);
    private double totalPaidToEmployees;
    private double budget;
    private double moneyEarned;
    private double moneySpent=0;
    private double totalExpenses;
    public double getTotalExpenses(){
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses){
        this.totalExpenses=totalExpenses;
    }
    public double getMoneySpent() {
        return moneySpent;
    }
    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    private double earning;
    public double getEarnings() {
        return earning;
    }
    public void setEarning(double earning){
        this.earning=earning;
    }

    public ArrayList <Item> getItemStored() {
        return itemStored;
    }

    public double getTotalPaidToEmployees(){
        return totalPaidToEmployees;
    }

    public double getBudget() {
        return this.budget;
    }
    public Warehouse() {
        this.itemStored = new ArrayList<>();

    }

    public void addItem(Item item) {
        boolean itemExists = false;
        for (Item storedItem : itemStored) {
            if (storedItem.getName().equals(item.getName())) {

                storedItem.setQuantity(storedItem.getQuantity() + item.getQuantity());//Mod T

                storedItem.setPrice(item.getPrice());
                itemExists = true;
                System.out.println("Quantity of item " + item.getName() + " increased to " + storedItem.getQuantity());
                break;
            }
        }

        if (!itemExists) {

            Item newItem = new Item(item.getName(), item.getQuantity(), item.getPrice());
            itemStored.add(newItem);
            System.out.println("New item added to inventory: " + item.getName() + " with quantity " + item.getQuantity());
        }
    }
    public void buyItemsByIndex(SupplierWarehouse supplierWarehouse, int index, int quantity) {
        Item[] supplierItems = supplierWarehouse.getItems();
        if (index >= 0 && index < supplierItems.length) {
            Item selectedItem = supplierItems[index];
            double totalPrice = selectedItem.getPrice() * quantity;
//

            if (budget >= totalPrice && selectedItem.getQuantity() >= quantity) {
                budget -= totalPrice;
                moneySpent += totalPrice;
                int quantityInitial = selectedItem.getQuantity();
                selectedItem.setQuantity(selectedItem.getQuantity() - quantity);


                for (Item storedItem : itemStored) {
                    if (storedItem.getName().equals(selectedItem.getName())) {
                        int remainingQuantity = storedItem.getQuantity() + quantity;//mod T
                        if (remainingQuantity > 0) {
                            storedItem.setQuantity(remainingQuantity);}

                        storedItem.setPrice(selectedItem.getPrice()*2);//mod T
                        System.out.println(quantity + " units of item " + storedItem.getName() + " purchased.");
                        System.out.println("Quantity of item " + storedItem.getName() + " increased to " + storedItem.getQuantity());
                        return;
                    }
                }

                // If the item does not exist in the warehouse, add it
                Item purchasedItem = new Item(selectedItem.getName(), (quantityInitial-selectedItem.getQuantity()), selectedItem.getPrice()*2);//mod T
                itemStored.add(purchasedItem);
                System.out.println(quantity + " units of item " + selectedItem.getName() + " purchased.");
                System.out.println("New item added to inventory: " + selectedItem.getName() + " with quantity " + quantity);
            } else if (selectedItem.getQuantity() < quantity) {
                System.out.println("Insufficient quantity in the supplier.");
            } else {
                System.out.println("Insufficient budget to buy the selected items.");
            }
        } else {
            System.out.println("Invalid index. Please select a valid item.");
        }
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public void displayWarehouseInventory() {
        System.out.println("Warehouse Inventory:");
        for (Item storedItem : itemStored) {
            System.out.println("Name: " + storedItem.getName() + " - Quantity: " + storedItem.getQuantity() + " - Price: $" + storedItem.getPrice());
        }
    }
    public void sellItems() {
        Scanner scanner = new Scanner(System.in);
        double totalEarnings=0 ;//mod T

        System.out.println("Items available for sale:");
        displayWarehouseInventory();
        System.out.println("Enter the names of items you want to sell (comma-separated) or enter 'exit' to quit:");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("exit")) {
            return;
        }

        String[] itemNames = input.split(",");
        for (String itemName : itemNames) {
            itemName = itemName.trim();
            boolean itemFound = false;

            for (Item item : itemStored) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    itemFound = true;
                    System.out.print("Enter the quantity of " + item.getName() + " you sold: ");
                    int quantitySold = Integer.parseInt(scanner.nextLine());

                    if (quantitySold <= item.getQuantity()) {
                        item.setQuantity(item.getQuantity() - quantitySold);
                        double earningsFromItem = item.getPrice() * quantitySold;
                        totalEarnings += earningsFromItem;
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
        }

        earning += totalEarnings;
        budget += totalEarnings;
        totalExpenses += totalEarnings;// T mod
        System.out.println("Total earnings from this sale: $" + totalEarnings);
    }
    public void payEmployees() {
        long currentTimeMinutes = System.currentTimeMillis() / (60 * 1000);
        long timeElapsedSinceLastPayment = currentTimeMinutes - lastPaymentTimeMinutes;


        double totalPayment = 0.0;
        for (Employee employee : employees) {
            totalPayment += employee.salary * timeElapsedSinceLastPayment;
        }


        if (budget >= totalPayment) {

            budget -= totalPayment;


            totalPaidToEmployees += totalPayment;
            lastPaymentTimeMinutes = currentTimeMinutes;


            System.out.println("Paid $" + totalPayment + " to employees.");

            System.out.println("Total paid until now $" + totalPaidToEmployees);

            System.out.println("Budget $" + budget);

        } else {
            System.out.println("Insufficient budget to pay employees.");
        }
    }


}

