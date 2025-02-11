import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.junit.Assert as Assert
import com.kms.katalon.core.testobject.ConditionType as ConditionType

int expectedTasks

/************ Finding out the active tasks**************/
if (taskType == 'active') {
    String[] activetasks = tasks.split(',')

    expectedTasks = activetasks.size()

    WebUI.click(findTestObject('TODO/CreateToDoTasks/allActiveCompletedButtons', [('taskType') : 'Active']))
} 
/************ Finding out the completed tasks**************/
else if (taskType == 'completed') {
    String[] completedtasks = tasks.split(',')

    expectedTasks = completedtasks.size()

    WebUI.click(findTestObject('TODO/CreateToDoTasks/allActiveCompletedButtons', [('taskType') : 'Completed']))
}
/************ Getting the no.of active/completed tasks**************/
TestObject dynamicObject = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//button[@data-testid=\'todo-item-button\']')

// Find all matching elements
List elements = WebUI.findWebElements(dynamicObject, 5)

int actualTasks = elements.size()

/************ Asserting the no.of active/completed tasks**************/

Assert.assertEquals(actualTasks, expectedTasks)