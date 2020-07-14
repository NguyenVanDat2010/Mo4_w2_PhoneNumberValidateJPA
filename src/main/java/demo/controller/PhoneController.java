package demo.controller;

import demo.model.Phone;
import demo.service.phone.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("phones")
public class PhoneController {
    @Autowired
    private IPhoneService phoneService;

    @GetMapping
    public String showPhoneValidate(Model model) {
        model.addAttribute("phone", new Phone());
        return "phone/index";
    }

    @PostMapping
    public String checkPhoneValidate(@Validated @ModelAttribute Phone phone, BindingResult bindingResult, Model model) {
        new Phone().validate(phone, bindingResult);
        if (bindingResult.hasErrors()) {
            return "phone/index";
        }
        phoneService.save(phone);
        model.addAttribute("phone", phone.getNumber());
//        System.out.println(phone.getNumber());
        return "phone/result";
    }
}
