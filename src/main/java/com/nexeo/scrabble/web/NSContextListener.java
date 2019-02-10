package com.nexeo.scrabble.web;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.nexeo.scrabble.config.Configuration;
import com.nexeo.scrabble.utils.LogUtils;

public class NSContextListener extends ContextLoaderListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		LogUtils.start();
		
		LogUtils.debug("Loading configuration...");
		Configuration.load("nexeo.properties");
		
		super.contextInitialized(event);
		
		LogUtils.end();
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		LogUtils.start();
		Configuration.unload();
		super.contextDestroyed(event);
		LogUtils.end();
	}
}
