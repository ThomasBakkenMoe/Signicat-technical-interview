import java.util.Scanner;

public class ProblemA {

    private static String translate(String input){
        
        StringBuilder output = new StringBuilder();

        for (char ch: input.toLowerCase().toCharArray()) {
            switch (ch){
                case 'a':
                    output.append('@');
                    break;
                case 'b':
                    output.append('8');
                    break;
                case 'c':
                    output.append('(');
                    break;
                case 'd':
                    output.append("|)");
                    break;
                case 'e':
                    output.append('3');
                    break;
                case 'f':
                    output.append('#');
                    break;
                case 'g':
                    output.append('6');
                    break;
                case 'h':
                    output.append("[-]");
                    break;
                case 'i':
                    output.append('|');
                    break;
                case 'j':
                    output.append("_|");
                    break;
                case 'k':
                    output.append("|<");
                    break;
                case 'l':
                    output.append('1');
                    break;
                case 'm':
                    output.append("[]\\/[]");
                    break;
                case 'n':
                    output.append("[]\\[]");
                    break;
                case 'o':
                    output.append('0');
                    break;
                case 'p':
                    output.append("|D");
                    break;
                case 'q':
                    output.append("(,)");
                    break;
                case 'r':
                    output.append("|Z");
                    break;
                case 's':
                    output.append('$');
                    break;
                case 't':
                    output.append("']['");
                    break;
                case 'u':
                    output.append("|_|");
                    break;
                case 'v':
                    output.append("\\/");
                    break;
                case 'w':
                    output.append("\\/\\/");
                    break;
                case 'x':
                    output.append("}{");
                    break;
                case 'y':
                    output.append("`/");
                    break;
                case 'z':
                    output.append('2');
                    break;

                default:
                    output.append(ch);
                    break;
            }
        }

        


        return output.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(translate(input));
    }
}
