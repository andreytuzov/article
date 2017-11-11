package by.epam.task.domain;

import java.io.Serializable;

/**
 * Объект бизнес данных: автомобиль
 */
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;	
	
	/** Идентификатор автомобиля */
	private int id;
	/** Модель автомобиля */
	private String model;
	/** Год выпуска автомобиля */
	private int year;
	/** Объем двигателя автомобиля */
	private float volume;
	/** Мощность автомобиля */
	private int power;
	/** Цена проката за час */
	private float prise;
	/** Описание автомобиля */
	private String description;

	public Car() {
	}

	public Car(int id, String model, int year, float volume, int power, float prise, String description) {
		this.id = id;
		this.model = model;
		this.year = year;
		this.volume = volume;
		this.power = power;
		this.prise = prise;
		this.description = description;
	}

	public Car(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public float getPrise() {
		return prise;
	}

	public void setPrise(float prise) {
		this.prise = prise;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + power;
		result = prime * result + Float.floatToIntBits(prise);
		result = prime * result + Float.floatToIntBits(volume);
		result = prime * result + year;
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
		Car other = (Car) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (power != other.power)
			return false;
		if (Float.floatToIntBits(prise) != Float.floatToIntBits(other.prise))
			return false;
		if (Float.floatToIntBits(volume) != Float.floatToIntBits(other.volume))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", year=" + year + ", volume=" + volume + ", power=" + power
				+ ", prise=" + prise + ", description=" + description + "]";
	}
}
