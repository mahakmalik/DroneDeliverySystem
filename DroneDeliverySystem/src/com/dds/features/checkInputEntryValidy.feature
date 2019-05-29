Feature: Check to validate the syntax of order details present in the input file

Scenario: Diferrent order entries consisting invalid of orderId location and time should not be processed
         When Input file contains corrupted data
         Then The method should return false
         
Scenario: validate that file contains the user details in the format OrderId,Location,OrderPlaceTime
          Given check if invalid orders get processed
          Then The method should return false
          
Scenario: validate that method returns false when orderplaceTime is greater than 22:00:00
          Given the orderplacetime is after store close hours
          Then The method should return false