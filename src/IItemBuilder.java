public interface IItemBuilder {
    void setName();
    void setQuantity();
    void setPrice();

    Item getItem();
}
