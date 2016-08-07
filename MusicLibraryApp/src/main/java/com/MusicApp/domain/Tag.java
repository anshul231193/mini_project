/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.domain;

/**
 *
 * Class to produce json format of search using keywords
 */
public class Tag {
        public String value;
	public int data;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

	//getter and setter methods

	public Tag(int data, String value) {
		this.data = data;
		this.value = value;
	}

}
