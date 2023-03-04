Feature: API Workflow test

  Background: for generating the token before every requesr
     # to generate the token for all the request, we kept it in background
     Given a JWT is generated


  @api
  Scenario: API test case for creating the employee
    Given a request is prepared for creating the employee
    When a POST call is made to create an employee
    Then the status code for creating and employee is 201
    And the response body contain key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as global to be used for other request


  @api
  Scenario: Getting the created employee
    Given a request is prepared for getting a created employee
    When A GET call is made to get this employee
    Then the status code for this emp is 200
    And the employee id "employee.employee_id" should match with global emp id
    And the retrieved data at "employee" object should match with the data used for creating the employee
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |Reshad         |Gulzada        |ms             |Male    |1996-05-06  |confirmed |QA Engineer  |


  @api
  Scenario: API test case for creating the employee using json body
    Given a request is prepared for creating an employee by passing json body
    When a POST call is made to create an employee
    Then the status code for creating and employee is 201
    And the response body contain key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as global to be used for other request


  @apidynamic
  Scenario: API test case for creating the employee using dynamic body
    Given a request is prepared for creating an employee with dynamic data "Reshad" , "Gulzada" , "ms" , "M" , "1996-05-06" , "confirmed" , "QA Engineer"
    When a POST call is made to create an employee
    Then the status code for creating and employee is 201
    And the response body contain key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as global to be used for other request


  @apiupdate @upt
  Scenario: API test case for updating the employee dynamic body
    Given a request is prepared for updating an employee with dynamic data "51067A" , "Srosh" , "Gulzada" , "ms" , "M" , "2002-05-06" , "confirmed" , "Developer"
    When a PUT call is made to update an employee
    Then the status code for updating an employee is 200
    And the response body contain key "Message" and value "Employee record Updated"


  @apiGetUpdate @upt
  Scenario: API test case for getting the updated employee
    Given a request is prepared for getting a updated employee
    When A GET call is made to get this employee
    Then the status code for this emp is 200
    And the employee id "employee.employee_id" should match with global emp id
    And the retrieved data at "employee" object should match with the data used for updating the employee
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |Srosh         |Gulzada        |ms             |Male    |2002-05-06  |confirmed |Developer  |