package com.epam.by.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogSaver {

	static private Logger logger;

	private LogSaver() {
	}

	public static Logger getLogger() {
		if (logger == null) {
			logger = LogManager.getRootLogger();
		}
		return logger;
	}
}
