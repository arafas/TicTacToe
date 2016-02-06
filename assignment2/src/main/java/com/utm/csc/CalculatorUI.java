package com.utm.csc;


import javax.swing.JOptionPane;
public class CalculatorUI {
	
	
	
    public static void main(String[] args) {

        String input1, input2, input3;
        double num1, num2, answer;

        answer = 0;
        input1 = JOptionPane.showInputDialog(null, "Enter the first " +
                "number: ", "Input 1", JOptionPane.QUESTION_MESSAGE);
        num1 = Double.parseDouble(input1);
        input2 = JOptionPane.showInputDialog(null, "Enter the second " +
                "number: ", "Input 2", JOptionPane.QUESTION_MESSAGE);
        num2 = Double.parseDouble(input2);
                input3 = JOptionPane.showInputDialog(null, "Enter the operator" +
                "(+, -, /, *, %, ^, `, cosd, sind, tand, sinr, cosr, tanr): ", "Sign",
                JOptionPane.QUESTION_MESSAGE);

        if (input3.equals("+"))
        {
            answer = Calculator.addition(num1,num2);
            JOptionPane.showMessageDialog(null, "The answer is : " + answer,
                    "Addition", JOptionPane.INFORMATION_MESSAGE);
        }

        if (input3.equals("-"))
        {
            answer = Calculator.subtraction(num1,num2);
            JOptionPane.showMessageDialog(null, "The answer is : " + answer,
                    "Subtraction", JOptionPane.INFORMATION_MESSAGE);
        }

        if (input3.equals("/"))
        {
            answer = Calculator.division(num1,num2);
            JOptionPane.showMessageDialog(null, "The answer is : " + answer,
                    "Division", JOptionPane.INFORMATION_MESSAGE);
        }

        if (input3.equals("*"))
        {
            answer = Calculator.multiplication(num1, num2);
            JOptionPane.showMessageDialog(null, "The answer is : " + answer,
                    "Multiplication", JOptionPane.INFORMATION_MESSAGE);
        }

        if (input3.equals("%"))
        {
            answer = Calculator.modular(num1,num2);
            JOptionPane.showMessageDialog(null, "The answer is : " + answer,
                    "Modular", JOptionPane.INFORMATION_MESSAGE);
        }

        if (input3.equals("^"))
        {
            answer = Calculator.exponent(num1,num2);
            JOptionPane.showMessageDialog(null, "The answer is : " + answer,
                    "Exponent", JOptionPane.INFORMATION_MESSAGE);
        }

        if (input3.equals("`"))
        {

            answer = Calculator.tetration(num1,num2);
            JOptionPane.showMessageDialog(null, "The answer is : " + answer,
                    "Tetration", JOptionPane.INFORMATION_MESSAGE);
        }

        if (input3.equals("sind"))
        {
            answer = Calculator.sind(num1,num2);
            JOptionPane.showMessageDialog(null, "The answer is : " + answer,
                    "Sine in Degrees", JOptionPane.INFORMATION_MESSAGE);
        }

        if (input3.equals("cosd"))
        {
            answer = Calculator.cosd(num1,num2);
            JOptionPane.showMessageDialog(null, "The answer is : " + answer,
                    "Cosine in Degrees", JOptionPane.INFORMATION_MESSAGE);
        }

        if (input3.equals("tand"))
        {
            answer = Calculator.tand(num1,num2);
            JOptionPane.showMessageDialog(null, "The answer is : " + answer,
                    "Tangent in Degrees", JOptionPane.INFORMATION_MESSAGE);
        }

        if (input3.equals("sinr"))
        {	
            answer = Calculator.sinr(num1,num2);
            JOptionPane.showMessageDialog(null, "The answer is : " + answer,
                    "Sine in Radians", JOptionPane.INFORMATION_MESSAGE);
        }

        if (input3.equals("cosr"))
        {
            answer = Calculator.cosr(num1,num2);
            JOptionPane.showMessageDialog(null, "The answer is : " + answer,
                    "Cosine in Radians", JOptionPane.INFORMATION_MESSAGE);
        }

        if (input3.equals("tanr"))
        {
            answer = Calculator.tanr(num1,num2);
            JOptionPane.showMessageDialog(null, "The answer is : " + answer,
                    "Tangent in Radians", JOptionPane.INFORMATION_MESSAGE);
        }
        System.exit(0);
    }

}
