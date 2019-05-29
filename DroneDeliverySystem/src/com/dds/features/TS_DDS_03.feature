Feature: NPS Score Calculator Feature  
       
Scenario: validate that NPS Score Calculator calculates time elapsed correctly
          Given <order details>, <current dispatch time> and <orderdeliverytime> are passed
           | order details| current dispatch time | order delivery time |
          |    mock      |   LocalTime.parse("6:00:00") | LocalTime.parse("7:00:00") |
          Then The timeelpased should calculate the correct time diferrence
         
          
Scenario: validate that method increments the promoters and demoter score
          Given <order details>, <current dispatch time> and <orderdeliverytime> are passed
          | order details| current dispatch time | order delivery time |
          |    mock      |   LocalTime.parse("6:00:00") | LocalTime.parse("7:00:00") |
          When time elpased is less than 120 min 
          Then promoter should be incremented
          When time elpased is greater than 120 min 
          Then detractor should get incremented
          
          
          
          