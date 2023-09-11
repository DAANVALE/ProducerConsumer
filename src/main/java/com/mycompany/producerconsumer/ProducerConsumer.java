package com.mycompany.producerconsumer;
import com.mycompany.producerconsumer.BackEnd.Manager;
import com.mycompany.producerconsumer.BackEnd.Producer;
import com.mycompany.producerconsumer.BackEnd.Consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {
    
    public static void main(String[] args){
        System.out.println("Hello World!");
        
        Manager manager = new Manager(20);
        
        Map<Integer, Producer> producers = new HashMap<>();
        Map<Integer, Consumer> consumers = new HashMap<>();
        
        
        for(int i = 0; i < 5; i++){
            Producer producer = new Producer(manager, i);
            Consumer consumer = new Consumer(manager, i);
        
            producers.put(i, producer);
            consumers.put(i, consumer);
            
            producers.get(i).start();
            consumers.get(i).start();
        }
    }
}
