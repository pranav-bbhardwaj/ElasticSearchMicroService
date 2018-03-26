package org.testmicro.injection.guice;

import java.util.Properties;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ServiceGuice {

	private static Injector injector;
	
	
	public static void init(Properties props) {
		ServiceModule serviceModule = new ServiceModule(props);
		injector = Guice.createInjector(serviceModule);
	}

	public static Injector getInjector() {
		return injector;
	}

	public static void setInjector(Injector injector) {
		ServiceGuice.injector = injector;
	}
	
}
