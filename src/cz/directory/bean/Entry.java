package cz.directory.bean;

public class Entry {

	private Integer idDir;
	private String firstname;
	private String surname;
	private String phoneNumber;

	public Integer getIdDir() {
		return idDir;
	}

	public void setIdDir(Integer idDir) {
		this.idDir = idDir;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

}
