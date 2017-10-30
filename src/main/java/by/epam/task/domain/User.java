package by.epam.task.domain;

/**
 * Объект бизнес данных: пользователь
 */
public class User {

	/** Идентификатор пользователя */
	private int id;
	/** Ник пользователя */
	private String nickname;
	/** Имя пользователя */
	private String name;
	/** Фамилия пользователя */
	private String lastname;
	/** Телефон пользователя */
	private String phone;
	/** Электронный адрес пользователя */
	private String email;
	/** Опыт вождения пользователя */
	private int drivenExperience;

	/** Класс роли пользователя */
	private Role role;

	public User() {
	}

	public User(int id, String nickname, String name, String lastname, String phone, String email, int drivenExperience,
			Role role) {
		this.id = id;
		this.nickname = nickname;
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.drivenExperience = drivenExperience;
		this.role = role;
	}

	public User(int id) {
		this.id = id;
	}

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
