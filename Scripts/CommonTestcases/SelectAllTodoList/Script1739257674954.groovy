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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

/************ Selecting all the tasks at once as completed*************/
WebUI.click(findTestObject('TODO/CreateToDoTasks/selectAllTasksToggle'))

String actualNoOfItems = WebUI.getText(findTestObject('TODO/CreateToDoTasks/getNo.OfItems'), FailureHandling.STOP_ON_FAILURE)

/*************Getting the list of Todo list from the ALL list************/

TestObject dynamicObjects = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//label[@data-testid=\'todo-item-label\']')

// Get all matching elements
List elements = WebUI.findWebElements(dynamicObjects, 5)

// Iterate
List texts = []

for (WebElement element : elements) {
    String text = element.getText()

    texts.add(text)
}


/**********Getting the list of Todo list from the Completed list**************/

WebUI.click(findTestObject('TODO/CreateToDoTasks/allActiveCompletedButtons', [('taskType') : 'Completed']))

TestObject dynamicObjects1 = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//label[@data-testid=\'todo-item-label\']')

// Get all matching elements
List elements1 = WebUI.findWebElements(dynamicObjects1, 5)

// Iterate 
List texts1 = []

for (WebElement element1 : elements1) {
    String text1 = element1.getText()

    texts1.add(text1)
}
 /******************Comparing two Lists*******************/
if (texts == texts1) {
    Assert.assertEquals(actualNoOfItems, '0 items left!')
}