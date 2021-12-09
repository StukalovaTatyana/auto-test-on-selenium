package com.a1qa.pages;

import com.a1qa.elements.ListItemElement;
import org.openqa.selenium.By;

public class IframePage extends BaseForm {
    private ListItemElement iframeElement;

    public IframePage() {
        super(By.xpath("//section[@id='botton-text-10']"), "iframePage");
        iframeElement = new ListItemElement(
                By.xpath("//div[@class ='element-list collapse show']//ul//li[@id='item-3']"), "iframeElement");
        //iframe[@id='frame1']
    }

    public void clickIframeButton() {
        iframeElement.focus();
        iframeElement.click();
    }

}
