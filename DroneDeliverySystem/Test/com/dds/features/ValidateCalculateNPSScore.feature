Feature: Check to validate that NPS Score is calculated correctly

Scenario: promotors and detractors are updated according to the dispatch time
         When Order details and dispatch time are passed
         Then The promoter should be incremented according to time elapsed
         Then Or the detractor should be incremented according to time elapsed
         And Total processedorder should be incremented