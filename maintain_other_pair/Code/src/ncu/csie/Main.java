package ncu.csie;

import ncu.csie.exceptions.NoSuchCommandExceptions;
import ncu.csie.exceptions.NoSuchIDExceptions;

public class Main extends Object {
	/**
	 * ################################################################## ��Grade
	 * system ���ϥΪ�(�ǥ�)���o�L���`���Ztotal grade �αƦW rank. Total grade ���t��weights �Ӻ� ��
	 * weights�i�Hupdate. Rank ��ܦ� total grade �b���Z�ǥͪ����ƱƧ�
	 * 
	 * Input file: ���Z�ǥͪ����� �Ҧp 962001044 ��v�� 87 86 98 88 87 962001051 ���§� 81 98
	 * 84 90 93 �`�N data field names �p�U: ID name lab1 lab2 lab3 midTerm finalExam
	 * ####################################################################
	 */

	public static void main(String args[]) {
		UI myUI;
		try {
			myUI = new UI();
		} catch (NoSuchIDExceptions e1) {
		} catch (NoSuchCommandExceptions e2) {
		}
		myUI=null;
	}

}
