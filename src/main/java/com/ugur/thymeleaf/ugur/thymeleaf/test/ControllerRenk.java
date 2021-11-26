package com.ugur.thymeleaf.ugur.thymeleaf.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerRenk {
    private static List<Renk> renkler = new ArrayList<>();
    private static int sayici = 0;

    @GetMapping("renkeglence")
    public String renkeglence(Model model) {
        model.addAttribute("arkaplanrengi");
        if (renkler.size() == sayici)
            sayici = 0;
        model.addAttribute("backgroundColor", "background-color:" + renkler.get(sayici).getCssdegeri());
        sayici++;
        return "renkeglence";
    }

    @GetMapping("renklerform")
    public String renkformu(Model model) {
        model.addAttribute("honolulu", new Renk());

        return "renkgirisformu";
    }
    @PostMapping("renksecimi")
        public String renklerikaydet (Renk renklerikaydet){
        renkler.add(renklerikaydet);
        return "renkgirisformu";
    }
}
