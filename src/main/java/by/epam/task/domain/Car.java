package by.epam.task.domain;

/**
 * @author User
 *
 */
public class Car {

	private int id;
	private String model;
	private int year;
	private float volume;
	private int power;
	private float prise;
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
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", year=" + year + ", volume=" + volume + ", power=" + power
				+ ", prise=" + prise + ", description=" + description + "]";
	}
}
