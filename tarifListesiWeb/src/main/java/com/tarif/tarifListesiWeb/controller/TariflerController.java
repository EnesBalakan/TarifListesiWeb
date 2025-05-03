package com.tarif.tarifListesiWeb.controller;

import com.tarif.tarifListesiWeb.entity.Tarifler;
import com.tarif.tarifListesiWeb.service.TariflerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tarifler")
public class TariflerController {
    private TariflerService tariflerService;

    public TariflerController(TariflerService theTariflerService){
        tariflerService = theTariflerService;
    }

    // tüm tarifleri ekrana yazdıran api
    @GetMapping("/list")
    public String list(Model theModel){

        // Veritbanından verileri çekme
        List<Tarifler> theTarifler = tariflerService.findAll();

        // spring modele ekle
        theModel.addAttribute("tarifler", theTarifler);

        return "tarifler/list-tarifler";
    }

    // Ekleme Arayüzü
    @GetMapping("/showFormForAdd")
    public String showFormAdd(Model theModel){

        // create model attribute to bind form data
        Tarifler theTarifler = new Tarifler();

        theModel.addAttribute("tarifler" , theTarifler);

        return "tarifler/tarif-ekleme";
    }

    @PostMapping("/save")
    public String saveTarif(@ModelAttribute("tarifler") Tarifler theTarifler){

        // save the employee
        tariflerService.save(theTarifler);

        // use a redirect to prevent duplicate submiss
        return "redirect:/tarifler/list";
    }

    // Güncelleme Arayüzü
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("tariflerId")int theId, Model theModel){
        // get the tarifler from the service
        Tarifler theTarifler = tariflerService.findById(theId);

        // set tarifler in the model to prepopulate the form
        theModel.addAttribute("tarifler", theTarifler);

        // send over to our form
        return "tarifler/tarif-ekleme";
    }

    // Silme İşlemi
    @GetMapping("/delete")
    public String delete(@RequestParam("tariflerId")int theId){

        // delete the tarif
        tariflerService.deleteById(theId);

        //redirect to the list
        return "redirect:/tarifler/list";
    }
}
