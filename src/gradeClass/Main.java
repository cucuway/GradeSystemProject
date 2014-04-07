package gradeClass;

import exception.NoSuchCommandExceptions;
import exception.NoSuchIDExceptions;

/**
 * 本Grade system 讓使用者(學生)取得他的總成績total grade 及排名 rank. 
 * Total grade 基於配分weights 來算而 weights可以update. 
 * Rank 表示此 total grade 在全班學生的分數排序
 * 
 * Input file: 全班學生的分數 例如 
 * 注意 data field names 如下: 
 * ID name lab1 lab2 lab3 midTerm finalExam
 * 962001044 凌宗廷 87 86 98 88 87 
 * 962001051 李威廷 81 98 84 90 93 
 * 
 * 
 * @author Yang
 * 
 */
public class Main extends Object {

	public static void main(String args[]) {
		try {
			new UI();
		} catch (NoSuchIDExceptions e1) {
			System.out.println("ID錯了!");
		} catch (NoSuchCommandExceptions e2) {
			System.out.println("指令錯了!");
		}
	}
}