import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ProblemB {

    public static boolean isNumeric(String strNum) {

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static void main(String[] args) {

        int caseNr = 1;

        Scanner scanner = new Scanner(System.in);

        Stack<String> stack = new Stack<>();

        StringTokenizer stringTokenizer;
        String separationDelim = " "; //StringTokenizer requires this to be a string instead of a char.
        ArrayList<String> tokens;

        //Main loop
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            System.out.println(input);
            stringTokenizer = new StringTokenizer(input, separationDelim);

            tokens = new ArrayList<>();
            stack.empty();

            while (stringTokenizer.hasMoreTokens()){
                tokens.add(stringTokenizer.nextToken());
            }

            String aString;
            String bString;

            for (int i = tokens.size() - 1; i >= 0; i--) {

                switch (tokens.get(i)){
                    case "+":
                        aString = stack.pop();
                        bString = stack.pop();

                        if (isNumeric(aString) && isNumeric(bString)){

                            int aInteger = Integer.getInteger(aString);
                            int bInteger = Integer.getInteger(bString);

                            int result = aInteger + bInteger;

                            stack.push("" + result);

                        }else{
                            stack.push(bString);
                            stack.push(aString);
                            stack.push(tokens.get(i));
                        }
                        break;

                    case "-":
                        aString = stack.pop();
                        bString = stack.pop();

                        if (isNumeric(aString) && isNumeric(bString)){

                            int aInteger = Integer.getInteger(aString);
                            int bInteger = Integer.getInteger(bString);

                            int result = aInteger - bInteger;

                            stack.push("" + result);

                        }else{
                            stack.push(bString);
                            stack.push(aString);
                            stack.push(tokens.get(i));
                        }
                        break;

                    case "*":
                        aString = stack.pop();
                        bString = stack.pop();

                        if (isNumeric(aString) && isNumeric(bString)){

                            int aInteger = Integer.getInteger(aString);
                            int bInteger = Integer.getInteger(bString);

                            int result = aInteger * bInteger;

                            stack.push("" + result);

                        }else{
                            stack.push(bString);
                            stack.push(aString);
                            stack.push(tokens.get(i));
                        }
                        break;

                    default:
                        stack.push(tokens.get(i));
                        break;

                }
            }

            StringBuilder outputString = new StringBuilder("Case " + caseNr);

            while(!stack.isEmpty()){
                outputString.append(" ").append(stack.pop());
            }
            System.out.println(outputString);

            caseNr++;
        }
    }
}
