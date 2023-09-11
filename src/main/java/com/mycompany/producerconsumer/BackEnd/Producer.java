package com.mycompany.producerconsumer.BackEnd;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread{
    
    private Manager manager;
    private int id;
    
    public Producer(){}
    
    public Producer(Manager manager){ 
        this.manager = manager;
    }
    
    public Producer(Manager manager, int id){ 
        this.manager = manager;
        this.id = id;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                manager.produce();
                System.out.print("\n \t Producer: " + id + " created something");
                sleep((int) (Math.random() * 4000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
