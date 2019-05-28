Feature: InputFile Feature  
       
Scenario: validate that file contains the user details in the format OrderId,Location,OrderPlaceTime
          Given check if invalid orders get processed
          |wm001 878|
          Then The generated order list should not have invalid entries