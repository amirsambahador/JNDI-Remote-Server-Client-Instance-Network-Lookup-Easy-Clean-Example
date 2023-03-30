package org.j2os.model;

import javax.naming.Reference;
import java.io.Serializable;

/*
    Bahador, Amirsam
 */
public class Car extends Reference implements Serializable {
    public Car(String className) {
        super(className);
    }

    public void start() {
        System.out.println("start car...");
    }

}