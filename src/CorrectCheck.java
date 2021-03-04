import java.util.EmptyStackException;
import java.util.Stack;

public class CorrectCheck {

    public static void main(String[] args){
        String[][] Matrix = {
                { "Add a"},
                { "Add b"},
                { "Vote b"},
                { "Vote a"} };
        //System.out.println(CorrectChecker(4, Matrix));
        System.out.println(Mnogougolnic(21));

    }

    public static boolean CorrectChecker(int a, String[][] b){
        boolean work = true;
        int j = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < a; i++){
            if (b[i][0].contains("Add")){
                stack.push(b[i][0].charAt(4));
                j = i;
            }
            else if (b[i][0].contains("Vote") && b[j][0].charAt(5) == b[i][0].charAt(4)){
                int back = stack.search(b[i][0].charAt(4));
                  if (back == 0){
                      stack.pop();
                  }
            }
            try {
                stack.empty();
            } catch (EmptyStackException e){
                work = false;
            }
        }
        return work;
    }

    public static int Mnogougolnic(int a){
        for (int i = 2; i < a; i++){
            if (a%3 == 0){
                return 3;
            }
            else if (a%2 != 0 && i*i <= a){
                while (a%i != 0 && i*i<=a){
                    i+=2;
                }
                if (i*i <= a){
                    return i;
                }
                return a;
            }
            else if (a%2 == 0 && a%4 != 0){
                while (a%2 == 0 && i*i <=a){
                    i+=2;
                }
                if (i*i <= a){
                    return i;
                }
                return a/2;
            }
            else {
                return 4;
            }
        }
        return 0;
    }
}
