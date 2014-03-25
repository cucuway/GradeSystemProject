package gradeClass;

/**
 * ********************************************************************** class
 * Grades 儲存 ID, name, lab1, lab2, lab3, midTerm, finalExam, and totalGrade
 * 
 * calculateTotalGrade(weights) Grades () { } //建構子
 ************************************************************************/

public class Grades {
	public String name, ID;
	public int lab1, lab2, lab3, midTerm, finalExam, totalGrade;

	public Grades() {
	} // 建構子

	public int calculateTotalGrade(float[] weights) {
		
		// totalGrade須四捨五入
		int aTotalGrade = Math.round(lab1 * weights[0] + lab2 * weights[1] + lab3
				* weights[2] + midTerm * weights[3] + finalExam * weights[4]);
		return aTotalGrade;
	}
}
