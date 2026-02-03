package com.bigmarket;

import com.bigmarket.strategy.CampaignGoal;
import com.bigmarket.strategy.MarketingStrategy;

/**
 * Main application for Big Marketing Platform
 */
public class BigMarketApplication {
    
    public static void main(String[] args) {
        System.out.println("=== Big Marketing Platform ===");
        System.out.println();
        
        // Create a marketing strategy
        MarketingStrategy strategy = new MarketingStrategy(
            "STRAT-001",
            "Q1 2026 Marketing Campaign",
            "Comprehensive marketing strategy for Q1 2026"
        );
        
        // Add campaign goals
        CampaignGoal conversionGoal = new CampaignGoal(
            "GOAL-001",
            "Increase Conversions",
            "Increase conversion rate by 20%",
            CampaignGoal.GoalType.CONVERSION,
            1000.0
        );
        
        CampaignGoal engagementGoal = new CampaignGoal(
            "GOAL-002",
            "Boost Engagement",
            "Increase user engagement metrics",
            CampaignGoal.GoalType.ENGAGEMENT,
            5000.0
        );
        
        CampaignGoal revenueGoal = new CampaignGoal(
            "GOAL-003",
            "Revenue Target",
            "Achieve revenue target of $50K",
            CampaignGoal.GoalType.REVENUE,
            50000.0
        );
        
        strategy.addGoal(conversionGoal);
        strategy.addGoal(engagementGoal);
        strategy.addGoal(revenueGoal);
        
        // Display initial strategy
        System.out.println("Marketing Strategy Created:");
        System.out.println(strategy);
        System.out.println();
        
        // Simulate progress updates
        System.out.println("Updating campaign progress...");
        conversionGoal.updateProgress(750.0);
        engagementGoal.updateProgress(5500.0);
        revenueGoal.updateProgress(35000.0);
        
        System.out.println();
        System.out.println("Current Goals Status:");
        for (CampaignGoal goal : strategy.getAllGoals()) {
            System.out.println("  " + goal);
        }
        
        System.out.println();
        System.out.println("Strategy Summary:");
        System.out.println("  Total Goals: " + strategy.getAllGoals().size());
        System.out.println("  Achieved Goals: " + strategy.getAchievedGoals().size());
        System.out.println("  Pending Goals: " + strategy.getPendingGoals().size());
        System.out.println("  Overall Progress: " + String.format("%.2f", strategy.getOverallProgress()) + "%");
    }
}
