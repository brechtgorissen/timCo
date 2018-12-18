package gorissen.vleminckx.timco.model;

import java.util.ArrayList;

public enum Basket {

    INSTANCE(new ArrayList<Product>());
    private ArrayList<Product> basket;

    private Basket(ArrayList<Product> basket) {
        this.basket = basket;
    }

    public ArrayList<Product> getBasket() {
        return basket;
    }

    public void setBasket(ArrayList<Product> basket) {
        this.basket = basket;
    }
}
