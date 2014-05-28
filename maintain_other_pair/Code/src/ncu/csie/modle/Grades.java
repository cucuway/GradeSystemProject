package ncu.csie.modle;

/**
 * ********************************************************************** class
 * Grades 儲存 ID, name, lab1, lab2, lab3, midTerm, finalExam, and totalGrade
 * 
 * calculateTotalGrade(weights) //依權重計算總成機 Grades () { } //建構子
 ************************************************************************/

public class Grades {
	String name, ID;
	int lab1, lab2, lab3, midTerm, finalExam, totalGrade;

	public Grades() {
	}

	public void calculateTotalGrade(float[] weights) {
		totalGrade = Math.round(lab1 * weights[0] + lab2 * weights[1] + lab3
				* weights[2] + midTerm * weights[3] + finalExam * weights[4]);
		// return totalGrade;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setlab1(int lab1) {
		this.lab1 = lab1;
	}

	public void setlab2(int lab2) {
		this.lab2 = lab2;
	}

	public void setlab3(int lab3) {
		this.lab3 = lab3;
	}

	public void setmidTerm(int midTerm) {
		this.midTerm = midTerm;
	}

	public void setfinalExam(int finalExam) {
		this.finalExam = finalExam;
	}

	public String getName() {
		return name;
	}

	public String getID() {
		return ID;
	}

	public int getlab1() {
		return lab1;
	}

	public int getlab2() {
		return lab2;
	}

	public int getlab3() {
		return lab3;
	}

	public int getmidTerm() {
		return midTerm;
	}

	public int getfinalExam() {
		return finalExam;
	}

	public int getTotalGrade() {
		return totalGrade;
	}
}
