package by.epam.task.domain;

public class User {

	private int id;
	private String nickname;
	private String name;
	private String lastname;
	private String phone;
	private String email;
	private int drivenExperience;

	private Role role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDrivenExperience() {
		return drivenExperience;
	}

	public void setDrivenExperience(int drivenExperience) {
		this.drivenExperience = drivenExperience;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", name=" + name + ", lastname=" + lastname + ", phone="
				+ phone + ", email=" + email + ", drivenExperience=" + drivenExperience + ", role=" + role + "]";
	}

}
