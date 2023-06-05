package controller;
 
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 社員情報管理コントローラー
 */
import bean.EmployeeBean;
import service.EmployeeService;
 
public class EmployeeController extends HttpServlet {
 public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 
 try {
  // 問① index.htmlから送信されたIDとPassWordの値を取得できるように修正しましょう。requestオブジェクト を使用してパラメータを読み込みます。
 String id = request.getParameter("id");
 String password = request.getParameter("password");
 
 /*
 * IDとPassWordと元に、社員情報を検索する関数の呼び出し、結果をJSPに渡す処理、Webスコープ（ページをまたいでも入力情報を保持しておける仕組み）
 * ※ EmployeeBeanとEmployeeServiceをimportするのを忘れないでください。
 */
 
  // 問② EmployeeServiceクラスをインスタンス化する。使えるようにする
 EmployeeService service = new EmployeeService();
  // 問③ EmployeeBeanに、EmployeeServiceよりsearch関数を呼び出し、返り値を格納する。
 EmployeeBean rtnData = service.search(id, password);
  // 問④ nullの部分に適切な引数をセットする。取得したrtnDataの値をindex.jspに渡すためリクエストスコープにセット
 request.setAttribute("EmployeeBean", rtnData);  //リクエストスコープに保存、第1引数に属性の名前を文字列で与え、第2引数で属性値を与えます。
 
 } catch (Exception e) {
 e.printStackTrace();
 } finally { //try文の中で例外が発生してもしなくても必ず実行されます。その為、必ず行っておきたい処理がある場合にはfinallyブロックを用意してブロック内に記述する
 ServletContext context = this.getServletContext();
 RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");  //JSPを呼び出す（転送）引数には転送先のJSPのパス
 dispatcher.forward(request, response);
 }
 }
}