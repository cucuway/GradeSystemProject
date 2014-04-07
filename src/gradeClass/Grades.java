package gradeClass;

/**
 * ********************************************************************** class
 * Grades 儲存 ID, name, lab1, lab2, lab3, midTerm, finalExam, and totalGrade
 * 
 * calculateTotalGrade(weights) Grades () { } //建構子
 ************************************************************************/

public class Grades {
	/**
	 * @uml.property  name="name"
	 */
	public String name;
	/**
	 * @uml.property  name="iD"
	 */
	public String ID;
	/**
	 * @uml.property  name="lab1"
	 */
	public int lab1;
	/**
	 * @uml.property  name="lab2"
	 */
	public int lab2;
	/**
	 * @uml.property  name="lab3"
	 */
	public int lab3;
	/**
	 * @uml.property  name="midTerm"
	 */
	public int midTerm;
	/**
	 * @uml.property  name="finalExam"
	 */
	public int finalExam;
	/**
	 * @uml.property  name="totalGrade"
	 */
	public int totalGrade;

	public Grades() {
	} // 建構子

	public int calculateTotalGrade(float[] weights) {
		
		// totalGrade須四捨五入
		int aTotalGrade = Math.round(lab1 * weights[0] + lab2 * weights[1] + lab3
				* weights[2] + midTerm * weights[3] + finalExam * weights[4]);
		return aTotalGrade;
	}
}
