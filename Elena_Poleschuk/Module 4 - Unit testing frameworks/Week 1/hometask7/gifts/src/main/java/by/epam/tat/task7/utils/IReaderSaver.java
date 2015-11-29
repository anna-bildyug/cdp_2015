package by.epam.tat.task7.utils;

import java.util.List;

import by.epam.tat.task7.objects.Gift;
import by.epam.tat.task7.objects.Sweets;
import by.epam.tat.task7.utils.exceptions.OpeningSavedCollectionException;

public interface IReaderSaver {
	void saveGift(Gift gift);

	List<Sweets> getSavedGift() throws OpeningSavedCollectionException;

}
