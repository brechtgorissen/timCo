package gorissen.vleminckx.timco.model;

import java.util.ArrayList;
//enum with singleton pattern to represent one static instance of Product Basket
public enum Basket {

    INSTANCE(new ArrayList<Product>());

    private ArrayList<Product> newBasket;

    Basket(ArrayList<Product> newBasket) {

        this.newBasket = newBasket;
    }

    public ArrayList<Product> getNewBasket() {
        return newBasket;
    }
    //method to add products to basket
    public void addToBasket(Product product) {
        newBasket.add(product);
    }
    //method to remove products from basket
    public void deleteFromBasket(Product product) {
        newBasket.remove(product);
    }

}
