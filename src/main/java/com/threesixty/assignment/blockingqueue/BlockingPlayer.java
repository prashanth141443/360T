package com.threesixty.assignment.blockingqueue;

import java.util.concurrent.BlockingQueue;

import javax.naming.CommunicationException;

public class BlockingPlayer implements Runnable {
     private BlockingPlayer() {}
     private BlockingQueue<String> producerQueue;
     private BlockingQueue<String> consumerQueue;
     private Boolean isInitator;
     private int counter;

     public BlockingPlayer(BlockingQueue<String> producerQueue,BlockingQueue<String> consumerQueue, Boolean isInitator,int counter) {
         this.producerQueue = producerQueue;
         this.consumerQueue = consumerQueue;
         this.isInitator = isInitator;
         this.counter = counter;
     }

     @Override
     public void run() {
         if(isInitator) {
             try {
                 produceMessages();
             } catch (CommunicationException e) {
            	 e.printStackTrace();
             }
         }else {
             try {
                 consumerMessages();
             } catch (CommunicationException e) { 
            	 e.printStackTrace();
             }
         }
     }

     private void produceMessages() throws CommunicationException {
    	 try {
    		 for(int i = 1; i <= counter; i++) {
    			 producerQueue.put(""+i);
    			 System.out.println("Produced Message for Counter:"+i);
    		 }
    		 producerQueue.put("END");
    		 int ackCounter = 1;
    		 while(ackCounter <= counter) {
    			 System.out.println("Acknowledgement Received from Consumer:"+consumerQueue.take());
    		 }
    		 
    	 }catch(InterruptedException e) {
    		 throw new CommunicationException(e.getLocalizedMessage());
    	 }
     }
     
     private void consumerMessages() throws CommunicationException {
    	 try {
    		 String ackMessage = producerQueue.take();
    		 do {
    			 System.out.println("Received Message for Counter "+ackMessage);
    			 consumerQueue.put("Received Message for Counter "+ackMessage);
    			 
    		 }while(!((ackMessage = producerQueue.take()).equals("END")));
    		 
    	 }catch(InterruptedException e) {
    		 throw new CommunicationException(e.getLocalizedMessage());
    	 }
     }
     
}