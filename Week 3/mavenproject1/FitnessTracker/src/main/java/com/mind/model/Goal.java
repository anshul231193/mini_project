/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.model;

import javax.enterprise.inject.Model;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author anshul
 */
public class Goal {
    
    @Range(min=1, max=120)
    private int minutes;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
