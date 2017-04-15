package com.redhat.demo.iot.gateway.rules_cep;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.drools.core.time.SessionPseudoClock;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.EntryPoint;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.time.SessionClock;

public class CepServer {
    private static final Logger log = Logger.getLogger(CepServer.class.getName());
    private static final String CEP_STREAM = "IOTStream";

    private KieServices 	kieServices;
    private KieContainer 	kieContainer;
    private KieSession 		kieSession;
    
    public CepServer() {
    	initKieSession();
    }
    
    private void initKieSession() {
    	
    	kieServices = KieServices.Factory.get();
		
    	// Load KieContainer from resources on classpath (i.e. kmodule.xml and rules).
		kieContainer = kieServices.getKieClasspathContainer();

		// Initializing KieSession.
		kieSession = kieContainer.newKieSession();
    }
    
    public Dataset insert( Dataset event ) {
		SessionClock clock = kieSession.getSessionClock();
	
		SessionPseudoClock pseudoClock = (SessionPseudoClock) clock;
		EntryPoint ep = kieSession.getEntryPoint(CEP_STREAM);

		// First insert the fact
		FactHandle factHandle = ep.insert(event);
		
		// Now let's fire the rules
		kieSession.fireAllRules();

		// And then advance the clock
		// We only need to advance the time when dealing with Events. Our facts don't have timestamps.
		long advanceTime = 100;	// ?? need to make this more meaningfull

		pseudoClock.advanceTime(advanceTime, TimeUnit.MILLISECONDS);
		
		return event;
	}

}