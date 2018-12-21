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

//controller class to control index.html page
@Controller
public class IndexController {

    //implementation of basic queries from ProductRepository
    @Autowired
    private ProductRepository repo;

    //model attribute used in html to show product information from products in ProductRepository
    @ModelAttribute("all")
    public Iterable<Product> getAll() {
        return repo.findAll();
    }

    //request mapping to return index.html after uri request
    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String showIndex() {
        return "index";
    }

    //request mapping to return index page showing only products from specified category
    @RequestMapping(value = "/index/{category}", method = RequestMethod.GET)
    public String findByCategory(ModelMap map, @PathVariable(value = "category") String category) {
        map.addAttribute("all", repo.findByCategory(category));
        return "index";
    }

    // request mapping using Product id to add product to Basket and redirect to basket.html
    @RequestMapping(value = "/index/add/{id}", method = RequestMethod.GET)
    public String addToBasket(@PathVariable(value = "id") int id) {
        Basket.INSTANCE.addToBasket(repo.findById(id).get());
        return "redirect:/basket";
    }
}
