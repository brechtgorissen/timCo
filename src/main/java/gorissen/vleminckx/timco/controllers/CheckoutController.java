package gorissen.vleminckx.timco.controllers;

import gorissen.vleminckx.timco.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
// controller class for control of checkout.html page
@Controller
public class CheckoutController {
    //request mapping to return checkout.html after uri request /checkout
    @RequestMapping(value = {"/checkout"}, method = RequestMethod.GET)
    public String showCheckout() {
        return "checkout";
    }
    //model attribute used in checkout.html to create form input fields for user
    @ModelAttribute("newUser")
    public User newUser() {
        return new User();
    }
    //request mapping used to validate user form input
    //if valid returns confirmation.html page
    //if not valid returns back to checkout.html with error messages defined in fields from User class
    @RequestMapping(value = "/confirmation", method = RequestMethod.POST)
    public String checkForErrors(@ModelAttribute("newUser") @Valid User newUser,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "checkout";
        }
        return "confirmation";
    }

}
