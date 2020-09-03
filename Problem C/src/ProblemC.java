import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class ProblemC {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numbOfKittens = scanner.nextInt();
        int numbOfBeds = scanner.nextInt();


        //System.out.println("Kittens: " + numbOfKittens);
        //System.out.println("Beds: " + numbOfBeds);

        ArrayList<Request> requests = new ArrayList<>();

        while (scanner.hasNext()){
            int tempFrom = scanner.nextInt();
            int tempTo = scanner.nextInt();
            requests.add(new Request(tempFrom, tempTo));
        }

        scanner.close();

        int lastStayDay = 0;
        int currentOccupancy = 0;
        int totalKittenOccupancy = 0;

        for (Request request: requests) {

            if (request.to > lastStayDay){
                lastStayDay = request.to;
            }
        }

        for (int currentDay = 0; currentDay <= lastStayDay; currentDay++) {
            ListIterator<Request> iterator = requests.listIterator();

            while (iterator.hasNext()) {
                Request currentRequest = iterator.next();
                if (currentRequest.isAccepted() && currentRequest.to == currentDay){
                    currentOccupancy--;
                }

                if (currentRequest.isNew() && (currentOccupancy < numbOfBeds) && (currentRequest.from == currentDay)){
                    currentRequest.setNew(false);
                    currentRequest.setAccepted(true);
                    currentOccupancy++;
                    totalKittenOccupancy++;
                }
                if (currentRequest.from < currentDay && !currentRequest.isAccepted()){
                    iterator.remove();
                }
            }

            //System.out.println("Current day: " + currentDay + ". Occupancy: " + currentOccupancy);
        }

        System.out.println(totalKittenOccupancy);
    }

    /**
     * Class for storing incoming requests
     */
    private static class Request{

        private int from;
        private int to;
        private boolean accepted = false;
        private boolean isNew = true;

        Request(int from, int to){
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public boolean isAccepted() {
            return accepted;
        }

        public void setAccepted(boolean accepted) {
            this.accepted = accepted;
        }

        public boolean isNew() {
            return isNew;
        }

        public void setNew(boolean aNew) {
            isNew = aNew;
        }
    }
}
