package com.mycompany.producerconsumer.BackEnd;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread{

    private Manager manager;
    private int id;
    
    public Consumer(){}
    
    public Consumer(Manager manager){ 
        this.manager = manager;
    }
    
    public Consumer(Manager manager, int id){
        this.manager = manager;
        this.id = id;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                manager.consume();
                System.out.print("\n Consumer: " + id + " created something");
                sleep((int) (Math.random() * 4000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
