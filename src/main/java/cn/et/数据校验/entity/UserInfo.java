package cn.et.数据校验.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
public class UserInfo {
	//@NotEmpty不能校验整型
	@NotEmpty(message="{nameError}") //｛键｝获取配置文件中的值
	private String userName;
	@NotEmpty(message="{passwError}")
	private String password;
	@NotEmpty(message="{rePasswError}")
	private String rePassword;
	@NotEmpty(message="{mailboxError}")
	//354518484@qq.com   正则表达式为  .+@.+\\..+   .表示任何单个字符  +表示匹配前面的子表达式一次或多次(大于等于1次）  \\转义字符 将下一个字符标记符、或一个向后引用、或一个八进制转义符  转为正常状态
	@Pattern(message="{mailboxError1}", regexp=".+@.+\\..+")
	private String email;
	@Range(min=1, max=150, message="{ageError}")
	private String age;
	@NotEmpty(message="{phoneError}")
	@Size(max=11, min=11, message="{phoneError1}")  //长度为11位
	private String phone;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
