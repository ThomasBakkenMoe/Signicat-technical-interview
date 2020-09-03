import java.util.ArrayList;
import java.util.Scanner;

public class ProblemC {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numbOfKittens = scanner.nextInt();
        int numbOfBeds = scanner.nextInt();
        int maxKittenOccupancy = 0;

        System.out.println("Kittens: " + numbOfKittens);
        System.out.println("Beds: " + numbOfBeds);

        ArrayList<Request> requests = new ArrayList<>();

        int tempFrom;
        int tempTo;

        while (scanner.hasNext()){
            tempFrom = scanner.nextInt();
            tempTo = scanner.nextInt();
            requests.add(new Request(tempFrom, tempTo));
        }

        int lastStayDay = 0;

        for (Request request: requests) {

            if (request.to > lastStayDay){
                lastStayDay = request.to;
            }
        }

        int[] occupancy = new int[lastStayDay + 1];

        boolean bookingAvailable = true;
        for (Request request: requests) {

            for (int i = request.from; i <= request.to; i++) {
                if (occupancy[i] >= numbOfBeds){
                    bookingAvailable = false;
                    break;
                }

            }
            if (bookingAvailable){
                for (int i = request.from; i <= request.to; i++) {
                    occupancy[i] += 1;
                }

                maxKittenOccupancy++;

            }

            bookingAvailable = true;

        }

        System.out.println(maxKittenOccupancy);
    }

    /**
     * Class for storing incoming requests
     */
    private static class Request{

        private int from;
        private int to;

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
    }
}
