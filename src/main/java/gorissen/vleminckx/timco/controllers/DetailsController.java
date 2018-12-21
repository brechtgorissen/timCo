package gorissen.vleminckx.timco.controllers;

import gorissen.vleminckx.timco.model.Basket;
import gorissen.vleminckx.timco.model.Product;
import gorissen.vleminckx.timco.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//controller class for details.html page
@Controller
public class DetailsController {

    //implementation of basic queries from ProductRepository
    @Autowired
    private ProductRepository repo;

    // request mapping to return details.html for product with specific id, using query from ProductRepository
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String showDetails(@PathVariable(name = "id") int id, ModelMap map) {

        Product detailProduct = repo.findById(id).get();
        map.addAttribute("product", detailProduct);
        return "details";
    }

    // request mapping using Product id to add product to Basket from details.html
    @RequestMapping(value = "/details/add/{id}", method = RequestMethod.GET)
    public String addToBasket(@PathVariable(value = "id") int id, ModelMap map) {
        Basket.INSTANCE.addToBasket(repo.findById(id).get());
        Product detailProduct = repo.findById(id).get();
        map.addAttribute("product", detailProduct);
        return "redirect:/basket";
    }

}
