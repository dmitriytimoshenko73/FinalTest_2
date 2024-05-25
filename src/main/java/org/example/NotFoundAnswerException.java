package org.example;

public class NotFoundAnswerException extends Exception{

    public NotFoundAnswerException(String text) {
        super(text);
    }
}
