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

/************ Clearing the completed tasks**************/
String[] completedTasks = completedTasks.split(',')

for (def completedTask : completedTasks) {
    WebUI.click(findTestObject('TODO/CreateToDoTasks/allActiveCompletedButtons', [('taskType') : 'All']))

    WebUI.click(findTestObject('TODO/CreateToDoTasks/selectTask', [('taskType') : completedTask]))

    /************ Verify the completed tasks shouldnt be in Active Tasks*************/
    WebUI.click(findTestObject('TODO/CreateToDoTasks/allActiveCompletedButtons', [('taskType') : 'Active']))

    WebUI.verifyElementNotPresent(findTestObject('TODO/CompletedTasks/completedTasks', [('taskType') : completedTask]), 
        0)

    /************ Verify the completed tasks shoul be in Completed Tasks*************/
    WebUI.click(findTestObject('TODO/CreateToDoTasks/allActiveCompletedButtons', [('taskType') : 'Completed']))

    WebUI.verifyElementPresent(findTestObject('TODO/CompletedTasks/completedTasks', [('taskType') : completedTask]), 0)
}