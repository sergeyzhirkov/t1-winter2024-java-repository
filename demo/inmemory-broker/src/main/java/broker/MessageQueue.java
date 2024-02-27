package broker;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public void publish(String message){
        queue.offer(message);
    }

    public String poll(){
        return queue.poll();
    }
}
