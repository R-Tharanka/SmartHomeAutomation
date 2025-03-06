package com.smarthome.automation.subscriber;

import com.smarthome.automation.AutomationService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
    private ServiceReference<AutomationService> serviceReference;
    private AutomationService automationService;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Automation Subscriber Started.");
        
        serviceReference = context.getServiceReference(AutomationService.class);
        
        if (serviceReference != null) {
            automationService = context.getService(serviceReference);
            System.out.println("Automation Service Found!");

            // ✅ Call createRule() here instead of OSGi console
            automationService.createRule("Turn on Lights", "time=18:00", "turnOnLights()");
            automationService.listRules();
        } else {
            System.out.println("Automation Service NOT found.");
        }
    }


    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Automation Subscriber Stopped.");
        context.ungetService(serviceReference);
    }
}
