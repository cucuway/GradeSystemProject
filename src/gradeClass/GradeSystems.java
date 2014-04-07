package gradeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

import exception.NoSuchCommandExceptions;

/**
 * GradeSystems store a list of student grades. Apply the method containsID(ID),
 * showRank(ID) and updateWeights(). You can query information with ID.
 * 
 * @author Yang
 * 
 */
public class GradeSystems {
	/**
	 * @uml.property name="weights" multiplicity="(0 -1)" dimension="1"
	 */
	float[] weights = { 0.1f, 0.1f, 0.1f, 0.3f, 0.4f };
	/**
	 * @uml.property name="aList"
	 * @uml.associationEnd multiplicity="(0 -1)" elementType="gradeClass.Grades"
	 */
	LinkedList<Grades> aList;
	/**
	 * @uml.property name="scanner"
	 */
	Scanner scanner;

	public GradeSystems() {

		// 1. open input file stream.
		// 2. use LinkedList.class build an empty list of grades name 'aList'
		// 3. read line from file stream.
		// 4. while not endOfFile
		// 4.1. call Grades() new a object name with aGrade.
		// 4.2. use Java Scanner.class scan line consider as 'aGrade'
		// 4.3. aGrade.calculateTotalGrade(weights) assign to aGrade.aTotalGrade
		// 4.4. aGrade push into aList
		// 5. if endOfLine then read line end if end while
		try {
			scanner = new Scanner(System.in);

			Scanner input = new Scanner(new InputStreamReader(
					new FileInputStream(new File("gradeInput.txt")), "UTF8"));

			aList = new LinkedList<Grades>();

			while (input.hasNext()) {
				Grades aGrade = new Grades();
				aGrade.ID = input.next();
				aGrade.name = input.next();
				aGrade.lab1 = input.nextInt();
				aGrade.lab2 = input.nextInt();
				aGrade.lab3 = input.nextInt();
				aGrade.midTerm = input.nextInt();
				aGrade.finalExam = input.nextInt();
				aGrade.totalGrade = aGrade.calculateTotalGrade(weights);
				aList.add(aGrade);
			}
			input.close();
		} catch (Exception e) {
			// TODO
		}
	}

	/**
	 * using O(n) time find identity from grade list.
	 * 
	 * @param ID
	 *            [String] show grade of identity.
	 */
	public void showGrade(String ID) {
		for (int i = 0; i < aList.size(); i++) {
			Grades aGrade = aList.get(i);
			if (ID.equals(aGrade.ID)) {
				System.out.print(aGrade.name + "成績：");
				System.out.println(String
						.format("%-10s%d", "lab1", aGrade.lab1));
				System.out.println(String.format("%9s%-10s%d", "", "lab2",
						aGrade.lab2));
				System.out.println(String.format("%9s%-10s%d", "", "lab3",
						aGrade.lab3));
				System.out.println(String.format("%9s%-10s%d", "", "midTerm",
						aGrade.midTerm));
				System.out.println(String.format("%9s%-10s%d", "", "finalExam",
						aGrade.finalExam));
			}
		}

	}

	/**
	 * using O(n) time find identity from grade list.
	 * 
	 * @param ID
	 * @return #rank.
	 */
	public int showRank(String ID) {
		// 1. 取得這 ID 的 theTotalGrade
		// 2. 令rank 為 1
		// 3. loop aGrade in aList if aTotalGrade > theTotalGrade then
		// rank加1(退1名) end loop
		// (逐一比較，單層迴圈)
		// 4. 回傳 rank
		int theTotalGrade = 0, rank = 0;
		String name = "";
		for (Grades grade : aList) {
			if (grade.ID.equals(ID)) {
				theTotalGrade = grade.totalGrade;
				name = grade.name;
				rank = 1;
			}
		}
		for (Grades grade : aList) {
			if (grade.totalGrade > theTotalGrade)
				rank++;
		}
		System.out.println(name + "排名第 " + rank);
		return rank;
	}

	/**
	 * loop aGrade in aList to calculateTotalGrade(weights) end loop
	 * 
	 * @throws NoSuchCommandExceptions
	 */
	public void updateWeights() throws NoSuchCommandExceptions {
		showOldWeights();
		float[] w = getNewWeights();
		showNewWeights(w);
		System.out.println("以上正確嗎 ? Y (Yes) 或 N (No)");
		String cmd = scanner.next();
		if (cmd.equals("Y")) {
			setWeights(w);
			for (int i = 0; i < aList.size(); i++) {
				aList.get(i).totalGrade = aList.get(i).calculateTotalGrade(
						weights);
			}
		}
	}

	/**
	 * 
	 * @return float array with weight distribution
	 * @throws NoSuchCommandExceptions
	 */
	private float[] getNewWeights() throws NoSuchCommandExceptions {
		float[] w = new float[weights.length];
		System.out.println("輸入新配分");
		String[] items = { "lab1", "lab2", "lab3", "mid-term", "final exam" };
		assert (items.length == weights.length);
		for (int i = 0; i < items.length; i++) {
			System.out.print(String.format("%4s%-12s", "", items[i]));
			if (!scanner.hasNextFloat()) {
				throw new NoSuchCommandExceptions();
			}
			w[i] = scanner.nextFloat() / 100;
		}
		return w;
	}

	/**
	 * @param w
	 * @uml.property name="weights"
	 */
	public void setWeights(float[] w) {
		weights = w;
	}

	private void showOldWeights() {
		System.out.println("舊配分");
		String[] items = { "lab1", "lab2", "lab3", "mid-term", "final exam" };
		assert (items.length == weights.length);
		for (int i = 0; i < items.length; i++) {
			System.out.println(String.format("%4s%-12s%d%%", "", items[i],
					(int) (weights[i] * 100)));
		}
	}

	private void showNewWeights(float[] w) {
		System.out.println("請確認新配分");
		String[] items = { "lab1", "lab2", "lab3", "mid-term", "final exam" };
		assert (items.length == weights.length);
		for (int i = 0; i < items.length; i++) {
			System.out.println(String.format("%4s%-12s%d%%", "", items[i],
					(int) (w[i] * 100)));
		}
	}

	/**
	 * judge whether ID exists in aGradeSystem
	 * 
	 * @param ID
	 * @return true or false.
	 */
	public boolean containsID(String ID) {
		for (int i = 0; i < aList.size(); i++) {
			if (aList.get(i).ID.equals(ID)) {
				return true;
			}
		}
		return false;
	}
}
