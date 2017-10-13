package by.epam.task.domain;

public class Damage {

	private int id;
	private int bill;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
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
