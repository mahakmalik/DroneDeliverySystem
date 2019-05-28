Feature: InputFile Feature

Scenario: Validate if the system is able to create the order
          Given A system is source code is available
          When Order details are given to order process method
          Then Order list should be created
          
Scenario: Validate if the System is not able to access the input File
          Given A invalid input file path
          |"\\user\\InputFileRows.txt"  |
          |""|
          Then A error should pop
 
Scenario: Validate if the System is able to access the input File
          Given A valid input file path
          |C:\\Users\\mahak\\git\\DroneDeliverySystem\\DroneDeliverySystem\\src\\InputFileRows.txt|
          Then orderlist should be created  
          
      
