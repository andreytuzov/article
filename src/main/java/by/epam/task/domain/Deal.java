package by.epam.task.domain;

import java.util.Date;

public class Deal {

	private int id;
	private float bill;
	private Date dateFrom;
	private Date dateTo;
	private String description;
	private String reason;

	private User user;
	private Car car;
	private Damage damage;
	private DealState state;
	
	public Deal() {
	}
	
	public Deal(int id, float bill, Date dateFrom, Date dateTo, String description, String reason, User user, Car car,
			Damage damage, DealState state) {
		this.id = id;
		this.bill = bill;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.description = description;
		this.reason = reason;
		this.user = user;
		this.car = car;
		this.damage = damage;
		this.state = state;
	}

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

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Deal [id=" + id + ", bill=" + bill + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", description="
				+ description + ", reason=" + reason + ", user=" + user + ", car=" + car + ", damage=" + damage
				+ ", state=" + state + "]";
	}

}
