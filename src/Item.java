public class Item {

    private String name;

    private int quantity;
    private double price;

    public Item(String name,int quantity,double price){

        this.name=name;
        this.quantity=quantity;
        this.price=price;
    }
    public Item(){}
    public String getName (){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

    public double  getPrice (){
        return this.price;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public int getQuantity (){
        return this.quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=  quantity;
    }


}
