import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FestivalStatisticsThread extends Thread {

    FestivalGate gate;

    boolean stopped = false;

    public void end() {
        this.stopped = true;
    }

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;

    }

    public void run() {

        while (!stopped) {

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            generateStatistics();
        }
    }

    void generateStatistics() {
        LinkedList<TicketType> queue = gate.getQueue();

        HashMap<TicketType, Integer> m = new HashMap<>();
        m.put(TicketType.FULL, 0);
        m.put(TicketType.FULL_VIP, 0);
        m.put(TicketType.FREE_PASS, 0);
        m.put(TicketType.ONE_DAY, 0);
        m.put(TicketType.ONE_DAY_VIP, 0);


        for (TicketType t : queue) {
            m.replace(t, m.get(t) + 1);
        }

        if (queue.size() > 0) {
            System.out.println(queue.size() + " people entered");
            for (Map.Entry<TicketType, Integer> e : m.entrySet()) {
                System.out.println(e.getValue() + " have " + e.getKey() + " ticket");
            }
        }
    }
}
