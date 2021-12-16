package com.a1qa.pages;

import com.a1qa.elements.*;
import com.a1qa.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ElementsPage extends BaseForm {
    private final ListItemElement webTablesElement = new ListItemElement(
            By.xpath("//div[@class ='element-list collapse show']//ul//li[@id='item-3']"), "webTablesElement");
    private final TableElement tableElement = new TableElement(
            By.xpath("//div[@class='rt-table']"), "tableElement");
    private final ButtonElement addButton = new ButtonElement(
            By.xpath("//button[@id='addNewRecordButton']"), "addButton");
    private final TextElement formElement = new TextElement(
            By.xpath("//div[@class='modal-content']"), "formElement");
    private final InputElement firstNameElement = new InputElement(
            By.xpath("//div[@id='firstName-wrapper']//input"), "firstName");
    private final InputElement lastNameElement = new InputElement(
            By.xpath("//div[@id='lastName-wrapper']//input"), "lastName");
    private final InputElement emailElement = new InputElement(
            By.xpath("//div[@id='userEmail-wrapper']//input"), "email");
    private final InputElement ageElement = new InputElement(
            By.xpath("//div[@id='age-wrapper']//input"), "age");
    private final InputElement salaryElement = new InputElement(
            By.xpath("//div[@id='salary-wrapper']//input"), "salary");
    private final InputElement departmentElement = new InputElement(
            By.xpath("//div[@id='department-wrapper']//input"), "department");
    private final ButtonElement submitButton = new ButtonElement(
            By.xpath("//button[@id='submit']"), "submitButton");
    private final ButtonElement deleteButton = new ButtonElement(
            By.xpath("//span[@id='delete-record-3']"), "deleteButton");

    public ElementsPage() {
        super(By.xpath("//section[@id='botton-text-10']"), "elementsPage");

    }

    public void clickWebTablesListElement() {
        webTablesElement.focus();
        webTablesElement.click();
    }

    public boolean isTableDisplayed() {
        try {
            tableElement.waitForIsDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFormDisplayed() {
        try {
            formElement.waitForIsDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void fillForm(
            String firstName,
            String lastName,
            String email,
            int age,
            int salary,
            String department) {
        firstNameElement.sendText(firstName);
        lastNameElement.sendText(lastName);
        emailElement.sendText(email);
        ageElement.sendText(String.valueOf(age));
        salaryElement.sendText(String.valueOf(salary));
        departmentElement.sendText(department);
    }

    public void clickSubmitButton() throws InterruptedException {
        submitButton.click();
        Thread.sleep(1000);
    }

    public List<String> findTableRows() {
        WebDriver driver = DriverManager.getInstance().getDriver();
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        return elements.stream().map(webElement -> webElement.getText().replace(" ", "")).filter(s -> !s.equals("")).collect(Collectors.toList());
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }
}
