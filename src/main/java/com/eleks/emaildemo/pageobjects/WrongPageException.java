package com.eleks.emaildemo.pageobjects;

/**
 * Created by Andriy on 30.01.2017.
 */
public class WrongPageException extends RuntimeException {

    public WrongPageException(String message){

        super(message);
    }
}
