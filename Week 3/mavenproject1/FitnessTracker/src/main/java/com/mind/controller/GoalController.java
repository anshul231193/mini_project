/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.controller;

import com.mind.model.Goal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author anshul
 */
@Controller
public class GoalController {
    
    @RequestMapping(value = "addGoal", method=RequestMethod.GET)
    public String addGoalMinutes(@ModelAttribute("goal") Goal goal) {
        System.out.println(goal.getMinutes());
        return "addGoal";
    }
}
