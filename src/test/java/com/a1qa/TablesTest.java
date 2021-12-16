package com.a1qa;

import com.a1qa.pages.ElementsPage;
import com.a1qa.pages.MainPage;
import com.a1qa.utils.DriverManager;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TablesTest extends BaseTest {

    @Test
    public void tablesTest() {
        MainPage mainPage = new MainPage();
        DriverManager.openMainPage();
        assertTrue(mainPage.waitForPageToOpenAndCheckIfOpen(), "The main page does not open");

        mainPage.clickElementsCard();
        ElementsPage elementsPage = new ElementsPage();
        assertTrue(elementsPage.waitForPageToOpenAndCheckIfOpen(), "The page with Web Tables does not open");

        elementsPage.clickWebTablesListElement();
        assertTrue(elementsPage.isTableDisplayed(),
                "The Registration Form does not appear on the page");

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
        elementsPage.clickDeleteButton();
        int sizeAfterDelete = elementsPage.findTableRows().size();
        assertTrue(sizeBeforeDelete > sizeAfterDelete,
                "The number of records in the table has not changed.");
    }
}
