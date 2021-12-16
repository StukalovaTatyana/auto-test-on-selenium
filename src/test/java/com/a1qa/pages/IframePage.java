package com.a1qa.pages;

import com.a1qa.framework.elements.impl.IFrameElement;
import com.a1qa.framework.elements.impl.ListItemElement;
import com.a1qa.framework.elements.impl.TextElement;
import com.a1qa.framework.form.BaseForm;
import org.openqa.selenium.By;

public class IframePage extends BaseForm {
    private final ListItemElement iframeElement = new ListItemElement(
            By.xpath("//div[@class ='element-list collapse show']//ul//li[@id='item-3']"), "iframeElement");
    private final ListItemElement framesElement = new ListItemElement(
            By.xpath("//div[@class ='element-list collapse show']//ul//li[@id='item-2']"), "framesElement");
    private final IFrameElement parentFrame = new IFrameElement(
            By.xpath("//iframe[@id='frame1']"), "parentFrame");
    private final TextElement parentFrameBody = new TextElement(
            By.xpath("//body"), "parentFrameBody");
    private final IFrameElement childFrame = new IFrameElement(
            By.xpath("//iframe"), "childFrame");
    private final TextElement childFrameBody = new TextElement(
            By.xpath("//body"), "childFrameBody");

    public IframePage() {
        super(new TextElement(By.xpath("//section[@id='botton-text-10']"), "iframePageUniqElement"), "iframePage");
    }

    public void clickIframeListElement() {
        iframeElement.focus();
        iframeElement.click();
    }

    public void clickFramesListElement() {
        framesElement.focus();
        framesElement.click();
    }

    public String getTextFromParentFrame() {
        parentFrame.switchToFrameDriver();
        String result = parentFrameBody.findElement().getText();
        parentFrame.switchToMainDriver();
        return result;
    }

    public String getTextFromChildrenFrame() {
        parentFrame.switchToFrameDriver();
        childFrame.switchToFrameDriver();
        String result = childFrameBody.findElement().getText();
        childFrame.switchToMainDriver();
        return result;
    }

}
