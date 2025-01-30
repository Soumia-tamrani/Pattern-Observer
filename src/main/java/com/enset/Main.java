package com.enset;

import obs.ObservableImpl;
import obs.Observer;
import obs.ObserverImpl1;
import obs.ObserverImpl2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();
        Observer o1 = new ObserverImpl1();
        Observer o2 = new ObserverImpl2();
        observable.subscribe(o1);
        observable.subscribe(o2);

        observable.subscribe(observable1 -> {
            if(observable1 instanceof ObservableImpl o){
                System.out.println("*************************");
                System.out.println("Resultat = "+o.getState() * Math.cos(o.getState()));
                System.out.println("*************************");

            }

        });

        observable.setState(80);
        observable.setState(90);
        observable.unsubscribe(o2);
        observable.setState(100);

        Button button = new Button();
        button.addActionListener(e -> {
            System.out.println(e.getSource());

        });

    }

}