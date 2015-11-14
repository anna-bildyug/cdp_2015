package by.epam.tat.lecture2.task1.utils.exceptions;

@SuppressWarnings("serial")
public class ExceedCountSweetsExeption extends RuntimeException{
	private int maxCount;
	
	public ExceedCountSweetsExeption(int maxCount){
		this.maxCount = maxCount;
	}

	public String getMessage() {
		return "The gift includes maximum count of sweets:  " + maxCount
				+ ". You can't add new sweet";
	}

}
