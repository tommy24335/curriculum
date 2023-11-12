package jp.co.sss.sys.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * エンティティクラス
 * @author Inoue Nami
 *
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable{

	/**
	 * 社員番号
	 */
	@Id
	@Column(name ="emp_id" )
	@NotEmpty(message = "社員番号は入力必須項目です")
    @Size(max = 5, message = "社員番号は5文字以内で入力してください")
	private String empId;
	
	/**
	 * 社員名
	 */
	@Column(name = "emp_name")
	@NotEmpty(message = "パスワードは入力必須項目です")
    @Size(max = 16, message = "パスワードは16文字以内で入力してください")
	private String empName;
	
	@Column  (name="password")
	private String password;
	
	@Column  (name="birthday")
	private Date birthday;
	
	@Column  (name="gender")
	private int gender;
	
	@Column  (name="delete_at")
	private Boolean delete;

	//ゲッターセッター
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}

	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getBirthday() {
		return birthday;
	}

	
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getGender() {
		return gender;
	}
	
	
	public void setDelete(Boolean delete) {
		this.delete = delete;
	}
	public Boolean getDelete() {
		return delete;
	}
	
	
	


}
