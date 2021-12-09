package com.a1qa.pages;

import com.a1qa.elements.IFrameElement;
import com.a1qa.elements.TextElement;
import org.openqa.selenium.By;

public class FramesPage extends BaseForm {
    private final IFrameElement topIframeElement;
    private final TextElement topIframeElementBody;
    private final IFrameElement botIframeElement;
    private final TextElement botIframeElementBody;

    public FramesPage() {
        super(By.xpath("//section[@id='botton-text-10']"), "framesPage");
        topIframeElement = new IFrameElement(
                By.xpath("//iframe[@id='frame1']"), "topIframeElement"
        );
        topIframeElementBody = new TextElement(
                By.xpath("//h1[@id='sampleHeading']"), "topIframeElementBody"
        );
        botIframeElement = new IFrameElement(
                By.xpath("//iframe[@id='frame2']"), "botIframeElement"
        );
        botIframeElementBody = new TextElement(
                By.xpath("//h1[@id='sampleHeading']"), "botIframeElementBody"
        );
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
