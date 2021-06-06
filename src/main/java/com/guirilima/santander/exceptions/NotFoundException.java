package com.guirilima.santander.exceptions;

import com.guirilima.santander.util.MessageUtils;
public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
