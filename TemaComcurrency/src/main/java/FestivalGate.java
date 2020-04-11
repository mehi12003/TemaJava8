import java.util.LinkedList;

public class FestivalGate {

    LinkedList<TicketType> queue = new LinkedList<>();

    public synchronized void validateTicket(TicketType t) {
        queue.add(t);
    }

    public synchronized LinkedList<TicketType> getQueue() {
        LinkedList copyQueue = (LinkedList) queue.clone();
        queue.clear();
        return copyQueue;
    }
}
