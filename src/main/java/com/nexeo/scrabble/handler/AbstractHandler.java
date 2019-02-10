package com.nexeo.scrabble.handler;

import java.util.Locale;

public abstract class AbstractHandler {
	
	private Locale local;
	
	public Locale getLocale() {
		return local;
	}

	public void setLocale(Locale local) {
		this.local = local;
	} 
	
}
