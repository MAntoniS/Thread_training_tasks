package producer_consumer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static producer_consumer.FinS.EOF;


public class TheConsumer implements Runnable {
    private List<String> buffer;
    private ReentrantLock bufferLock;
    private String color;

    public TheConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while (true){
        if (bufferLock.tryLock()) {
            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            } finally {
                bufferLock.unlock();
            }
        }
            }
        }
    }

