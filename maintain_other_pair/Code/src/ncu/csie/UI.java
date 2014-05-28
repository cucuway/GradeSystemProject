package ncu.csie;

import java.util.Scanner;

import ncu.csie.exceptions.NoSuchCommandExceptions;
import ncu.csie.exceptions.NoSuchIDExceptions;

/**
 * *********************************************************************** class
 * UI (user interface)
 * 
 * checkID(ID) //�ˬdID�O�_�s�b promptCommand() //�n�D��J���O promptID() //�n�D��JID
 * showFinishMsg() //��ܵ����T�� showWelcomeMsg() //����w��T�� UI() �غc�l �غc aGradeSystem
 ************************************************************************ */

public class UI {
	public GradeSystems aGradeSystem;
	Scanner scanner = new Scanner(System.in);
	String loginStuId;
	int loginStuIndex;

	/**
	 * ------------------------------------------------------------------------
	 * UI() �غc�l throws NoSuchIDExceptions, NoSuchCommandExceptions
	 * ------------------------------------------------------------
	 */

	public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		try {
			aGradeSystem = new GradeSystems(scanner);
			while (true) {
				String inputId = promptID();
				if (inputId.equals("Q"))
					break;
				else if ((loginStuIndex = checkID(inputId)) >= 0) {
					loginStuId = inputId;
					showWelcomeMsg(loginStuIndex);
					promptCommand();
				} else
					throw new NoSuchIDExceptions();
			}
			showFinishMsg();
		} finally {

		}

	}

	/**
	 * ------------------------------------------------------------------------
	 * checkID (ID) throws NoSuchIDExceptions return Boolean parameter: ID a
	 * user ID ex: 123456789 time: O(n) n is aGradeSystem �����Z�H��
	 * 
	 * -------------------------------------------------------------------------
	 */

	public int checkID(String id) throws NoSuchIDExceptions {
		return aGradeSystem.containsID(id);
	}

	/**
	 * ------------------------------------------------------------------------
	 * promptCommand () throws NoSuchCommandExceptions
	 * ---------------------------------------------------------------
	 */

	public void promptCommand() throws NoSuchCommandExceptions {
		while (true) {
			System.out
					.println("��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) W��s�t�� (Weight)\n\t4) E ���}��� (Exit)\n\t\t�ϥΪ̿�J�G");
			String intputCommand = scanner.next();
			switch (intputCommand.charAt(0)) {
			case 'G':
				aGradeSystem.showGrade(loginStuId);
				break;
			case 'R':
				aGradeSystem.showRank(loginStuId);
				break;
			case 'W':
				aGradeSystem.updateWeights();
				break;
			case 'E':
				return;
			default:
				throw new NoSuchCommandExceptions();
			}
		}

	}

	private String promptID() {
		System.out.println("��JID�� Q (�����ϥ�)");
		return scanner.next();
	}

	private void showFinishMsg() {
		System.out.println("�����F");
	}

	private void showWelcomeMsg(int loginStuIndex) {
		System.out.println("Welcome "
				+ aGradeSystem.getStudentName(loginStuIndex));

	}

}
