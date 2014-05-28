package ncu.csie;

import java.util.Scanner;

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
	 */

	public void promptCommand() throws NoSuchCommandExceptions {
		while (true) {
			System.out
					.println("輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) W更新配分 (Weight)\n\t4) E 離開選單 (Exit)\n\t\t使用者輸入：");
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
