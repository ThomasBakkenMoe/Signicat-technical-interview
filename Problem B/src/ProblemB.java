import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class ProblemB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();

        StringTokenizer stringTokenizer;
        String separationChar = " "; //StringTokenizer requires this to be a string instead of a char.
        ArrayList<String> tokens;

        //Main loop
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            stringTokenizer = new StringTokenizer(input, separationChar);

            tokens = new ArrayList<>();

            while (stringTokenizer.hasMoreTokens()){
                tokens.add(stringTokenizer.nextToken());
            }

            for (int i = tokens.size() - 1; i >= 0; i--) {
                System.out.println(tokens.get(i));
            }
        }
    }
}
