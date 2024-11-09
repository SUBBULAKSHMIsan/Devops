package com.example;

import java.util.Scanner;
import java.util.Stack;

public class ExpressionEvaluator {

    // Method to evaluate postfix expressions
    public int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        // Traverse each character in the expression
        for (char ch : expression.toCharArray()) {
            // If character is a number, push it to the stack
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert char to int
            } 
            // If character is an operator, pop two elements from the stack and apply the operation
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        // The final result will be the only element left in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        // Create an instance of the evaluator
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a postfix expression
        System.out.print("Enter a postfix expression to evaluate: ");
        String expression = scanner.nextLine();

        // Evaluate the expression and display the result
        try {
            int result = evaluator.evaluatePostfix(expression);
            System.out.println("The result of the expression is: " + result);
        } catch (Exception e) {
            System.out.println("Invalid expression! Please check your input and try again.");
        }

        // Close the scanner
        scanner.close();
    }
}
