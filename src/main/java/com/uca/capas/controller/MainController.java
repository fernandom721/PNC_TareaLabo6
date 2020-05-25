package com.uca.capas.controller;


import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        List<Importancia>importancias = null;
        try {
            importancias = importanciaDAO.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("importancia",importancias);
        mav.setViewName("main");
        return mav;
    }

}
