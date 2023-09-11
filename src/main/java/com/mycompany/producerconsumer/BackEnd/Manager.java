package com.mycompany.producerconsumer.BackEnd;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager {
    
    private int SharedStore;
    private int max;
    private boolean empty, full;

    public Manager(){}
    
    public Manager(int size){
        this.SharedStore = 0; 
        this.max = size;
        this.empty = true;
        this.full = false;
    }
    
    public synchronized void produce(){
        while(this.full){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.print("\n" + SharedStore + " -> " + ++SharedStore);
        this.empty = false;
        if(SharedStore >= this.max){
            this.full = true;
        }
        notifyAll();
    }
    
    public synchronized void consume(){
        while(this.empty){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.print("\n" + SharedStore + " -> " + --SharedStore);
        this.full = false;
        if(SharedStore <= 0){
            this.empty = true;
            }
        notifyAll();
    }
    
    public void waitOnFull() throws InterruptedException, IllegalMonitorStateException {
        
    }
    
    /*
    
    public void addProducer(boolean state){
        if(state){
            numProducers++;
        }else{
            if(numProducers > 1){
                numProducers--;
            }else{
                System.out.print("\n Ya no se tienen productores");
            }
        }
    } 
    
    public void addConsumer(boolean state){
        if(state){
            numConsumers++;
        }else{
            if(numConsumers > 1){
                numConsumers--;
            }else{
                System.out.print("\n Ya no se tienen consumidores");
            }
        }
    }    
    
    public void init(){
        int cicle_max = Math.max(numProducers,numConsumers);
        int cicle_min = Math.min(numProducers,numConsumers);
        
        int i = 0;
        for(i = 0; i < cicle_min; i++){
            producer.start();
            consumer.start();
        }
        
        for(i = cicle_min; i < cicle_max; i++){
            if(numProducers >= cicle_max){
                producer.start();
            }
            else if(numConsumers >= cicle_max){
                consumer.start();
            }
            else{
                System.out.print(" \n Some shit is happen, HELP! ");
            }
        }
    }
    
    */
}