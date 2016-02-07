package com.utm.csc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {


	private double posDoubleNum, posDoubleNum2, negDouble, zeroDouble;
	
	
	@Before
	public void setUp(){
		posDoubleNum = 1.0;
		posDoubleNum2 = 5.0;
		negDouble = -5.0;
		zeroDouble = 0.0;
	}
	
	@Test
	public void testsAdditionPositive(){
		
		System.out.println("Test Addition Positive:");
		double sumResult = Calculator.addition(posDoubleNum, posDoubleNum2);
		double sumExpected = 6.0;
		System.out.println("expected = " + sumExpected + " and actual = " + sumResult);
		assertTrue(sumExpected == sumResult);
		
	}
	
	
	@Test
	public void testsAdditionNegative(){

		
		System.out.println("Test Addition Negative:");
		double sumResult = Calculator.addition(posDoubleNum, negDouble);
		double sumExpected = -4.0;
		System.out.println("expected = " + sumExpected + " and actual = " + sumResult);
		assertTrue(sumExpected == sumResult);
		
	}
	
	
	@Test
	public void testsSubtractionPositive(){
		
		System.out.println("Test Subtraction Positive:");
		double differenceResult = Calculator.subtraction(posDoubleNum2, posDoubleNum);
		double differenceExpected = 4.0;
		System.out.println("expected = " + differenceExpected + " and actual = " + differenceResult);
		assertTrue(differenceExpected == differenceResult);
		
	}
	
	@Test
	public void testsSubtractionNegative(){
		
		
		System.out.println("Test Subtraction Negative:");
		double differenceResult = Calculator.subtraction(posDoubleNum, negDouble);
		double differenceExpected = 6.0;
		System.out.println("expected = " + differenceExpected + " and actual = " + differenceResult);
		assertTrue(differenceExpected == differenceResult);
		
	}
	
	@Test
	public void testsMultiplicationPositive(){
		
		//typical case
		System.out.println("Test Multiplication Positive:");
		double productResult = Calculator.multiplication(posDoubleNum, posDoubleNum2);
		double productExpected = 5.0;
		System.out.println("expected = " + productExpected + " and actual = " + productResult);
		assertTrue(productExpected == productResult);
		
		
		System.out.println("Test Multiplication Positive:");
		//multiplication by zero
		productResult = Calculator.multiplication(posDoubleNum2, zeroDouble);
		productExpected = 0.0;
		System.out.println("expected = " + productExpected + " and actual = " + productResult);
		assertTrue(productExpected == productResult);
		
		
		
	}
	
	@Test
	public void testsMultiplicationNegative(){
		
		System.out.println("Test Multiplication Negative:");
		//negative numbers both
		double productResult = Calculator.multiplication(negDouble, negDouble);
		double productExpected = 25.0;
		System.out.println("expected = " + productExpected + " and actual = " + productResult);
		assertTrue(productExpected == productResult);
				
		
		System.out.println("Test Multiplication Negative:");
		//one negative number
		productResult = Calculator.multiplication(negDouble, posDoubleNum2);
		productExpected = -25.0;
		System.out.println("expected = " + productExpected + " and actual = " + productResult);
		assertTrue(productExpected == productResult);
		
	}
	
	@Test
	public void testsDivisionPositive(){
		
		System.out.println("Test Division Positive:");
		//typical case
		double quotientResult = Calculator.division(posDoubleNum, posDoubleNum2);
		double quotientExpected = 0.2;
		System.out.println("expected = " + quotientExpected + " and actual = " + quotientResult);
		assertTrue(quotientExpected == quotientResult);
		
		System.out.println("Test Division Positive:");
		//division by zero
		quotientResult = Calculator.division(zeroDouble, posDoubleNum);
		quotientExpected = 0.0;
		System.out.println("expected = " + quotientExpected + " and actual = " + quotientResult);
		assertTrue(quotientExpected == quotientResult);
	}
	
	
	@Test
	public void testsDivisionNegative(){
		
		System.out.println("Test Division Negative:");
		//negative numbers both
		double quotientResult = Calculator.division(negDouble, negDouble);
		double quotientExpected = 1.0;
		System.out.println("expected = " + quotientExpected + " and actual = " + quotientResult);
		assertTrue(quotientExpected == quotientResult);
		
		System.out.println("Test Division Negative:");
		//one negative number
		quotientResult = Calculator.division(negDouble, posDoubleNum2);
		quotientExpected = -1.0;
		System.out.println("expected = " + quotientExpected + " and actual = " + quotientResult);
		assertTrue(quotientExpected == quotientResult);
		
		
	}
	

}
