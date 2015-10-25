package hometask1.week1.module3.tam;
import java.util.*;
import java.lang.System;

public class Calculator {
	public static void main (String [] args){
		
		try { // ���������� try/catch ��� ��������� �������, ����� ������������ ������ �������� ��������� ����
		Scanner in = new Scanner(System.in);// ������� ������ ������ Scaner ��� ���������� ������ �� �������
		System.out.println("������� ������ �����");
		double firstNum = in.nextInt(); //��������� �������� (� ������ ������ �����), ��������� ������������� � �������
		
		System.out.println("������� ������ �����");
		double secondNum = in.nextInt();//��������� �������� (� ������ ������ �����), ��������� ������������� � �������
		
		System.out.println("������� ��������(+, -, *, /)");
		Scanner oper = new Scanner (System.in);// ������� ������ ������ Scaner ��� ���������� ������ �� �������
		String operation = oper.nextLine();//��������� �������� (� ������ ������ - ���������), ��������� ������������� � �������
		
		switch (operation){// ���������� switch ��� ������ �� ����� ���������� �����������
		
		case "+":
			System.out.println("���������:" + (firstNum + secondNum));
			break;
		
		case "-":
			System.out.println("���������:" + (firstNum - secondNum));
			break;
			
		case "*":
			System.out.println("���������:" + (firstNum * secondNum));
			break;
			
		case "/":
			if (secondNum == 0){ // ������������ �������, ��� ������� ������������ �������� �������� �� 0
				System.out.println("������ ������ �� ����!");	//  ������� �� ����� ���������
				Calculator.main(args);//��������� ���������� ��������� ������
			}
			else{
			System.out.println("���������:" + (firstNum / secondNum));
			}
			break;
		
		default:
			System.out.println("�������� ��������, ������� +, -, * ��� /");	//���� ������������ ������ ���-��, ����� ���������� ��������, ������� ���������
			Calculator.main(args);//��������� ���������� ��������� ������				
		}
	}
		catch (InputMismatchException e)//���������� catch ��� ��������� �������, ����� ������������ ������ �������� � �������� ����� ������
		{
			System.out.println ("��� ������ ���� �����");
			Calculator.main(args);
		}
	}
	
	
	

	
	

}
