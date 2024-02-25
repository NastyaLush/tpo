package org.example.task3;

import java.util.ArrayList;
import java.util.List;

public class Environment {
    private final List<AbstractObject> abstractObjects = new ArrayList<>();

    public void addObject(AbstractObject abstractObject){
        abstractObjects.add(abstractObject);
    }
    public void deleteObject(AbstractObject abstractObject){
        abstractObjects.remove(abstractObject);
    }
    public boolean contains(AbstractObject abstractObject){
        return abstractObjects.contains(abstractObject);
    }
}
