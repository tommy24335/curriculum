package service;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.EmployeeBean;
 
/**
 * ・社員情報検索サービス
 */
 
public class EmployeeService {
 
  // 問① 接続情報を記述してください 定数を設定しておく
 /** ドライバーのクラス名 */
 private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
 /** ・JDBC接続先情報 */
 private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/Employee"; //DBの名前
 /** ・ユーザー名 */
 private static final String USER = "postgres";
 /** ・パスワード */
 private static final String PASS = "postgres";
 /** ・タイムフォーマット */
 private static final String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
 
  // 問② 入力された値で、UPDATEする文、データベース内のデータを変更、更新する
 /** ・SQL UPDATE文 */
 private static final String SQL_UPDATE = "update employee_table set login_time = ? where id = ? ";

  // 問③ 入力されたIDとPassWordをキーにして、データベースにある情報を抽出する文
 /** ・SQL SELECT文 */
 private static final String SQL_SELECT = "select * from employee_table where id = ? AND password = ? ";
 
 EmployeeBean employeeDate = null;
 
  // 送信されたIDとPassWordを元に社員情報を検索するためのメソッド
 public EmployeeBean search(String id, String password) {
 
 Connection connection = null; //使用するオブジェクトの宣言
 Statement statement = null;
 ResultSet resultSet = null;
 PreparedStatement preparedStatement = null;
 
 try {
  // データベースに接続
 Class.forName(POSTGRES_DRIVER);  //JDBCドライバをロードしています。つまり、データベースへ接続する下準備
 connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);  //jdbc:postgresql://【ホスト名】/【データベース名】 【ユーザ名】 【パスワード】
 statement = connection.createStatement();  //SQLの実行,StatementインタフェースのexecuteQuery()メソッドは、引数で指定されたSQLをデータベースで実行するメソッドです。
 
  // 処理が流れた時間をフォーマットに合わせて生成（ログインタイムの生成）
 Calendar cal = Calendar.getInstance();
 SimpleDateFormat sdFormat = new SimpleDateFormat(TIME_FORMAT);
 
  // PreparedStatementで使用するため、String型に変換
 String login_time = sdFormat.format(cal.getTime());
 
 /*
 * 任意のユーザーのログインタイムを更新できるように、プリペアドステートメントを記述。
 */
 
  // preparedStatement（似たSQL文を繰り返し実行可）に実行したいSQLを格納、
 preparedStatement = connection.prepareStatement(SQL_UPDATE);//SQL文が渡されています。
  // 問④ preparedStatementを使って、一番目のindexに今の時間をセットしてください。2番目のindexにIDをセットしてください。
 preparedStatement.setString(1, login_time); //第一引数は何番目の?を指定。第２引数は値
 preparedStatement.setString(2, id);
  // 問⑤ UPDATEを実行する文を記述
 preparedStatement.executeUpdate();
 /*
 * UPDATEが成功したものを即座に表示
 * 任意のユーザーを検索できるように、プリペアドステートメントを記述。
 */
 preparedStatement = connection.prepareStatement(SQL_SELECT); //同じSQL文をデータベースへ送信するための準備を行う機能
  //問⑥ 一番目のindexにIDをセットしてください。2番目のindexにPASSWORDをセット。
 preparedStatement.setString(1, id);
 preparedStatement.setString(2, password);
  // SQLを実行。実行した結果をresultSetに格納。
 resultSet = preparedStatement.executeQuery(); //select文の場合には、 executeQuery() メソッドで対応
 
 while (resultSet.next()) {    //検索結果を保持 必ず next()メソッド （次の行に移動する）で最初の行に移動してやる必要があります。
  // 問⑦ tmpName,tmpComment,tmpLoginTimeに適当な値を入れてください。
 String tmpName = resultSet.getString("name"); //引数はSQLの列の名前　tmpNameにSQLのname列の値を代入
 String tmpComment = resultSet.getString("comment");
 String tmpLoginTime = resultSet.getString("login_time");
 
  // 問⑧ EmployeeBeanに取得したデータを入れてください。
 employeeDate = new EmployeeBean();
 employeeDate.setName(tmpName);
 employeeDate.setComment(tmpComment);
 employeeDate.setLogin_Time(tmpLoginTime);
 }
 
  // forName()で例外発生
 } catch (ClassNotFoundException e) { //指定したクラス名のクラスがなかった場合の例外
 e.printStackTrace();
 
  // getConnection()、createStatement()、executeQuery()で例外発生
 } catch (SQLException e) {
 e.printStackTrace();
 
 } finally { //リソースの開放
 try {
 
 if (resultSet != null) {
 resultSet.close();
 }
 if (statement != null) {
 statement.close();
 }
 if (connection != null) {
 connection.close();           //接続の時に作られたconnectionオブジェクトを切断（開放）するためにclose()メソッドを実行します。これで、データベースから切断されます。
 }                             //切断する理由は SQL文がデータベース上に滞留し処理が進まなくなり、エラーになることがあるからです。
 
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
 return employeeDate;
 }
}