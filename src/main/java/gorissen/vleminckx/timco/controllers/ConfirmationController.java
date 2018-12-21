package gorissen.vleminckx.timco.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//controller class for confirmation.html page
@Controller
public class ConfirmationController {

    //request mapping to return confirmation.html after uri request /confirmation
    @RequestMapping(value = {"/confirmation"}, method = RequestMethod.GET)
    public String goToConfirmation (){
        return "confirmation";
    }

}
