package by.epam.task.domain;

public enum Role {
	ANONYMOUS(0), ADMIN(1), CUSTOMER(2);

	private final int index;

	Role(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
