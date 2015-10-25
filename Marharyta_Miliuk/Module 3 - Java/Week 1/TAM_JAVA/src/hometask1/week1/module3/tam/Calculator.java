package hometask1.week1.module3.tam;
import java.util.*;
import java.lang.System;

public class Calculator {
	public static void main (String [] args){
		
		try { // используем try/catch для обработки случаев, когда пользователь вводит значение неверного типа
		Scanner in = new Scanner(System.in);// создаем объект класса Scaner для считывания данных из консоли
		System.out.println("Введите первое число");
		double firstNum = in.nextInt(); //считываем значение (в данном случае число), введенное пользователем в консоли
		
		System.out.println("Введите второе число");
		double secondNum = in.nextInt();//считываем значение (в данном случае число), введенное пользователем в консоли
		
		System.out.println("Введите операцию(+, -, *, /)");
		Scanner oper = new Scanner (System.in);// создаем объект класса Scaner для считывания данных из консоли
		String operation = oper.nextLine();//считываем значение (а данном случае - строковое), введенное пользователем в консоли
		
		switch (operation){// используем switch для работы со всеми возможными операторами
		
		case "+":
			System.out.println("Результат:" + (firstNum + secondNum));
			break;
		
		case "-":
			System.out.println("Результат:" + (firstNum - secondNum));
			break;
			
		case "*":
			System.out.println("Результат:" + (firstNum * secondNum));
			break;
			
		case "/":
			if (secondNum == 0){ // обрабатываем условие, при котором пользователь пытается поделить на 0
				System.out.println("Нельзя делить на ноль!");	//  выводим на экран сообщение
				Calculator.main(args);//запускаем выполнение программы заново
			}
			else{
			System.out.println("Результат:" + (firstNum / secondNum));
			}
			break;
		
		default:
			System.out.println("Неверная операция, введите +, -, * или /");	//если пользователь вводит что-то, кроме допустимых символов, выводим сообщение
			Calculator.main(args);//запускаем выполнение программы заново				
		}
	}
		catch (InputMismatchException e)//используем catch для обработки случаев, когда пользователь вводит значение с неверным типом данных
		{
			System.out.println ("Это должна быть цифра");
			Calculator.main(args);
		}
	}
	
	
	

	
	

}
