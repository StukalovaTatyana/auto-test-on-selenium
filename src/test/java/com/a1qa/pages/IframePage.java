package com.a1qa.pages;

import com.a1qa.elements.IFrameElement;
import com.a1qa.elements.ListItemElement;
import com.a1qa.elements.TextElement;
import org.openqa.selenium.By;

public class IframePage extends BaseForm {
    private final ListItemElement iframeElement;
    private final ListItemElement framesElement;
    private final IFrameElement parentFrame;
    private final TextElement parentFrameBody;
    private final IFrameElement childFrame;
    private final TextElement childFrameBody;

    public IframePage() {
        super(By.xpath("//section[@id='botton-text-10']"), "iframePage");
        iframeElement = new ListItemElement(
                By.xpath("//div[@class ='element-list collapse show']//ul//li[@id='item-3']"), "iframeElement");
        framesElement = new ListItemElement(
                By.xpath("//div[@class ='element-list collapse show']//ul//li[@id='item-2']"), "framesElement");
        parentFrame = new IFrameElement(
                By.xpath("//iframe[@id='frame1']"), "parentFrame");
        parentFrameBody = new TextElement(
                By.xpath("//body"), "parentFrameBody");
        childFrame = new IFrameElement(
                By.xpath("//iframe"), "childFrame");
        childFrameBody = new TextElement(
                By.xpath("//body"), "childFrameBody");
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
