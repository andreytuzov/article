package by.epam.task.domain;

public enum DealState {
	CREATED(1), CONFIRMED(2), CANCELED(3), DAMAGED(4), COMPLETED(5);

	private final int index;

	private DealState(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

}
