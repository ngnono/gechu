package com.ngnono.gechu.core.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ngnono on 14-2-8.
 */
@XmlRootElement(name = "hello")
public class Hello {
    public String getMessage() {
        return message;
    }

    @XmlElement
    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
