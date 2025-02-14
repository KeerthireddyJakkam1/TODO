***********TASK**************
--> URL: https://todomvc.com/examples/react/dist/
AUT: https://todomvc.com/examples/react/dist/

User Story: As a user, I should be able to manage my todos effectively.
Acceptance Criteria (AC):
The candidate is required to design acceptance criteria (AC) appropriate for the given
user story and its scope.

Candidate&#39;s Task:
1. Create explicit acceptance criteria for the given user story.
2. Develop automation tests for the acceptance criteria using any preferred open-source
automation tool and programming language.
3. Upload the source code to a public repository on GitHub.
4. Provide clear instructions on how to run the tests.
5. Include a brief overview of your implementation strategy.

***********1.Acceptance Criteria**************
**Scenario 1**: Add and Verify New TODO Tasks
	• Given the user is on the TodoMVC app
	• When they type a **task** in the input field and press "Enter"
	• Then the new task should appear in the **All** todo list and **Active** todo list
**Scenario 2**: Mark and Verify TODO Completed Tasks
	• Given user is on the TodoMVC app and adds the Todo List **task**
	• When the user clicks on the checkbox next to the todo
	• Then the todo should be marked as completed and the user should see the Completed Todo on the **All** list and **Completed** List with Stricken 
**Scenario 3**: Filter tasks based on All Statuses
	• Given user is on the TodoMVC app
  • When a user adds the Todo List **task**
	• And the user marks the tasks as completed
  • And the user clear to complete tasks 
	• Then by toggling between the board's user can see the tasks accordingly
**Scenario 4**:  Clear Or Remove and Verify the Completed Tasks
	• Given user is on the TodoMVC app and adds the Todo List **task**
	• When the user clicks on the checkbox next to the todo 
 	• When the user clicks ClearCompleted Tasks
	• Then the user should not be able to see the Cleared tasks on the board 
 **Scenario 5**: Clear All and Verify ToDo List at once 
 	• Given user is on the TodoMVC app and adds the Todo List **task**
	• When the user clicks on the down arrow on the Search field
	• Then the user should be able to check all the tasks at once

 ***********2.Develop automation tests for the acceptance criteria using any preferred open-source
automation tool and programming language.**************
1. Here in this project I have used Katalon a Test Automation Platform to create and run the automated script

 ***********Instructions to Run the Scripts**************
1. Download the Katalon Studio
2. Clone and open the TODO_Project
3. Go to **TestSuite > Regression Suite**
4. Click on the **Run** button(Katalon will take chrome as default) 
5. Results can be seen in the Log Viewer
6. Readable Reports will be autogenerated in **Reports** folder 

****************Brief overview on implementation strategy**************
1. The Implementation is POM
2. Object Repositories are added under the Object Repositories folder under different page levels
3. Under Test cases there are Common test cases where we have written the reusable tcs/code
4. Main Test Cases where we will make use of Common test cases and build the functionality to test
5. All test data is parameterized using Variables, in real-time we use the Licensed version where which will use Excel sheets to store the test data.
   Which is not available in the open-source version so I have used the variables in the Main test case level to parameterize the tcs
6. I have gathered all the Main test cases as Regression Suite under TestSuite to run
7. Reports will be stored in the Reports folder
