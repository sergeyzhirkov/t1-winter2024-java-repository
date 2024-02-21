package broker;

public class Subscriber {
    private final MessageQueue queue;

    public Subscriber(MessageQueue queue) {
        this.queue = queue;
    }

    @annotation.Subscriber
    public String getMessage() {
        return queue.poll();
    }
}
