GradeSystemProject
==================
User’s Manual 使用手冊
本成績系統讀入全班成績 有 lab1, lab2, lab3, mid-term, final exam 等成績 
內建各成績的配分為0.1, 0.1, 0.1, 0.3, 0.4依配分算出總成績建檔後 
供使用者輸入指令查詢成績及排名 並可更新配分重算總成績 
系統可處理兩種異常 1) 輸入錯誤ID 2) 輸入不正確指令

系統主要畫面如下
螢幕顯示：輸入ID或 Q (結束使用)？ 使用者輸入ID 如李威廷的ID 962001051
螢幕顯示：Welcome 李威廷

輸入指令 1) G 顯示成績 (Grade) 
2) R 顯示排名 (Rank) 
3) W更新配分 (Weight) 
4) E 離開選單 (Exit)  

如輸入指令 G 螢幕顯示： 
李威廷成績：lab1：     81　
lab2：     98　
lab3：     84　
mid-term :  90　
final exam:  93 
                      total grade :  91

如輸入指令 R 螢幕顯示：
          李威廷排名第22

如輸入指令 W 螢幕顯示：
              舊配分 
lab1           10%
               lab2           10%
               lab3           10%
               mid-term       30%
               final exam      40%
      輸入新配分
           lab1           20
               lab2           20
               lab3           20
               mid-term       20
              final exam       20
請確認新配分
           lab1           20%
               lab2           20%
               lab3           20%
               mid-term       20%
               final exam      20%
          以上正確嗎? Y (Yes) 或 N (No)

使用者接著不斷輸入上述指令 直到輸入E (離開選單)
螢幕再度顯示：輸入ID或 Q (結束使用)？ 使用者輸入Q (結束使用) 系統就結束了


Acceptance Test Cases (紅色表示使用者輸入) 驗收測試案例
1.	螢幕顯示：輸入ID或 Q (結束使用)？ Q
螢幕顯示：結束了

2.	螢幕顯示：輸入ID或 Q (結束使用)？ 962001051
螢幕顯示：Welcome 李威廷

輸入指令 1) G 顯示成績 (Grade) 
2) R 顯示排名 (Rank) 
3) W更新配分 (Weight) 
4) E 離開選單 (Exit)  

使用者輸入： E 

螢幕顯示：輸入ID或 Q (結束使用)？ Q
螢幕顯示：結束了

3.	開始至輸入指令如上

使用者輸入： G 
螢幕顯示： 
李威廷成績：lab1：     81　
lab2：     98　
lab3：     84　
mid-term :  90　註 依英文用字 mid及 term 用 “-“ 連結為一字
final exam：93  註 依英文用字 final及 exam 為兩字 
total grade : 91

輸入指令如上
使用者輸入： E 

螢幕顯示：輸入ID或 Q (結束使用)？ Q
螢幕顯示：結束了

4.	開始至輸入指令如上

使用者輸入： R
螢幕顯示：李威廷排名第22 (例:李陳張 totalGrade 分別為 86 86 83 則其rank為1 1 3) 

輸入指令如上
使用者輸入：W
螢幕顯示  舊配分 
lab1           10%
               lab2           10%
               lab3           10%
               mid-term       30%
               final exam      40%
      輸入新配分
           lab1           20
               lab2           20
               lab3           20
               mid-term       20
               final exam      20
請確認新配分
           lab1           20%
               lab2           20%
               lab3           20%
               mid-term       20%
               final exam      20%
          以上正確嗎? Y (Yes) 或 N (No)
使用者輸入：Y

輸入指令如上
使用者輸入： E 

螢幕顯示：輸入ID或 Q (結束使用)？ Q
螢幕顯示：結束了

5.	螢幕顯示：輸入ID或 Q (結束使用)？ 123456789
螢幕顯示：ID錯了!

6.	螢幕顯示：輸入ID或 Q (結束使用)？ 962001051

輸入指令如上
使用者輸入： K 
螢幕顯示：指令錯了!
7.	開始至輸入指令如上

使用者輸入： R
螢幕顯示：李威廷排名第22 (例:李陳張 totalGrade 分別為 86 86 83 則其rank為1 1 3) 

   輸入指令如上
使用者輸入：W
螢幕顯示  舊配分 
lab1           10%
               lab2           10%
               lab3           10%
               mid-term       30%
               final exam      40%
      輸入新配分
           lab1           20
               lab2           20
               lab3           20
               mid-term       20
               final exam      20
請確認新配分
           lab1           20%
               lab2           20%
               lab3           20%
               mid-term       20%
               final exam      20%
          以上正確嗎? Y (Yes) 或 N (No)
使用者輸入：Y
螢幕顯示：輸入指令 1) G 顯示成績 (Grade) 
2) R 顯示排名 (Rank) 
3) W更新配分 (Weight) 
4) E 離開選單 (Exit)
使用者輸入：R
螢幕顯示：李威廷排名第33

8.	開始至輸入指令如上

使用者輸入： R
螢幕顯示：李威廷排名第22 (例:李陳張 totalGrade 分別為 86 86 83 則其rank為1 1 3) 

   輸入指令如上
使用者輸入：W
螢幕顯示  舊配分 
lab1           10%
               lab2           10%
               lab3           10%
               mid-term       30%
               final exam      40%
      輸入新配分
           lab1           A
螢幕顯示：指令錯了!
