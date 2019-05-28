## DroneDeliverySystem

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

The DroneDeliverySystem is a java project build using Eclipse IDE. Drone Delivery System is a tool to decide the schedule of orders. The tool maximizes the Net Promoter Score. The tool generates the list of delivery time for each order such that we can deliver the maximum orders within an hour of order place time.
The unit testing has been perdormed on the system using Cucumber and JUnit

# Prerequisites
- IDE that will run Java source Code
- use JRE 1.8
- download jar files for Cucumber, Gherkin and JUnit 4

# Assumptions

-	The drone can carry only one packet at a time.
-	The operates between 6:00 am and 10:PM on 7 days a week
-	The list of orders is available before the execution of System.
-	The orders can be placed only between 5:30 am and 9:30 pm.
-	The drone shall not leave the warehouse before 6:00am
-	If the drone return time exceeds 10:00 PM then order shall not be processed.
-	The loading of drone takes only a minute.
-	There is no other delay caused by environmental factors such as rain, wind, or other calamities.
-	The drone is efficient and will not breakdown in middle of the delivery.
-	Production like data required and be available in the system prior to start of Unit Testing
-	In each testing phase, Cycle 3 will be initiated if the defect rate is high in Cycle 2.









