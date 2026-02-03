package com.bigmarket.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Marketing strategy for managing campaign goals
 */
public class MarketingStrategy {
    private String strategyId;
    private String name;
    private String description;
    private List<CampaignGoal> goals;

    public MarketingStrategy(String strategyId, String name, String description) {
        this.strategyId = strategyId;
        this.name = name;
        this.description = description;
        this.goals = new ArrayList<>();
    }

    public void addGoal(CampaignGoal goal) {
        goals.add(goal);
    }

    public void removeGoal(String goalId) {
        goals.removeIf(goal -> goal.getId().equals(goalId));
    }

    public CampaignGoal getGoal(String goalId) {
        return goals.stream()
                .filter(goal -> goal.getId().equals(goalId))
                .findFirst()
                .orElse(null);
    }

    public List<CampaignGoal> getAllGoals() {
        return new ArrayList<>(goals);
    }

    public List<CampaignGoal> getAchievedGoals() {
        return goals.stream()
                .filter(CampaignGoal::isAchieved)
                .collect(Collectors.toList());
    }

    public List<CampaignGoal> getPendingGoals() {
        return goals.stream()
                .filter(goal -> !goal.isAchieved())
                .collect(Collectors.toList());
    }

    public double getOverallProgress() {
        if (goals.isEmpty()) {
            return 0.0;
        }
        double totalProgress = goals.stream()
                .mapToDouble(CampaignGoal::getProgress)
                .sum();
        return totalProgress / goals.size();
    }

    public String getStrategyId() {
        return strategyId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "MarketingStrategy{" +
                "strategyId='" + strategyId + '\'' +
                ", name='" + name + '\'' +
                ", totalGoals=" + goals.size() +
                ", achievedGoals=" + getAchievedGoals().size() +
                ", overallProgress=" + String.format("%.2f", getOverallProgress()) + "%" +
                '}';
    }
}
