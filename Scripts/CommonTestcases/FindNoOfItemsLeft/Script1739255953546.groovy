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
/*************Getting the no.of Items list in Completed Page*****************/
WebUI.click(findTestObject('TODO/CreateToDoTasks/allActiveCompletedButtons', [('taskType') : 'Completed']))

TestObject dynamicObject1 = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//button[@data-testid=\'todo-item-button\']')

List elements1 = WebUI.findWebElements(dynamicObject1, 5)

int actualcompletedTasks = elements1.size()

/*************Getting the no.of Items list in All tasks Page*****************/
WebUI.click(findTestObject('TODO/CreateToDoTasks/allActiveCompletedButtons', [('taskType') : 'All']))

TestObject dynamicObject2 = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//button[@data-testid=\'todo-item-button\']')

List elements2 = WebUI.findWebElements(dynamicObject2, 5)

int actualactiveTasks = elements2.size()

/*************Subtracting the no.of Items list from active tasks to completed to get active tasks number*****************/
int remainingItems = actualactiveTasks - actualcompletedTasks

String expectedRemainingItems

if (remainingItems == 1) {
    expectedRemainingItems = (remainingItems + ' item left!')
} else {
    expectedRemainingItems = (remainingItems + ' items left!')
}

String actualRemainingItems = WebUI.getText(findTestObject('TODO/CreateToDoTasks/getNo.OfItems'), FailureHandling.STOP_ON_FAILURE)

/*************Asserting the remaining items we get from the script to the from the UI*****************/
Assert.assertEquals(actualRemainingItems, expectedRemainingItems)