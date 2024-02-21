package broker;

public class Publisher {
    private final MessageQueue queue;

    public Publisher(MessageQueue messageQueue) {
        this.queue = messageQueue;
    }

    public void publishMessage(String message) {
        queue.publish(message);
    }
}
