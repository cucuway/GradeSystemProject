package gradeClass;

/**
 * Grades stores attribute ID, name, lab1, lab2, lab3, midTerm, finalExam, and
 * totalGrade. Apply method [int] calculateTotalGrade(float[] weights)
 * 
 * @author Yang
 * 
 */
public class Grades {
	/**
	 * @uml.property name="name"
	 */
	public String name;
	/**
	 * @uml.property name="iD"
	 */
	public String ID;
	/**
	 * @uml.property name="lab1"
	 */
	public int lab1;
	/**
	 * @uml.property name="lab2"
	 */
	public int lab2;
	/**
	 * @uml.property name="lab3"
	 */
	public int lab3;
	/**
	 * @uml.property name="midTerm"
	 */
	public int midTerm;
	/**
	 * @uml.property name="finalExam"
	 */
	public int finalExam;
	/**
	 * @uml.property name="totalGrade"
	 */
	public int totalGrade;

	/**
	 * do nothing.
	 */
	public Grades() {
	}

	/**
	 * Calculate total grade with weighted average.
	 * 
	 * @param weights
	 * @return round off weighted-average.
	 */
	public int calculateTotalGrade(float[] weights) {
		//用Math.round() 可四捨五入
		int aTotalGrade = Math.round(lab1 * weights[0] + lab2 * weights[1]
				+ lab3 * weights[2] + midTerm * weights[3] + finalExam
				* weights[4]);
		return aTotalGrade;
	}
}
