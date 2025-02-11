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

WebUI.click(findTestObject('TODO/Login/searchField'))

String[] tasks = tasks.split(',')

/************ Adding the tasks**************/

for (int i = 0; i < tasks.size(); i++) {
	
    WebUI.setText(findTestObject('TODO/Login/searchField'), tasks[i])

    WebUI.sendKeys(findTestObject('TODO/Login/searchField'), Keys.chord(Keys.ENTER))
    
    if (i == 0) {
        WebUI.verifyElementPresent(findTestObject('TODO/CreateToDoTasks/no.OfItemsLeft', [('itemsLeft') : '1 item left!']), 
            0)
    } else {
        WebUI.verifyElementPresent(findTestObject('TODO/CreateToDoTasks/no.OfItemsLeft', [('itemsLeft') :(i+1)+' items left!']), 
            0)
    }
}