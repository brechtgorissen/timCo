//Liesbeth

package gorissen.vleminckx.timco.controllers;

import gorissen.vleminckx.timco.model.Product;
import gorissen.vleminckx.timco.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DetailsController {

    @Autowired
    private ProductRepository repo;

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String showDetails (@PathVariable(name="id") int id , ModelMap map){

        Product detailProduct = repo.findById(id).get();
        map.addAttribute("product", detailProduct);
        return "details";
    }

}
