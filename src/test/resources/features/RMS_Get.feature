@RMS_API_Test
Feature: Verify GET Operation for Radio and Music API service

  Background:
    Given the base URI is "https://testapi.io/"

  Scenario Outline: : Verify RMS API return successful response
    When user send a GET request to "<api_name>"
    Then the response status code should be <status_code> and reason  "<status_reason>"
    And the response time of the request is below <response_time> milliseconds
    Examples:
      | api_name          | status_code | status_reason   | response_time |
      | api/rmstest/media | 200         | HTTP/1.1 200 OK | 1000         |


  Scenario Outline: : Verify RMS API id and segment_type field is never null or empty and segment_type is music
    When user send a GET request to "<api_name>"
    Then the response status code should be <status_code> and reason  "<status_reason>"
    And the id field is never null or empty for all the items in array
    And the segment_type field is always "<segment_type>"
    Examples:
      | api_name          | status_code | status_reason   | segment_type |
      | api/rmstest/media | 200         | HTTP/1.1 200 OK | music        |


  Scenario Outline: : Verify RMS API primary  field in title_list is never null or empty
    When user send a GET request to "<api_name>"
    Then the response status code should be <status_code> and reason  "<status_reason>"
    And the primary field in title_list is never null or empty for any track
    Examples:
      | api_name          | status_code | status_reason   |
      | api/rmstest/media | 200         | HTTP/1.1 200 OK |

  Scenario Outline: : Verify that only one track in the list has now_playing field in offset as true
    When user send a GET request to "<api_name>"
    Then the response status code should be <status_code> and reason  "<status_reason>"
    And only one track in the list has now_playing field in offset as true
    Examples:
      | api_name          | status_code | status_reason   |
      | api/rmstest/media | 200         | HTTP/1.1 200 OK |


  Scenario Outline: : Verify the response headers Date value
    When user send a GET request to "<api_name>"
    Then the response status code should be <status_code> and reason  "<status_reason>"
    And  response headers should have date value
    Examples:
      | api_name          | status_code | status_reason   |
      | api/rmstest/media | 200         | HTTP/1.1 200 OK |



