//Resources used:
//https://www.youtube.com/watch?v=2OroDG7P3F0&t=741s
//https://www.w3schools.com/dsa/dsa_data_stacks.php

import java.util.Stack;

//Number of opening brackets = number of closing brackets
//There cannot just be one, there needs to be a match
//Order of opening should be the same as closing

//Valid:
//[]
//[()()]

//Invalid:
//{[(])}

//If brackets match we return YES, if not we return NO

//Time complexity O(n)
//Space complexity O(n)
public class QuestionFour {

    public String isBalanced(String s) {
        Stack<Character> bracketStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            //Push all opening brackets on to the stack
            if (x == '(' || x == '[' || x == '{') {
                bracketStack.push(x);
                continue;
            }

            //If the stack is empty after trying to push opening brackets to the stack, it is invalid and returns no
            if (bracketStack.isEmpty())
                return "NO";

            //If x it doesn't match with the poppedelement,there is no match, and "NO" is returned.
            char poppedElement = bracketStack.pop();
            if (x == ']' && poppedElement != '[')
                return "NO";
            if (x == '}' && poppedElement != '{')
                return "NO";
            if (x == ')' && poppedElement != '(')
                return "NO";
        }

        //If the stack is empty at the end, we know each bracket had a match and it is valid. If not it is not valid.
        if (bracketStack.isEmpty())
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) {
        QuestionFour balancedbracket = new QuestionFour();
        String expr = "{()}[]}}}}";
        System.out.println(balancedbracket.isBalanced(expr));
    }
}

