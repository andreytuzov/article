package by.epam.task.domain;

import java.util.Date;

public class Deal {
	
	private int id;
	private int bill;
	private Date dateFrom;
	private Date dateTo;
	private String description;
	
	private User user;
	private Car car;
	private Damage damage;
	private DealState state;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public DealState getState() {
		return state;
	}

	public void setState(DealState state) {
		this.state = state;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Damage getDamage() {
		return damage;
	}

	public void setDamage(Damage damage) {
		this.damage = damage;
	}

	@Override
	public String toString() {
		return "Deal [id=" + id + ", user=" + user + ", car=" + car + ", state=" + state + ", bill=" + bill
				+ ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", description=" + description + ", damage="
				+ damage + "]";
	}

}
