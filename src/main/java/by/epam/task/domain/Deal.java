package by.epam.task.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Объект бизнес данных: заказ
 */
public class Deal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** Идентификатор заказа */
	private int id;
	/** Стоимость заказа */
	private float cost;
	/** Дата начала заказа */
	private Date dateFrom;
	/** Дата окончания заказа */
	private Date dateTo;
	/** Комментарий пользователя к заказу */
	private String comment;
	/** Причина отмены заказа */
	private String cancelReason;
	/** Номер пасспорта */
	private String passportNumber;

	/** Класс пользователя, который выполняет заказ  */
	private User user;
	/** Класс автомобиля, для которого производится заказ */
	private Car car;
	/** Класс повреждения автомобиля */
	private Damage damage;
	/** Класс состояния заказа*/
	private DealState state;

	public Deal() {
	}

	public Deal(int id, float cost, Date dateFrom, Date dateTo, String comment, String cancelReason, User user, Car car,
			Damage damage, DealState state, String passportNumber) {
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
		this.passportNumber = passportNumber;
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

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	@Override
	public String toString() {
		return "Deal [id=" + id + ", cost=" + cost + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", comment="
				+ comment + ", cancelReason=" + cancelReason + ", passportNumber=" + passportNumber + ", user=" + user
				+ ", car=" + car + ", damage=" + damage + ", state=" + state + "]";
	}

}
