/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.util;

import com.MusicApp.model.Music;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import static sun.rmi.transport.TransportConstants.Magic;

/**
 *
 * @author anshul
 */
@Component
public class FileValidator implements Validator{
    
    public boolean supports(Class<?> clazz) {
        return Music.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object obj, Errors errors) {
        Music file = (Music) obj;
        if(file.getFile()!=null){
            if (file.getFile().getSize() == 0) {
                errors.rejectValue("file", "missing.file");
            }
        }
        if(!"audio/mpeg".equals(file.getFile().getContentType())) {
            errors.rejectValue("file", "file.extension");
        }
    }
    
}
