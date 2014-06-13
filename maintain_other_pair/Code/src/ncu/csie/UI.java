package ncu.csie;

import java.util.Scanner;

import ncu.csie.exceptions.DuplicateExceptions;
import ncu.csie.exceptions.NoSuchCommandExceptions;
import ncu.csie.exceptions.NoSuchIDExceptions;

/**
 * *********************************************************************** class
 * UI (user interface)
 * 
 * checkID(ID) //檢查ID是否存在 promptCommand() //要求輸入指令 promptID() //要求輸入ID
 * showFinishMsg() //顯示結束訊息 showWelcomeMsg() //顯示歡迎訊息 UI() 建構子 建構 aGradeSystem
 ************************************************************************ */

public class UI {
	public GradeSystems aGradeSystem;
	Scanner scanner = new Scanner(System.in);
	String loginStuId;
	int loginStuIndex;

	/**
	 * ------------------------------------------------------------------------
	 * UI() 建構子 throws NoSuchIDExceptions, NoSuchCommandExceptions
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
	 * user ID ex: 123456789 time: O(n) n is aGradeSystem 內全班人數
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
					.println("輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) W 更新配分 (Weight)\n\t4) A 新增學生 (Add)\n\t5) D 刪減學生 (Delete)\n\t6) M 更改分數 (Modify)\n\t7) Q 結束使用  (Quit)\n\t8) S 儲存離開  (Save)\n\t\t使用者輸入：");
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
		System.out.println("輸入ID或 Q (結束使用)");
		return scanner.next();
	}

	private void showFinishMsg() {
		System.out.println("結束了");
	}

	private void showWelcomeMsg(int loginStuIndex) {
		System.out.println("Welcome "
				+ aGradeSystem.getStudentName(loginStuIndex));

	}

}
