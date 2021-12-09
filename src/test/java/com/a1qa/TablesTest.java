package com.a1qa;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TablesTest extends BaseTest {

    @Test
    public void tablesTest() throws InterruptedException {
        mainPage.openMainPage();
        assertTrue(mainPage.isPageOpened());

        mainPage.clickElementsCard();
        assertTrue(elementsPage.isPageOpened());

        elementsPage.clickWebTablesListElement();
        assertTrue(elementsPage.isTableDisplayed());

        elementsPage.clickAddButton();
        assertTrue(elementsPage.isFormDisplayed());

        // 1	Jon	Snow	knownothing@gmail.com	30	3000	alpha
        // 2	Buttercup	Cumbersnatch	BudapestCandygram@mail.ru	41	2000	beta
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
        assertFalse(elementsPage.isFormDisplayed());

        List<String> tableRows = elementsPage.findTableRows();
        int sizeBeforeDelete = tableRows.size();
        String[] lastInsertedRow = tableRows.get(sizeBeforeDelete - 1).split("\n");
        assertEquals(lastInsertedRow.length, 6);
        String[] testData = {firstName, lastName, String.valueOf(age), email, String.valueOf(salary), department};
        for (int i = 0; i < lastInsertedRow.length; i++) {
            assertEquals(lastInsertedRow[i], testData[i]);
        }
        elementsPage.clickDeleteButton();
        int sizeAfterDelete = elementsPage.findTableRows().size();
        assertTrue(sizeBeforeDelete > sizeAfterDelete);
    }
}
