import java.util.Random;

public class ItemMedicineBuilder implements IItemBuilder{
    Item item;

    public ItemMedicineBuilder(){
        item = new Item();
    }

    @Override
    public void setName() {
        item.setName("Medicine");
    }
    public void setQuantity(){

        item.setQuantity(10000);

    }
    public void setPrice(){

        item.setPrice(60);
    }
    public Item getItem(){
        return this.item;
    }
}
