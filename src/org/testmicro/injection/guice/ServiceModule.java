package org.testmicro.injection.guice;

import java.util.Properties;

import org.testmicro.analytics.processor.ISearchProcessor;
import org.testmicro.analytics.processor.SearchProcessorImpl;
import org.testmicro.analytics.store.IStore;
import org.testmicro.analytics.store.elasticcache.ElasticCacheStore;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;


public class ServiceModule extends AbstractModule {
	
	private Properties props;
	public ServiceModule(Properties props) {
		this.props = props;
	}
	  @Override 
	  protected void configure() {
		  try {
              Names.bindProperties(binder(), props);
          } catch (Exception e) {
              System.out.println("Could not load config: " + e);
              System.exit(1);
          }
	     /*
	      * bindings
	      */
	    bind(ISearchProcessor.class).to(SearchProcessorImpl.class).asEagerSingleton();
	    
	    bind(IStore.class).to(ElasticCacheStore.class).asEagerSingleton();

	  }
	}