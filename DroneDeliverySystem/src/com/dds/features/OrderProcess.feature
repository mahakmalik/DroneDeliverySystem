Feature: InputFile Feature

Scenario: Validate if the system is able to create the order
          Given A system is source code is available
          When Order details are given to order process method
          Then Order list should be created
          
