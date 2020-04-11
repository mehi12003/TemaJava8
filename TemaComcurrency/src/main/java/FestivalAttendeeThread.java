public class FestivalAttendeeThread extends Thread {

    TicketType ticketType;
    FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    public void  run() {
        gate.validateTicket(ticketType);
    }
}
