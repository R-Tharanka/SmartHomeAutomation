package com.smarthome.automation;

import java.util.HashMap;
import java.util.Map;

public class AutomationServiceImpl implements AutomationService {
    private final Map<String, String> rules = new HashMap<>();

    @Override
    public void createRule(String ruleName, String condition, String action) {
        rules.put(ruleName, "IF " + condition + " THEN " + action);
        System.out.println("Rule Created: " + rules.get(ruleName));
    }

    @Override
    public void deleteRule(String ruleName) {
        rules.remove(ruleName);
        System.out.println("Rule Deleted: " + ruleName);
    }

    @Override
    public void listRules() {
        System.out.println("Current Automation Rules:");
        rules.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
