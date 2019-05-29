Feature: InputFile Feature

Scenario: Validate if the system throws error when input file path is invalid
          When incorrect input file path is entered
          |\\user\\input.txt|
          |C:\\Users\\mahak\\git\\DroneDeliverySystem\\DroneDeliverySystem\\src\\InputFileRows.jpg|
          |C:\\Users\\mahak\\git\\DroneDeliverySystem\\DroneDeliverySystem\\src\\InputFileRows.txt.$buffer|
          Then File not found exception should be thrown
          
        
 Scenario: Validate if the system processes the input file when input file path is valid
          When correct input file path is entered
          |C:\Users\mohan\git\DroneDeliverySystem\DroneDeliverySystem\src\InputFileRows.txt|
          Then File not found exception should not be thrown        