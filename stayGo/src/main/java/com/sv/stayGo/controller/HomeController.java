package com.sv.stayGo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;
import com.sv.stayGo.model.Hospedaje;
import com.sv.stayGo.repository.HospedajeRepository;

@Controller
public class HomeController {

    private final HospedajeRepository hospedajeRepository;

    public HomeController(HospedajeRepository hospedajeRepository) {
        this.hospedajeRepository = hospedajeRepository;
    }

    @GetMapping({"/", "/home"})
    public String index(Model model) {
        // Populares → últimos 4 por fecha
        List<Hospedaje> populares = hospedajeRepository.findTop4ByOrderByFechaPublicacionDesc();

        // Solo los de San Salvador (máximo 3)
        List<Hospedaje> sanSalvador = hospedajeRepository.findTop3ByDestinoIgnoreCaseContainingOrderByFechaPublicacionDesc("San Salvador");
        
        model.addAttribute("sanSalvador", sanSalvador);
        model.addAttribute("populares", populares);

        return "index"; 
    }
}