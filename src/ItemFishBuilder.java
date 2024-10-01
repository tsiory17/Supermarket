

public class ItemFishBuilder implements IItemBuilder{
    Item item;

    public ItemFishBuilder(){
        item = new Item();
    }

    @Override
    public void setName() {
        item.setName("Fish");
    }
    public void setQuantity(){

        item.setQuantity(10000);

    }
    public void setPrice(){

        item.setPrice(50);
    }
    public Item getItem(){
        return this.item;
    }
}
