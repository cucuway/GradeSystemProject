package gradeClass;

import exception.NoSuchCommandExceptions;
import exception.NoSuchIDExceptions;

/**
 * ################################################################## ��Grade
 * system ��ϥΪ�(�ǥ�)��o�L���`���Ztotal grade �αƦW rank. Total grade
 * ���t��weights �Ӻ� �� weights�i�Hupdate. Rank ��ܦ� total grade
 * �b���Z�ǥͪ����ƱƧ�
 * 
 * Input file: ���Z�ǥͪ����� �Ҧp 962001044 ��v�� 87 86 98 88 87 962001051 ���§�
 * 81 98 84 90 93 �`�N data field names �p�U: ID name lab1 lab2 lab3 midTerm
 * finalExam
 * ####################################################################
 */
public class Main extends Object {

	public static void main(String args[]) {

		try {
			new UI();
		}

		catch (NoSuchIDExceptions e1) {
			System.out.println("ID錯了!");
		} 
		catch (NoSuchCommandExceptions e2) {
			System.out.println("指令錯了!");
		}

	}
}