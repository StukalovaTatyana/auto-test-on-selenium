package com.a1qa.pages;

import com.a1qa.framework.elements.impl.IFrameElement;
import com.a1qa.framework.elements.impl.TextElement;
import com.a1qa.framework.form.BaseForm;
import org.openqa.selenium.By;

public class FramesPage extends BaseForm {
    private final IFrameElement topIframeElement = new IFrameElement(
            By.xpath("//iframe[@id='frame1']"), "topIframeElement");
    private final TextElement topIframeElementBody = new TextElement(
            By.xpath("//h1[@id='sampleHeading']"), "topIframeElementBody");
    private final IFrameElement botIframeElement = new IFrameElement(
            By.xpath("//iframe[@id='frame2']"), "botIframeElement");
    private final TextElement botIframeElementBody = new TextElement(
            By.xpath("//h1[@id='sampleHeading']"), "botIframeElementBody");

    public FramesPage() {
        super(new TextElement(By.xpath("//section[@id='botton-text-10']"), "framesPageUniqElement"), "framesPage");
    }

    public String getTextFromTopFrame() {
        topIframeElement.switchToFrameDriver();
        String result = topIframeElementBody.getText();
        topIframeElement.switchToMainDriver();
        return result;
    }

    public String getTextFromBotFrame() {
        botIframeElement.switchToFrameDriver();
        String result = botIframeElementBody.getText();
        botIframeElement.switchToMainDriver();
        return result;
    }

}
