package by.epam.task.domain;

public class Discount {
	
	private int id;
	private String name;
	private int only1day;
	private int between2and7days;
	private int between8and15days;
	private int between16and30days;
	private int from31days;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOnly1day() {
		return only1day;
	}

	public void setOnly1day(int only1day) {
		this.only1day = only1day;
	}

	public int getBetween2and7days() {
		return between2and7days;
	}

	public void setBetween2and7days(int between2and7days) {
		this.between2and7days = between2and7days;
	}

	public int getBetween8and15days() {
		return between8and15days;
	}

	public void setBetween8and15days(int between8and15days) {
		this.between8and15days = between8and15days;
	}

	public int getBetween16and30days() {
		return between16and30days;
	}

	public void setBetween16and30days(int between16and30days) {
		this.between16and30days = between16and30days;
	}

	public int getFrom31days() {
		return from31days;
	}

	public void setFrom31days(int from31days) {
		this.from31days = from31days;
	}

	@Override
	public String toString() {
		return "Discount [id=" + id + ", name=" + name + ", only1day=" + only1day + ", between2and7days="
				+ between2and7days + ", between8and15days=" + between8and15days + ", between16and30days="
				+ between16and30days + ", from31days=" + from31days + "]";
	}
}
