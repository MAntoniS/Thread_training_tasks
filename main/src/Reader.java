public class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (String latestMessage = message.read(); !latestMessage.equals("Finished");
        latestMessage = message.read()){
            System.out.println(latestMessage);
            try{Thread.sleep(4000);}
            catch(InterruptedException e){}
        }
    }
}
