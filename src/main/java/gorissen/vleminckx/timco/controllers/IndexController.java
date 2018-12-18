//Brecht
package gorissen.vleminckx.timco.controllers;

import gorissen.vleminckx.timco.model.Product;
import gorissen.vleminckx.timco.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @RequestMapping(value= "/index/{category}", method = RequestMethod.GET)
    public String findByCategory(ModelMap map,@PathVariable (value="category") String category){
       map.addAttribute("all", repo.findByCategory(category));

        return "index";
    }


}
