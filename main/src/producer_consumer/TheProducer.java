package producer_consumer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


public class TheProducer implements Runnable {
    private List<String> buffer;
    private ReentrantLock bufferLock;
    private String color;

    public TheProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        String[] nums = {"1","2","3","4","5"};
        for (String num : nums) {
            try {
                System.out.println(color + "Adding. . ." + num);
                synchronized (buffer){
                    bufferLock.lock();
                   try {
                       buffer.add(num);
                   }finally {
                       bufferLock.unlock();
                   }
                }
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");
        synchronized (buffer){
            bufferLock.lock();
           try {
               buffer.add("EOF");
           } finally
           {
               bufferLock.unlock();
           }
        }
    }
}

