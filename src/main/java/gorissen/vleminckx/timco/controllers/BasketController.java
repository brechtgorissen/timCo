//Brecht
package gorissen.vleminckx.timco.controllers;

import gorissen.vleminckx.timco.model.Basket;
import gorissen.vleminckx.timco.model.Product;
import gorissen.vleminckx.timco.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class BasketController {

    @Autowired
    private ProductRepository repo;

    @ModelAttribute("basket")
    public ArrayList<Product> showNewBasket(){
        return Basket.INSTANCE.getNewBasket();
    }

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String showBasket(ModelMap map){

        return "basket";
    }

    @RequestMapping(value = "/basket/delete/{id}", method = RequestMethod.GET)
    public String deleteFromBasket(@PathVariable(value = "id") int id){
        Basket.INSTANCE.deleteFromBasket(repo.findById(id).get());
        return "redirect:/basket";
    }
}
