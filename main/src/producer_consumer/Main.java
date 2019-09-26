package producer_consumer;

import thread_color.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        TheProducer producer = new TheProducer(buffer, Color.ANSI_CYAN,bufferLock);
        TheConsumer consumer= new TheConsumer(buffer,Color.ANSI_GREEN,bufferLock);
        TheConsumer consumer2 = new TheConsumer(buffer,Color.ANSI_PURPLE,bufferLock);
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer2).start();
    }
}
