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


/************ Clearing the completed tasks**************/
WebUI.click(findTestObject('TODO/CompletedTasks/clearCompletedButton'))

for (def completedTask : completedTasks) {
/************ Verify the cleared tasks shouldnt be in Completed Tasks**************/
WebUI.click(findTestObject('TODO/CreateToDoTasks/allActiveCompletedButtons', [('taskType') : 'Completed']))

WebUI.verifyElementNotPresent(findTestObject('TODO/CompletedTasks/completedTasks', [('taskType') : completedTasks]), 0)

/************ Verify the cleared tasks shouldnt be in Active Tasks**************/
WebUI.click(findTestObject('TODO/CreateToDoTasks/allActiveCompletedButtons', [('taskType') : 'Active']))

WebUI.verifyElementNotPresent(findTestObject('TODO/CompletedTasks/completedTasks', [('taskType') : completedTasks]), 0)

/************ Verify the cleared tasks shouldnt be in ALL Tasks**************/
WebUI.click(findTestObject('TODO/CreateToDoTasks/allActiveCompletedButtons', [('taskType') : 'All']))

WebUI.verifyElementNotPresent(findTestObject('TODO/CompletedTasks/completedTasks', [('taskType') : completedTasks]), 0)
}