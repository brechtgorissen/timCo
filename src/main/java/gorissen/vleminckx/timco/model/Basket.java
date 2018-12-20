//Brecht
package gorissen.vleminckx.timco.model;

import java.util.ArrayList;

public enum Basket {

    INSTANCE(new ArrayList<Product>());

    private ArrayList<Product> newBasket;

    private Basket(ArrayList<Product> newBasket) {

        this.newBasket = newBasket;
    }

    public ArrayList<Product> getNewBasket() {
        return newBasket;
    }

    public void setNewBasket(ArrayList<Product> newBasket) {
        this.newBasket = newBasket;
    }

    public void addToBasket(Product product) {
        newBasket.add(product);
    }

    public void deleteFromBasket(Product product) {
        newBasket.remove(product);
    }

}
