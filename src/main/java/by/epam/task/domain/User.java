package by.epam.task.domain;

import java.io.Serializable;

/**
 * Объект бизнес данных: пользователь
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + drivenExperience;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (drivenExperience != other.drivenExperience)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (role != other.role)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", name=" + name + ", lastname=" + lastname + ", phone="
				+ phone + ", email=" + email + ", drivenExperience=" + drivenExperience + ", role=" + role + "]";
	}

}
