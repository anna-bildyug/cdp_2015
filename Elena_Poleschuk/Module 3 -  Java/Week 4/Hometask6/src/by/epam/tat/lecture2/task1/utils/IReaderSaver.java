package by.epam.tat.lecture2.task1.utils;

import java.util.List;

import by.epam.tat.lecture2.task1.objects.Gift;
import by.epam.tat.lecture2.task1.objects.Sweets;
import by.epam.tat.lecture2.task1.utils.exceptions.OpeningSavedCollectionException;

public interface IReaderSaver {
	void saveGift(Gift gitf);
	List<Sweets> getSavedGift() throws OpeningSavedCollectionException;
	
}
