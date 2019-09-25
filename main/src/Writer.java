import static ThreadColor.Color.*;

public class Writer implements Runnable {

    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String [] messages = {
                ANSI_GREEN + "Roses are red",
                ANSI_BLUE + "Cabbage is best",
                ANSI_PUTPLE + "Furthermore Cartago",
                ANSI_CYAN + "Delenda est "
        };
        for (int i = 0; i < messages.length; i ++){
            message.write(messages[i]);
            try{
                Thread.sleep(6000);
            }catch (InterruptedException e ){ }
        }
        message.write("Finished");
    }
}
