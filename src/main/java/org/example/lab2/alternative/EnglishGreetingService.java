package org.example.lab2.alternative;

import javax.enterprise.inject.Default;

@Default
public class EnglishGreetingService implements GreetingService{
    @Override
    public String greet() {
        return "Hello!";
    }
}
