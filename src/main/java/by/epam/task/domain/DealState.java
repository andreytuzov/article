package by.epam.task.domain;

public enum DealState {
	CREATED(1), CONFIRMED(2), PAID(3), CANCELED(4), DAMAGED(5), COMPLETED_SUCCESS(6), COMPLETED_DAMAGE(7),// state from database
	ACTIVE(3), FINISHED(3); // logical state

	private final int index;

	private DealState(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

}
