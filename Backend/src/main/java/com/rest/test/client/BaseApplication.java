package com.rest.test.client;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class BaseApplication extends Application {
	
	Set<Object> singleton = new HashSet<Object>();
	
	@Override
	public Set<Class<?>> getClasses() {
		return super.getClasses();
	}
	
	@Override
	public Set<Object> getSingletons() {
		singleton.add(new PostClient());
		return singleton;
	}

}