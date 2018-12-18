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
public class IndexController {

    @Autowired
    private ProductRepository repo;

    @ModelAttribute("all")
    public Iterable<Product> getAll(){
        return repo.findAll();
    }

    @RequestMapping(value = {"/index","/"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map){

        return "index";
    }

    @RequestMapping(value = "index/add/{id}", method = RequestMethod.GET)
    public String addToBasket(@PathVariable (value = "id") int id){
        return "redirect:/index";
    }

    @RequestMapping(value = "index/add/{id}", method = RequestMethod.POST)
    public String addToBasket(@PathVariable (value = "id") int id, ArrayList<Product> basket){
        Basket.INSTANCE.setBasket(basket);
        return "redirect:/index";
    }
}
