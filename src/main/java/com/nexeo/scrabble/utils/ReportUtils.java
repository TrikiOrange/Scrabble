package com.nexeo.scrabble.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.nexeo.scrabble.message.ReportLine;

@Component
public class ReportUtils {

	@Autowired
	private MessageSource messageSource;

	private ReportLine buildReportLine(String errorLevel, String code, String messageCode, Object[] args,
			Locale locale) {
		String message = messageSource.getMessage(messageCode, args, locale);
		return new ReportLine(errorLevel, code, message);
	}

	public void addReportLine(String errorLevel, String code, String messageCode, Object[] args, Locale locale) {
		buildReportLine(errorLevel, code, messageCode, args, locale);
	}

}
