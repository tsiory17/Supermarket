

public class SupplierWarehouse {
    final int indexToUSe=6;
    private Item[] items = new Item[indexToUSe];
    private IItemBuilder[] builders = new IItemBuilder[indexToUSe];
    private Supplier []suppliers = new Supplier[indexToUSe];





    public SupplierWarehouse() {
        // Initialize the builders array
//        builders[0] = new ItemBakeryBuilder();
//        builders[1] = new ItemFruitBuilder();
//        builders[2] = new ItemMedicineBuilder();
//        builders[3] = new ItemCommoditiesBuilder();
//        builders[4] = new ItemBakeryBuilder();
//        builders[5] = new ItemFishBuilder();
//
//        // Call the method to add items to the items array
//        addItemsToArray();
        CreateSWarehouseItem();
    }

    private void addItemsToArray() {
        for (int i = 0; i < builders.length; i++) {
            items[i] = builders[i].getItem();
        }
    }

    public Item[] getItems() {
        return items;
    }
    public void CreateSWarehouseItem(){
        builders[0] = new ItemBakeryBuilder();
        builders[1] = new ItemFruitBuilder();
        builders[2] = new ItemMedicineBuilder();
        builders[3] = new ItemCommoditiesBuilder();
        builders[4] = new ItemVegetablesBuilder();
        builders[5] = new ItemFishBuilder();
        for (int i =0 ; i < suppliers.length;i++){
            suppliers[i]= new Supplier(builders[i]);
            suppliers[i].createItem();
            items[i]=suppliers[i].getItem();
        }
    }
}




