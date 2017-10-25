package by.epam.task.domain;

public enum DealState {
	CREATED(1), CONFIRMED(2), PAID(3), CANCELED(4), DAMAGED(5), COMPLETED(6);

	private final int index;

	private DealState(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

}
