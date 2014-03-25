package gradeClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * *************************************************************************
 * class GradeSystems儲存 a list of student grades.
 * 
 * containsID(ID) //看aGradeSystem有否含此ID GradeSystems () //建構子 showGrade(ID)
 * showRank(ID) updateWeights ()
 *************************************************************************** */

public class GradeSystems {
	float[] weights = { 0.1f, 0.1f, 0.1f, 0.3f, 0.4f };
	LinkedList<Grades> aList;

	public GradeSystems() {

		try {

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
				// System.out.println(aGrade.ID);
				aList.add(aGrade);
			}
		}

		catch (Exception e) {

		}

		// 1. 開檔 input file
		// 2. 用Java LinkedList建構an empty list of grades叫 aList
		// 3. read line
		// 4. while not endOfFile
		// 1.call Grades() 建構aGrade
		// 2.用 Java Scanner 來 scan line 把各欄位存入aGrade
		// 3. aGrade.calculateTotalGrade(weights) 回傳aTotalGrade把它存入aGrade
		// 4. 把 aGrade 存入 aList
		// 5. if endOfLine then read line end if
		// end while
	}

	public void showGrade(String ID) {
		// show 這 ID 的 grade
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

	public int showRank(String ID) {

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
		// 1. 取得這 ID 的 theTotalGrade
		// 2. 令rank 為 1
		// 3. loop aGrade in aList if aTotalGrade > theTotalGrade then
		// rank加1(退1名) end loop
		// (逐一比較，單層迴圈)
		// 4. 回傳 rank
	}

	public void updateWeights() {
		showOldWeights();
		float[] w = getNewWeights();
		showNewWeights(w);
		Scanner scanner = new Scanner(System.in);
		System.out.println("以上正確嗎 ? Y (Yes) 或 N (No)");
		String cmd = scanner.next();
		if (cmd.equals("Y")) {
			setWeights(w);
			for (int i = 0; i < aList.size(); i++) {
				aList.get(i).totalGrade = aList.get(i).calculateTotalGrade(
						weights);
			}
		}
		// 4. loop aGrade in aList to calculateTotalGrade(weights) end loop
	}

	private float[] getNewWeights() {
		// TODO Auto-generated method stub
		float[] w = new float[weights.length];
		Scanner scanner = new Scanner(System.in);
		System.out.println("輸入新配分");
		String[] items = { "lab1", "lab2", "lab3", "mid-term", "final exam" };
		assert (items.length == weights.length);
		for (int i = 0; i < items.length; i++) {
			System.out.print(String.format("%4s%-12s", "", items[i]));
			w[i] = scanner.nextFloat() / 100;
		}
		return w;
	}

	public void setWeights(float[] w) {
		// TODO Auto-generated method stub
		weights = w;
	}

	private void showOldWeights() {
		// TODO Auto-generated method stub
		System.out.println("舊配分");
		String[] items = { "lab1", "lab2", "lab3", "mid-term", "final exam" };
		assert (items.length == weights.length);
		for (int i = 0; i < items.length; i++) {
			System.out.println(String.format("%4s%-12s%d%%", "", items[i],
					(int) (weights[i] * 100)));
		}
	}

	private void showNewWeights(float[] w) {
		// TODO Auto-generated method stub
		System.out.println("請確認新配分");
		String[] items = { "lab1", "lab2", "lab3", "mid-term", "final exam" };
		assert (items.length == weights.length);
		for (int i = 0; i < items.length; i++) {
			System.out.println(String.format("%4s%-12s%d%%", "", items[i],
					(int) (w[i] * 100)));
		}
	}

	public boolean containsID(String ID) {
		// 看 ID 是否含在 aGradeSystem內
		for (int i = 0; i < aList.size(); i++) {
			// System.out.println(aList.get(i).ID);
			if (aList.get(i).ID.equals(ID)) {
				return true;
			}

		}
		return false;
	}
}
