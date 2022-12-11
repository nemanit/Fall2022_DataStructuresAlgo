package Question3.src;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        String givenString = "a)b(c)d";
        String result = minRemoveToMakeValid(givenString);

        System.out.println("The given string is " + givenString + " the string after removing unnecessary braces is " + result);
    }

    // Time complexity is going to be O(n) where n is the number of characters in words as we traverse through them twice
    // Space complexity is O(n) as we are creating a parenthesisIndexStack and badIndexesList
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> parenthesisIndexStack = new Stack<>();
        ArrayList<Integer> badIndexesList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            // if the character is opening braces, we add the index to the list
            if(s.charAt(i) == '(') {
                parenthesisIndexStack.push(i);
            } else if (s.charAt(i) == ')') {
                // if the character is closing braces, we try to remove the last element if the stack is empty,
                // we add the index to the bad index as the closing brace should not have been there in first place
                if (parenthesisIndexStack.empty()) {
                    badIndexesList.add(i);
                } else {
                    parenthesisIndexStack.pop();
                }
            }
        }

        // even after traversing through all the characters in the list if the stack is having any elements in it,
        // it means that those braces neeed to be removed.
        while(!parenthesisIndexStack.empty()) {
            badIndexesList.add(parenthesisIndexStack.pop());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(badIndexesList.contains(i)) {
                continue;
            }
            else {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}

