package by.epam.cdp.java.nypresent.storage;

import java.io.IOException;

import by.epam.cdp.java.nypresent.Present;
import by.epam.cdp.java.nypresent.validation.NoSuchCandyException;
import by.epam.cdp.java.nypresent.validation.PresentStorageException;

public interface IOStreams {
	
	String importPresent () throws PresentStorageException;	
	void exportPresent (Present present) throws PresentStorageException;
	
}
