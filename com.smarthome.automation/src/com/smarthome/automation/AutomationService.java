
package com.smarthome.automation;


public interface AutomationService {
    void createRule(String ruleName, String condition, String action);
    void deleteRule(String ruleName);
    void listRules();
}
