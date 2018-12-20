//Liesbeth

package gorissen.vleminckx.timco.controllers;

import gorissen.vleminckx.timco.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CheckoutController {

    @RequestMapping(value = {"/checkout"}, method = RequestMethod.GET)
    public String showCheckout() {
        return "checkout";
    }

    @ModelAttribute("newUser")
    public User newUser() {
        return new User();
    }

    @RequestMapping(value = "/confirmation", method = RequestMethod.POST)
    public String checkForErrors(@ModelAttribute("newUser") @Valid User newUser,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "checkout";
        }
        return "confirmation";
    }

}
