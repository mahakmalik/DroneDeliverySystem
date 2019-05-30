## DroneDeliverySystem

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

The DroneDeliverySystem is a java project build using Eclipse IDE. Drone Delivery System is a tool to decide the schedule of orders. The tool maximizes the Net Promoter Score. The tool generates the list of delivery time for each order such that we can deliver the maximum orders within an hour of order place time.
The unit testing has been performed on the system using Cucumber and JUnit

# Prerequisites
- IDE that will run Java source Code
- use JRE 1.8
- download jar files for Cucumber, Gherkin and JUnit 4

# Tools
- Programming Language : Java & Gherkin
  The reason for using java is that it is an object oriented lannguage and offers automatic garbage collection.
  We can employ security rules using if block as we cannot bypass if block during code execution.
  Java source code can be run on any operating system.
  It is free of cost many frmaeworks such as Spring, NetBeans are available.
  Gherkin is used for writing test scenarios in cucumber.It is a plain english language and anyone can understand it.
  
 - IDE: Eclipse
 - Testing Tools: Cucumber & JUnit4
   Cucumber and JUnit offer a variety of options that make testing easier. Such as we can define a test scenario in cucumber using     Gherkin language and create a corresponding java file that will contain the source code for that scenario.
   It is easier to track and understand.
   various test annotations and assertions are available for testing the output of test method.
  
  
# Assumptions

-	The drone can carry only one packet at a time.
-	The operates between 6:00 am and 10:PM on 7 days a week
-	The list of orders is available before the execution of System.
-	The orders can be placed only between 5:30 am and 9:30 pm.
-	The drone shall not leave the warehouse before 6:00am
-	If the drone return time exceeds 10:00 PM then order shall not be processed.
-	The loading of drone takes only a minute.
-	There is no other delay caused by environmental factors such as rain, wind, or other calamities.
-	The drone is efficient and will not breakdown in middle of the delivery
- The drone has enough battery that it can carry out all the operations. 
-	Production like data required and be available in the system prior to start of Unit Testing
-	In each testing phase, Cycle 3 will be initiated if the defect rate is high in Cycle 2.

# Testing Documents
 
 - A requirement tracebility matrix(RTM) is created based on the requiremnets deduced from provided challenge question.
 - The Test Scenarios are mapped to the requirments specified in RTM.
 - Functional and Non-Functional Test Scenarios are created.
 - Test Cases are mapped to each Test Scenario.
 
 # Future Work
 
 - We can modify the code if more than one drone is used for operations
 - There should be a recovery mechanism for drone such that how shall we recover if a drone breaks down in the middle of a delivery
 - A validation check should be there that if a order location is far away from range of one warehouse then it should be diverted to a nearer warehouse.
 - A check for duplicate order id should also be done.
 - The unprocessed order should be added in the rejected list and should be printed out along with the output file.As it would help to validate which orders have been rejected and ifpossible can be corrected.
 - If a we based system is developed then we can use selenium in addition to already present test tools.
 
 # Flow Diagram 
![image](https://user-images.githubusercontent.com/51058934/58605131-c7af3680-8264-11e9-9976-5df51f5bc7ad.png)









