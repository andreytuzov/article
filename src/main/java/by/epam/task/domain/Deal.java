package by.epam.task.domain;

import java.util.Date;

public class Deal {

	private int id;
	private float cost;
	private Date dateFrom;
	private Date dateTo;
	private String comment;
	private String cancelReason;

	private User user;
	private Car car;
	private Damage damage;
	private DealState state;

	public Deal() {
	}

	public Deal(int id, float cost, Date dateFrom, Date dateTo, String comment, String cancelReason, User user, Car car,
			Damage damage, DealState state) {
		this.id = id;
		this.cost = cost;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.comment = comment;
		this.cancelReason = cancelReason;
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

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Damage getDamage() {
		return damage;
	}

	public void setDamage(Damage damage) {
		this.damage = damage;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	@Override
	public String toString() {
		return "Deal [id=" + id + ", cost=" + cost + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", comment="
				+ comment + ", cancelReason=" + cancelReason + ", user=" + user + ", car=" + car + ", damage=" + damage
				+ ", state=" + state + "]";
	}

}
