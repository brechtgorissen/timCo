//Brecht
package gorissen.vleminckx.timco.controllers;

import gorissen.vleminckx.timco.model.Basket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasketController {

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String showBasket(){
        Basket.INSTANCE.getBasket();
        return "basket";
    }
}
