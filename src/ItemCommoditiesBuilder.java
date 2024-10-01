
public class ItemCommoditiesBuilder implements IItemBuilder{

    Item item;

    public ItemCommoditiesBuilder(){
        item = new Item();
    }

    @Override
    public void setName() {
        item.setName("Commodities");
    }
    public void setQuantity(){
        item.setQuantity(10000);

    }
    public void setPrice(){

        item.setPrice(45);
    }
    public Item getItem(){
        return this.item;
    }

}
