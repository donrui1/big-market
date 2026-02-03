package com.bigmarket.strategy;

/**
 * Represents a marketing campaign goal
 */
public class CampaignGoal {
    private String id;
    private String name;
    private String description;
    private GoalType type;
    private double targetValue;
    private double currentValue;

    public enum GoalType {
        CONVERSION,
        ENGAGEMENT,
        REACH,
        REVENUE
    }

    public CampaignGoal(String id, String name, String description, GoalType type, double targetValue) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.targetValue = targetValue;
        this.currentValue = 0.0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public GoalType getType() {
        return type;
    }

    public double getTargetValue() {
        return targetValue;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void updateProgress(double value) {
        this.currentValue = value;
    }

    public double getProgress() {
        if (targetValue == 0) {
            return 0.0;
        }
        return (currentValue / targetValue) * 100.0;
    }

    public boolean isAchieved() {
        return currentValue >= targetValue;
    }

    @Override
    public String toString() {
        return "CampaignGoal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", progress=" + String.format("%.2f", getProgress()) + "%" +
                ", achieved=" + isAchieved() +
                '}';
    }
}
