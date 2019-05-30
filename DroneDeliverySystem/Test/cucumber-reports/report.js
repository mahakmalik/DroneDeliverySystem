$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CheckInputEntryValidity.feature");
formatter.feature({
  "line": 1,
  "name": "Check to validate the syntax of order details present in the input file",
  "description": "",
  "id": "check-to-validate-the-syntax-of-order-details-present-in-the-input-file",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Diferrent order entries consisting invalid of orderId location and time should not be processed",
  "description": "",
  "id": "check-to-validate-the-syntax-of-order-details-present-in-the-input-file;diferrent-order-entries-consisting-invalid-of-orderid-location-and-time-should-not-be-processed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Input file contains corrupted data",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "The method should return false",
  "keyword": "Then "
});
formatter.match({
  "location": "CheckInputEntryValidity.Input_File_contains_corrupted_data()"
});
formatter.result({
  "duration": 106405455,
  "status": "passed"
});
formatter.match({
  "location": "CheckInputEntryValidity.the_generated_order_list_should_not_have_invalid_entries()"
});
formatter.result({
  "duration": 18204,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "validate that file contains the user details in the format OrderId,Location,OrderPlaceTime",
  "description": "",
  "id": "check-to-validate-the-syntax-of-order-details-present-in-the-input-file;validate-that-file-contains-the-user-details-in-the-format-orderid,location,orderplacetime",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "check if invalid orders get processed",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "The method should return false",
  "keyword": "Then "
});
formatter.match({
  "location": "CheckInputEntryValidity.a_valid_input_file_with_invalid_entries()"
});
formatter.result({
  "duration": 42097,
  "status": "passed"
});
formatter.match({
  "location": "CheckInputEntryValidity.the_generated_order_list_should_not_have_invalid_entries()"
});
formatter.result({
  "duration": 17636,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "validate that method returns false when orderplaceTime is greater than 22:00:00",
  "description": "",
  "id": "check-to-validate-the-syntax-of-order-details-present-in-the-input-file;validate-that-method-returns-false-when-orderplacetime-is-greater-than-22:00:00",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "the orderplacetime is after store close hours",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "The method should return false",
  "keyword": "Then "
});
formatter.match({
  "location": "CheckInputEntryValidity.when_orderplaceTime_is_after_store_close_hours()"
});
formatter.result({
  "duration": 49813006,
  "status": "passed"
});
formatter.match({
  "location": "CheckInputEntryValidity.the_generated_order_list_should_not_have_invalid_entries()"
});
formatter.result({
  "duration": 14223,
  "status": "passed"
});
formatter.uri("ValidateBufferedToArrayListMethod.feature");
formatter.feature({
  "line": 1,
  "name": "InputFile Feature",
  "description": "",
  "id": "inputfile-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Validate if the system throws error when input file path is invalid",
  "description": "",
  "id": "inputfile-feature;validate-if-the-system-throws-error-when-input-file-path-is-invalid",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "incorrect input file path is entered",
  "rows": [
    {
      "cells": [
        "\\user\\input.txt"
      ],
      "line": 5
    },
    {
      "cells": [
        "C:\\Users\\mahak\\git\\DroneDeliverySystem\\DroneDeliverySystem\\src\\InputFileRows.jpg"
      ],
      "line": 6
    },
    {
      "cells": [
        "C:\\Users\\mahak\\git\\DroneDeliverySystem\\DroneDeliverySystem\\src\\InputFileRows.txt.$buffer"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "File not found exception should be thrown",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidateBufferedToArrayListMethod.incorrect_input_file_path_is_entered(DataTable)"
});
formatter.result({
  "duration": 2833064,
  "status": "passed"
});
formatter.match({
  "location": "ValidateBufferedToArrayListMethod.file_not_found_exception_should_be_thrown()"
});
formatter.result({
  "duration": 21618,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Validate if the system processes the input file when input file path is valid",
  "description": "",
  "id": "inputfile-feature;validate-if-the-system-processes-the-input-file-when-input-file-path-is-valid",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "correct input file path is entered",
  "rows": [
    {
      "cells": [
        "C:\\Users\\mahak\\git\\DroneDeliverySystem\\DroneDeliverySystem\\Resources\\InputFileRows.txt"
      ],
      "line": 13
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "File not found exception should not be thrown",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidateBufferedToArrayListMethod.correct_input_file_path_is_entered(DataTable)"
});
formatter.result({
  "duration": 14957782,
  "status": "passed"
});
formatter.match({
  "location": "ValidateBufferedToArrayListMethod.file_not_found_exception_should__not_be_thrown()"
});
formatter.result({
  "duration": 15928,
  "status": "passed"
});
formatter.uri("ValidateCalculateNPSScore.feature");
formatter.feature({
  "line": 1,
  "name": "Check to validate that NPS Score is calculated correctly",
  "description": "",
  "id": "check-to-validate-that-nps-score-is-calculated-correctly",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "promotors and detractors are updated according to the dispatch time",
  "description": "",
  "id": "check-to-validate-that-nps-score-is-calculated-correctly;promotors-and-detractors-are-updated-according-to-the-dispatch-time",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Order details and dispatch time are passed",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "The promoter should be incremented according to time elapsed",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "Or the detractor should be incremented according to time elapsed",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Total processedorder should be incremented",
  "keyword": "And "
});
formatter.match({
  "location": "ValidateCalculateNPSScore.orderdetails_and_dispatchtime_is_provided_delivery_method()"
});
formatter.result({
  "duration": 262258,
  "status": "passed"
});
formatter.match({
  "location": "ValidateCalculateNPSScore.validate_calculated_promoters()"
});
formatter.result({
  "duration": 25600,
  "status": "passed"
});
formatter.match({
  "location": "ValidateCalculateNPSScore.validate_calculated_detractors()"
});
formatter.result({
  "duration": 17067,
  "status": "passed"
});
formatter.match({
  "location": "ValidateCalculateNPSScore.validate_calculated_totalprocessedorder()"
});
formatter.result({
  "duration": 18773,
  "status": "passed"
});
formatter.uri("ValidateCreateOrderList.feature");
formatter.feature({
  "line": 1,
  "name": "Check create Order Method",
  "description": "",
  "id": "check-create-order-method",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Validate if the system is able to create the order",
  "description": "",
  "id": "check-create-order-method;validate-if-the-system-is-able-to-create-the-order",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Order details are given to order process method",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "Order list should be created",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidateCreateOrderList.inputOrderParameters()"
});
formatter.result({
  "duration": 141085,
  "status": "passed"
});
formatter.match({
  "location": "ValidateCreateOrderList.order_list_should_be_created()"
});
formatter.result({
  "duration": 31289,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Validate if the system is unable to create the order",
  "description": "",
  "id": "check-create-order-method;validate-if-the-system-is-unable-to-create-the-order",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "Invalid Order details are given to order process method",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Order list should result in error",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidateCreateOrderList.invalid_inputOrderParameters()"
});
formatter.result({
  "duration": 351004,
  "status": "passed"
});
formatter.match({
  "location": "ValidateCreateOrderList.order_list_should_not_be_created()"
});
formatter.result({
  "duration": 25600,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Validate if the system is unable to create the order",
  "description": "",
  "id": "check-create-order-method;validate-if-the-system-is-unable-to-create-the-order",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "Invalid Order details are given to order process method",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Order list should result in error",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidateCreateOrderList.invalid_inputOrderParameters()"
});
formatter.result({
  "duration": 192284,
  "status": "passed"
});
formatter.match({
  "location": "ValidateCreateOrderList.order_list_should_not_be_created()"
});
formatter.result({
  "duration": 34702,
  "status": "passed"
});
formatter.uri("ValidateReturnTimeAndDeliveryTime.feature");
formatter.feature({
  "line": 1,
  "name": "Validate the delivery time and retuirn time formula is correct",
  "description": "",
  "id": "validate-the-delivery-time-and-retuirn-time-formula-is-correct",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "validate the calculated deliverytime matches the output",
  "description": "",
  "id": "validate-the-delivery-time-and-retuirn-time-formula-is-correct;validate-the-calculated-deliverytime-matches-the-output",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Orderdetails and curr dispatch time is provided to deliverytime method",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "delivery time must be calculated",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidateReturnTimeAndDeliveryTime.orderdetails_and_dispatchtime_is_provided_delivery_method()"
});
formatter.result({
  "duration": 288995,
  "status": "passed"
});
formatter.match({
  "location": "ValidateReturnTimeAndDeliveryTime.validate_calculated_deliverytime()"
});
formatter.result({
  "duration": 113209,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "validate the calculated returntime matches the output",
  "description": "",
  "id": "validate-the-delivery-time-and-retuirn-time-formula-is-correct;validate-the-calculated-returntime-matches-the-output",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "Orderdetails and curr dispatch time is provided to returntime method",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "return time must be calculated",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidateReturnTimeAndDeliveryTime.orderdetails_and_dispatchtime_is_provided_to_return_method()"
});
formatter.result({
  "duration": 267377,
  "status": "passed"
});
formatter.match({
  "location": "ValidateReturnTimeAndDeliveryTime.validate_calculated_returntime()"
});
formatter.result({
  "duration": 125155,
  "status": "passed"
});
});