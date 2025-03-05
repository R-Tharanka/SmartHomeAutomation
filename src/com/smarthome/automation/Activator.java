package com.smarthome.automation;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> serviceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        AutomationService service = new AutomationServiceImpl();
        serviceRegistration = context.registerService(AutomationService.class.getName(), service, null);
        System.out.println("Automation Service Started.");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        serviceRegistration.unregister();
        System.out.println("Automation Service Stopped.");
    }
}
