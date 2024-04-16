package org.example.lab2.alternative;

import javax.enterprise.inject.Alternative;

@Alternative
public class LithuanianGreetingService implements GreetingService{
    @Override
    public String greet() {
        return "Labas!";
    }
}
