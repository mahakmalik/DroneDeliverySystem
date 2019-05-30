Feature: Check create Order Method

Scenario: Validate if the system is able to create the order
          When Order details are given to order process method
          Then Order list should be created

Scenario: Validate if the system is unable to create the order
          When Invalid Order details are given to order process method
          Then Order list should result in error
          
Scenario: Validate if the system is unable to create the order
          When Invalid Order details are given to order process method
          Then Order list should result in error