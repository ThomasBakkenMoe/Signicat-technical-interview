import java.util.Scanner;

public class ProblemC {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numbOfKittens = scanner.nextInt();
        int numbOfBeds = scanner.nextInt();

        System.out.println("Kittens: " + numbOfKittens);
        System.out.println("Beds: " + numbOfBeds);

        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }


    }
}
