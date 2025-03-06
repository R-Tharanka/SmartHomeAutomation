package com.smarthome.automation;
import com.smarthome.automation.db.DBConnect;

import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutomationServiceImpl implements AutomationService {
    private final Map<String, String> rules = new HashMap<>();

    @Override
    public void createRule(String ruleName, String condition, String action) {
        String sql = "INSERT INTO AutomationRules (rule_name, condition_text, action_text) VALUES (?, ?, ?)";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ruleName);
            stmt.setString(2, condition);
            stmt.setString(3, action);
            stmt.executeUpdate();
            System.out.println("Rule Created: " + ruleName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteRule(String ruleName) {
        rules.remove(ruleName);
        System.out.println("Rule Deleted: " + ruleName);
    }

    @Override
    public void listRules() {
        String sql = "SELECT * FROM AutomationRules";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Current Automation Rules:");
            while (rs.next()) {
                System.out.println(rs.getString("rule_name") + " => IF " +
                        rs.getString("condition_text") + " THEN " + rs.getString("action_text"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
