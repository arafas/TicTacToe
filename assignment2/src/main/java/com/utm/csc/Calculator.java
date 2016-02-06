package com.utm.csc;

public class Calculator {
	
		public static double addition(double a, double b){
			
			double answer = a + b;
			return answer;
			
		}
		
		
		public static double subtraction(double a, double b){
			
			double answer = a - b;
			return answer;
			
		}
		
		
		public static double division(double a, double b){
			
			double answer = a / b;
			return answer;
			
		}
		
		public static double multiplication(double a, double b){
			
			double answer = a * b;
			return answer;
			
		}	
		
		public static double modular(double a, double b){
			
			double answer = a % b;
			return answer;
			
		}
		
		public static double exponent(double a, double b){
			
			double answer = Math.pow(a, b);
			return answer;
			
		}
		
		public static double tetration(double a, double b){
			
            double x = a;
            double answer;
            while (b != 1)
            {
                x = Math.pow(a, x);
                b--;
            }
            answer = x;
			
			return answer;
		}
		
		
		public static double sind(double a, double b){
			
			double answer =  a * Math.sin((Math.PI/180)*b);
			return answer;
			
		}
		
		public static double cosd(double a, double b){
			
			double answer =  a * Math.cos((Math.PI/180)*b);
			return answer;
			
		}
		
		public static double tand(double a, double b){
			
			double answer =  a * Math.tan((Math.PI/180)*b);
			return answer;
			
		}
		
		public static double sinr(double a, double b){
			
			double answer = a * Math.sin(b);
			return answer;
			
		}
		
		public static double cosr(double a, double b){
			
			double answer = a * Math.cos(b);
			return answer;
			
		}
		
		
		public static double tanr(double a, double b){
			
			double answer = a * Math.tan(b);
			return answer;
			
		}
		
}
