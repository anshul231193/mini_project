/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.controller;

import com.mind.model.Goal;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author anshul
 */
@Controller
@SessionAttributes("goal")
public class GoalController {
    
    @RequestMapping(value = "addGoal", method=RequestMethod.GET)
    public String addGoalMinutes(Model model) {
        Goal gl = new Goal();
        gl.setMinutes(30);
        model.addAttribute("goal",gl);
        return "addGoal";
    }
    
    @RequestMapping(value="addGoal",method = RequestMethod.POST)
    public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, 
                                                    BindingResult result) {
        System.out.println("Errors: "+result.hasErrors());
        System.out.println(goal.getMinutes());
        if(result.hasErrors()) {
            return "addGoal";
        }
        return "redirect:addMinutes.html";
    }
}
