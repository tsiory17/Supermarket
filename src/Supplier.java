public class Supplier {
    IItemBuilder ibuilder;

    Supplier(IItemBuilder ibuilder) {//aggregation
        this.ibuilder = ibuilder;
    }

   public void createItem(){
        this.ibuilder.setName();
        this.ibuilder.setQuantity();
        this.ibuilder.setPrice();
    }
    public Item getItem() {
        return this.ibuilder.getItem();
    }
}

//    void createHouse(){//this is where the engineer encapsulate the order of hte house
//        this.ibuilder.setName();
//        this.ibuilder.setPrice();
//        this.ibuilder.setQuantity();
//    }
//    Item getHouse(){
//        return this.ibuilder.getItem();
//    }
//}

