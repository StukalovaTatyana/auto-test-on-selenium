package com.a1qa;

import com.a1qa.elements.IFrameElement;
import com.a1qa.pages.ElementsPage;
import com.a1qa.pages.MainPage;
import com.a1qa.utils.DriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TablesTest extends BaseTest {
    final static Logger LOGGER = Logger.getLogger(IFrameElement.class.toString());

    @Test
    public void tablesTest() {
        LOGGER.info("Opening main page");
        MainPage mainPage = new MainPage();
        DriverManager.openMainPage();
        assertTrue(mainPage.waitForPageToOpenAndCheckIfOpen(), "The main page does not open");

        LOGGER.info("Try to click on the 'Elements'");
        mainPage.clickElementsCard();
        ElementsPage elementsPage = new ElementsPage();
        assertTrue(elementsPage.waitForPageToOpenAndCheckIfOpen(), "The page with Web Tables does not open");

        LOGGER.info("Try to click on the 'Add'");
        elementsPage.clickWebTablesListElement();
        assertTrue(elementsPage.isTableDisplayed(),
                "The Registration Form does not appear on the page");

        LOGGER.info("Enter user data User. from the table and then click on the Submit button");
        elementsPage.clickAddButton();
        assertTrue(elementsPage.isFormDisplayed(), "The registration form is not closed");

        String firstName = "Jon";
        String lastName = "Snow";
        String email = "knownothing@gmail.com";
        int age = 30;
        int salary = 3000;
        String department = "alpha";
        elementsPage.fillForm(
                firstName,
                lastName,
                email,
                age,
                salary,
                department);
        elementsPage.clickSubmitButton();
        assertFalse(elementsPage.isFormDisplayed(), "User data does not appear in the table");

        List<String> tableRows = elementsPage.findTableRows();
        int sizeBeforeDelete = tableRows.size();
        String[] lastInsertedRow = tableRows.get(sizeBeforeDelete - 1).split("\n");
        assertEquals(lastInsertedRow.length, 6, "Not all fields are filled in");
        String[] testData = {firstName, lastName, String.valueOf(age), email, String.valueOf(salary), department};
        for (int i = 0; i < lastInsertedRow.length; i++) {
            assertEquals(lastInsertedRow[i], testData[i], "Incorrect data inserted");
        }

        LOGGER.info("Click on the Delete button in the user line User");
        elementsPage.clickDeleteButton();
        int sizeAfterDelete = elementsPage.findTableRows().size();
        assertTrue(sizeBeforeDelete > sizeAfterDelete,
                "The number of records in the table has not changed.");
    }
}
