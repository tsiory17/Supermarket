

public class ItemFruitBuilder implements IItemBuilder{
    Item item;

    public ItemFruitBuilder(){
        item = new Item();
    }

    @Override
    public void setName() {
        item.setName("Fruit");
    }
    public void setQuantity(){

        item.setQuantity(10000);

    }
    public void setPrice(){

        item.setPrice(10);
    }
    public Item getItem(){
        return this.item;
    }
}
