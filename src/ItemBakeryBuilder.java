
public class ItemBakeryBuilder implements IItemBuilder {
    Item item;

    public ItemBakeryBuilder(){
        item = new Item();
    }

    @Override
    public void setName() {
        item.setName("Bakery");
    }
    public void setQuantity(){
        item.setQuantity(1000);

    }

    public void setPrice(){

        item.setPrice(20);
    }

    public Item getItem(){
        return this.item;
    }
}
