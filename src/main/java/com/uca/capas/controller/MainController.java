package com.uca.capas.controller;


import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ContribuyenteDAO contribuyenteDAO;
    @Autowired
    private ContribuyenteService contribuyenteService;
    @Autowired
    private ImportanciaDAO importanciaDAO;
    @Autowired
    private ImportanciaService importanciaService;

    @RequestMapping("/main")
    public ModelAndView initMain(){
        ModelAndView mav = new ModelAndView();
        List<Importancia>importancias = new ArrayList<>();
        try {
            importancias = importanciaService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("contribuyente",new Contribuyente());
        mav.addObject("importancia",importancias);
        mav.setViewName("main");
        return mav;
    }

    @RequestMapping("/form")
    public ModelAndView form(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result){
        ModelAndView mav = new ModelAndView();
        try {
            contribuyenteService.insert(contribuyente);
            mav.setViewName("exito");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("/listado")
    public ModelAndView listado(){
        return VerListado();
    }

    public ModelAndView VerListado(){
        ModelAndView mav = new ModelAndView();
        List<Contribuyente> contribuyentes = null;
        List<String> fechas = null;
        try{
            contribuyentes = contribuyenteService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        mav.addObject("contribuyentes", contribuyentes);
        mav.setViewName("listado");
        return mav;
    }

}
