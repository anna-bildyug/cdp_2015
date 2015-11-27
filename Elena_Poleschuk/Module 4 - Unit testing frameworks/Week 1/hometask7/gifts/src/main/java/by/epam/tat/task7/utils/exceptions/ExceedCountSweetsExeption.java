package by.epam.tat.task7.utils.exceptions;

@SuppressWarnings("serial")
public class ExceedCountSweetsExeption extends Exception {
	private int maxCount;

	public ExceedCountSweetsExeption(int maxCount) {
		this.maxCount = maxCount;
	}

	public String getMessage() {
		return "You are trying to add more sweets then possible. The gift can includes " + maxCount + " sweets ";
	}

}
