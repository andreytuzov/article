package by.epam.task.domain;

import java.io.Serializable;

/**
 * Объект бизнес данных: повреждение автомобиля
 */
public class Damage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** Идентификатор повреждения */
	private int id;
	/** Стоимость ремонта автомобиля */
	private float cost;
	/** Описание повреждения */
	private String description;

	public Damage() {
	}

	public Damage(int id, float cost, String description) {
		this.id = id;
		this.cost = cost;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Damage [id=" + id + ", cost=" + cost + ", description=" + description + "]";
	}

}
