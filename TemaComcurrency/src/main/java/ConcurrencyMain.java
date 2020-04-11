

public class ConcurrencyMain {

   public static void main (String... args) {

       FestivalGate gate = new FestivalGate();

       FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
       statisticsThread.start();

       for (int i =0; i < 100; i++) {
           FestivalAttendeeThread festivalAttendeeThread = new FestivalAttendeeThread(getRandomTicket(), gate);
           festivalAttendeeThread.start();
           try {
               Thread.sleep((int) (Math.random() * 3000));
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

       statisticsThread.end();
    }

    private static TicketType getRandomTicket(){
        int rand = (int)(Math.random()*5);

        switch (rand){
            case 0:
                return  TicketType.FREE_PASS;
            case 1:
                return  TicketType.FULL;
            case 2:
                return  TicketType.FULL_VIP;
            case 3:
                return  TicketType.ONE_DAY;
            case 4:
                return  TicketType.ONE_DAY_VIP;
        }

        return null;
    }

}

enum TicketType {FULL, FULL_VIP, FREE_PASS, ONE_DAY, ONE_DAY_VIP};


