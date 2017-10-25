package by.epam.task.domain;

public class Damage {

	private int id;
	private float bill;
	private String description;

	public Damage() {
	}

	public Damage(int id, float bill, String description) {
		this.id = id;
		this.bill = bill;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Damage [id=" + id + ", bill=" + bill + ", description=" + description + "]";
	}

}
