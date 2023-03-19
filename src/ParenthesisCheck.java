import java.util.Stack;

public class ParenthesisCheck {
    public static void main(String[] args) {

        final String inputString = "[{()}]"; //"[{()}], [}, [[, []{}("
        final String inputString1 = "[}"; //"[}", [[", []{}("
        final String inputString3 = "[["; //"[}", [[", []{}("
        final String inputString4 = "[]{}()"; //"[}", [[", []{}("

        if (parenthesisChecker(inputString4)) {
            System.out.println("Balanced..");
        } else {
            System.out.println("Not Balanced..");
        }
    }

    private static boolean parenthesisChecker(String inputString) {
        final Stack<Character> stack = new Stack<>();
        final char[] charArray = inputString.toCharArray();//"[{()}], [}, [[, []{}("

        for (char ch : charArray) {
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            }

            if (ch == ']' || ch == ')' || ch == '}') {
                final Character poppedChar = stack.pop();
                if (!charCheck(poppedChar, ch)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    private static boolean charCheck(char poppedChar, Character ch) {
        return (poppedChar == '[' && ch == ']') || (poppedChar == '(' && ch == ')') || (poppedChar == '{' && ch == '}');
    }
}
