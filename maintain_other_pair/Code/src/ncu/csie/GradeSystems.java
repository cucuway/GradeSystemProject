package ncu.csie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import ncu.csie.exceptions.DuplicateExceptions;
import ncu.csie.exceptions.NoSuchIDExceptions;
import ncu.csie.modle.Grades;

/**
 * *************************************************************************
 * class GradeSystems�x�s a list of student grades.
 * 
 * containsID(ID) //��aGradeSystem���_�t��ID GradeSystems () //�غc�l showGrade(ID)
 * //��ܦ�ID�ǥͪ����Z showRank(ID) //��ܦ�ID�ǥͪ��ƦW updateWeights () //�����ƭp���v��
 *************************************************************************** */

public class GradeSystems {
	public float[] weights = { 0.1f, 0.1f, 0.1f, 0.3f, 0.4f };
	public LinkedList<Grades> aList = new LinkedList<Grades>();
	Grades temp;
	Grades currentUser;
	Scanner scanner;
	String localTextFile = "input.txt";

	GradeSystems(Scanner scanner) {
		this.scanner = scanner;
		BufferedReader in;
		String text;
		String gInformation[];

		try {
			in = new BufferedReader(new FileReader(localTextFile));
			do {
				text = in.readLine();
				if (text != null) {
					temp = new Grades();
					gInformation = text.split(" ");
					temp.setID(gInformation[0]);
					temp.setName(gInformation[1]);
					temp.setlab1(Integer.valueOf(gInformation[2]));
					temp.setlab2(Integer.valueOf(gInformation[3]));
					temp.setlab3(Integer.valueOf(gInformation[4]));
					temp.setmidTerm(Integer.valueOf(gInformation[5]));
					temp.setfinalExam(Integer.valueOf(gInformation[6]));
					temp.calculateTotalGrade(weights);
					aList.add(temp);
				}

			} while (text != null);
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ------------------------------------------------------------------------
	 * containsID (ID) return int parameter(index of data): ID a user ID ex:
	 * 123456789 time: O(n) n is aGradeSystem �����Z�H��
	 * 
	 * -------------------------------------------------------------------------
	 */
	public int containsID(String Id) {
		for (int nOfId = 0; nOfId < aList.size(); nOfId++) {
			if (aList.get(nOfId).getID().equals(Id)) {
				currentUser = aList.get(nOfId);
				return nOfId;
			}
		}
		return -1;
	}

	/**
	 * ------------------------------------------------------------------------
	 * showGrade (ID) return String parameter: ID a user ID ex: 123456789 time:
	 * O(n) n is aGradeSystem �����Z�H��
	 * 
	 * -------------------------------------------------------------------------
	 */
	public String showGrade(String Id) {
		for (int nOfId = 0; nOfId < aList.size(); nOfId++) {
			if (aList.get(nOfId).getID().equals(Id)) {
				temp = aList.get(nOfId);
				String grade = String
						.format("%s���Z�G lab1�G     %s�@\n\tlab2�G     %s�@\n\tlab3�G     %s�@\n\tmid-term :  %s�@\n\tfinal exam�G%s�@\n\ttotal grade : %s\n",
								temp.getName(), temp.getlab1(), temp.getlab2(),
								temp.getlab3(), temp.getmidTerm(),
								temp.getfinalExam(), temp.getTotalGrade());
				System.out.print(grade);
				return grade;
			}
		}
		return null;
	}

	/**
	 * ------------------------------------------------------------------------
	 * showRank (ID) return int parameter(rank): ID a user ID ex: 123456789
	 * time: O(n) n is aGradeSystem �����Z�H��
	 * 
	 * -------------------------------------------------------------------------
	 */
	public int showRank(String Id) {
		int rank = 1;
		int theTotalGrade = 0;
		int indexOfId = 0;
		for (int nOfId = 0; nOfId < aList.size(); nOfId++) {
			if (aList.get(nOfId).getID().equals(Id)) {
				theTotalGrade = aList.get(nOfId).getTotalGrade();
				indexOfId = nOfId;
				break;
			}
		}
		for (Grades temp : aList) {
			if (!temp.getID().equals(Id)) {
				if (temp.getTotalGrade() >= theTotalGrade)
					rank++;
			}
		}
		System.out.printf("%s�ƦW��%d\r\n", aList.get(indexOfId).getName(), rank);

		return rank;
	}

	public String getStudentName(int nOfId) {

		return aList.get(nOfId).getName();
	}

	public void updateWeights() {

		float[] newWeight = new float[5];
		showOldWeights();
		getNewWeights(newWeight);
		setWeights(newWeight);
		for (Grades temp : aList) {
			temp.calculateTotalGrade(weights);
		}
	}

	public void addStudent() throws DuplicateExceptions {
		System.out.println("��J�s�W�ǥͪ�ID");
		String addStuId = scanner.next();
		if (this.containsID(addStuId) >= 0)
			throw new DuplicateExceptions();
		Grades addStuGrade = this.getNewStudentGrade();
		addStuGrade.setID(addStuId);
		setAddStudent(addStuGrade);
	}

	public void removeStudent() throws NoSuchIDExceptions {
		System.out.println("��J�R��ǥͪ�ID");
		String rmStuId = scanner.next();
		int rmStuGradeIdx;
		if ((rmStuGradeIdx = this.containsID(rmStuId)) < 0)
			throw new NoSuchIDExceptions();
		setRemoveStudent(aList.get(rmStuGradeIdx));
	}

	public void modifyStudentGrade() {

	}

	private void setAddStudent(Grades addStuGrade) {
		System.out
				.printf(String.format("�T�{�s�W�ǥ�%s���m�W�Φ��Z\n", addStuGrade.getID()));
		System.out.printf("\t�m�W\t%s\n", addStuGrade.getName());
		System.out.printf("\tLab1\t%d\n", addStuGrade.getlab1());
		System.out.printf("\tLab2\t%d\n", addStuGrade.getlab2());
		System.out.printf("\tLab3\t%d\n", addStuGrade.getlab3());
		System.out.printf("\tMid-term\t%d\n", addStuGrade.getmidTerm());
		System.out.printf("\tFinal exam\t%d\n", addStuGrade.getfinalExam());

		System.out.printf("(yes/no)\n");
		if (scanner.next().charAt(0) == 'y') {
			aList.add(addStuGrade);
			writeBackDataBase();
			System.out.printf("�s�W�ǥ�%s%s �����F\n", addStuGrade.getID(),
					addStuGrade.getName());
		}
	}

	private void setRemoveStudent(Grades rmStuGrade) {
		System.out.printf(String.format("�T�{�R��ǥ�%s%s (yes/no)\n",
				rmStuGrade.getID(), rmStuGrade.getName()));

		if (scanner.next().charAt(0) == 'y') {
			if (aList.remove(rmStuGrade)) {
				writeBackDataBase();
				System.out.printf("�R��ǥ�%s%s �����F\n", rmStuGrade.getID(),
						rmStuGrade.getName());
			}
		}
	}

	private void setWeights(float[] newWeight) {
		System.out
				.printf("�нT�{�s�t��\n\tlab1 %.0f%%\n\tlab2 %.0f%%\n\tlab3 %.0f%%\n\tmid-term %.0f%%\n\tfinal exam %.0f%%\n  �H�W���T��? Y (Yes) �� N (No)",
						newWeight[0], newWeight[1], newWeight[2], newWeight[3],
						newWeight[4]);

		if (scanner.next().charAt(0) == 'Y') {
			weights = newWeight;
		}
	}

	private void getNewWeights(float[] newWeight) {
		System.out.println("��J�s�t��");
		System.out.printf("\tlab1 ");
		newWeight[0] = Float.valueOf(scanner.next());
		System.out.printf("\tlab2 ");
		newWeight[1] = Float.valueOf(scanner.next());
		System.out.printf("\tlab3 ");
		newWeight[2] = Float.valueOf(scanner.next());
		System.out.printf("\tmid-term ");
		newWeight[3] = Float.valueOf(scanner.next());
		System.out.printf("\tfinalExam ");
		newWeight[4] = Float.valueOf(scanner.next());
	}

	private Grades getNewStudentGrade() {
		Grades aGrade = new Grades();

		System.out.printf("\t�m�W ");
		aGrade.setName(scanner.next());
		System.out.printf("\tlab1 ");
		aGrade.setlab1(Integer.valueOf(scanner.next()));
		System.out.printf("\tlab2 ");
		aGrade.setlab2(Integer.valueOf(scanner.next()));
		System.out.printf("\tlab3 ");
		aGrade.setlab3(Integer.valueOf(scanner.next()));
		System.out.printf("\tmid-term ");
		aGrade.setmidTerm(Integer.valueOf(scanner.next()));
		System.out.printf("\tfinalExam ");
		aGrade.setfinalExam(Integer.valueOf(scanner.next()));
		return aGrade;
	}

	private void showOldWeights() {
		System.out
				.printf("�°t��\n\tlab1 %.0f%%\n\tlab2 %.0f%%\n\tlab3 %.0f%%\n\tmid-term %.0f%%\n\tfinal exam %.0f%%\n",
						weights[0] * 100, weights[1] * 100, weights[2] * 100,
						weights[3] * 100, weights[4] * 100);
	}

	private void writeBackDataBase() {
		BufferedWriter out;

		try {
			out = new BufferedWriter(new FileWriter(localTextFile));
			for (Grades aGrade : aList) {
				String item;
				item = String.format("%s %s %d %d %d %d %d", aGrade.getID(),
						aGrade.getName(), aGrade.getlab1(), aGrade.getlab2(),
						aGrade.getlab3(), aGrade.getmidTerm(),
						aGrade.getfinalExam());
				out.write(item);
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
