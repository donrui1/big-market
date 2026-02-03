# Big Marketing Platform (大营销)

A comprehensive marketing campaign management platform for creating and tracking marketing strategies and campaign goals.

## Features

- **Marketing Strategy Management**: Create and manage marketing strategies
- **Campaign Goals**: Define and track multiple campaign goals with different types
- **Progress Tracking**: Monitor goal progress and achievement status
- **Goal Types**: Support for various goal types including:
  - Conversion goals
  - Engagement goals
  - Reach goals
  - Revenue goals

## Project Structure

```
big-market/
├── src/main/java/com/bigmarket/
│   ├── BigMarketApplication.java
│   └── strategy/
│       ├── CampaignGoal.java
│       └── MarketingStrategy.java
├── pom.xml
└── README.md
```

## Building the Project

This project uses Maven. To build:

```bash
mvn clean compile
```

## Running the Application

```bash
mvn exec:java -Dexec.mainClass="com.bigmarket.BigMarketApplication"
```

Or after compiling:

```bash
java -cp target/classes com.bigmarket.BigMarketApplication
```

## Usage Example

```java
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

strategy.addGoal(conversionGoal);

// Update progress
conversionGoal.updateProgress(750.0);

// Check status
System.out.println("Progress: " + conversionGoal.getProgress() + "%");
System.out.println("Achieved: " + conversionGoal.isAchieved());
```

## Requirements

- Java 11 or higher
- Maven 3.6 or higher