package gorissen.vleminckx.timco.controllers;

import gorissen.vleminckx.timco.model.Basket;
import gorissen.vleminckx.timco.model.Product;
import gorissen.vleminckx.timco.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;

//controller class for control of basket.html page.
@Controller
public class BasketController {

    @Autowired
    private ProductRepository repo;

    //model attribute used in html to show product information from products added to basket
    @ModelAttribute("basket")
    public ArrayList<Product> showNewBasket() {
        return Basket.INSTANCE.getNewBasket();
    }

    //request mapping to return basket.html after uri request /basket
    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String showBasket() {
        return "basket";
    }

    //request mapping to delete product from basket by product id and redirect to basket.html
    @RequestMapping(value = "/basket/delete/{id}", method = RequestMethod.GET)
    public String deleteFromBasket(@PathVariable(value = "id") int id) {
        Basket.INSTANCE.deleteFromBasket(repo.findById(id).get());
        return "redirect:/basket";
    }

}
