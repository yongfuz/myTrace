package com.pactera.bg.budsc.bank.yongfu.po;

public class User {
	private String userName;
	private String password;
	private String createTime;
	private String loginIp;
	private String loginType;
	private int loginPort;
	private String lastLoginSign;
	// 查询的开始时间和结束时间
	private String startTime;
	private String endTime;
	private double longitude;
	private double latitude;
	// 每次查询1000个点，如果点数超过1000，超过的倍数为num
	private double num;

	public User() {
		super();
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public User(String userName) {
		super();
		this.userName = userName;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public int getLoginPort() {
		return loginPort;
	}

	public void setLoginPort(int loginPort) {
		this.loginPort = loginPort;
	}

	public String getLastLoginSign() {
		return lastLoginSign;
	}

	public void setLastLoginSign(String lastLoginSign) {
		this.lastLoginSign = lastLoginSign;
	}

}
