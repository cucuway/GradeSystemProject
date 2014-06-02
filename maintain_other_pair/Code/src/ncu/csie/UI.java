package ncu.csie;

import java.util.Scanner;

import ncu.csie.exceptions.DuplicateExceptions;
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
	 * @throws DuplicateExceptions 
	 */

	public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions, DuplicateExceptions {
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
	 * @throws DuplicateExceptions 
	 * @throws NoSuchIDExceptions 
	 */

	public void promptCommand() throws NoSuchCommandExceptions, DuplicateExceptions, NoSuchIDExceptions {
		while (true) {
			System.out
					.println("��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) W ��s�t�� (Weight)\n\t4) A �s�W�ǥ� (Add)\n\t5) D �R��ǥ� (Delete)\n\t6) M ������ (Modify)\n\t7) Q �����ϥ�  (Quit)\n\t8) S �x�s���}  (Save)\n\t\t�ϥΪ̿�J�G");
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
			case 'Q':				
				return;
			case 'A':
				aGradeSystem.addStudent();
				break;
			case 'D':
				aGradeSystem.removeStudent();
				break;
			case 'M':
				aGradeSystem.modifyStudentGrade();
				break;
			case 'S':
				aGradeSystem.writeBackDataBase();
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
