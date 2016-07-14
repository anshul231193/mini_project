/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.controller;

import com.mind.model.Exercise;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author anshul
 */

@Controller
public class MinutesController {
    
    @RequestMapping(value="/addMinutes")
    public String addMinutes(@ModelAttribute ("exercise") Exercise exercise) {
        System.out.println("exercise: "+exercise.getMinutes());
        return "addMinutes";
    }
}
