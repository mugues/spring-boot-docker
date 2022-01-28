package com.sample.web;

import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.javascript.SilentJavaScriptErrorListener;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static io.restassured.RestAssured.given;

public class UserControllerIT {

    private void handleWarning(WebClient webClient) {
        webClient.setJavaScriptErrorListener(new SilentJavaScriptErrorListener());
        webClient.setCssErrorHandler(new SilentCssErrorHandler());
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);

    }

    @Test
    public void homepage() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            handleWarning(webClient);
            final HtmlPage page = webClient.getPage("http://localhost:8080/");

            final String pageAsXml = page.asXml();
            Assertions.assertTrue(pageAsXml.contains("Users"));

        }
    }

    @Test
    public void submittingForm() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            handleWarning(webClient);

            final HtmlPage page1 = webClient.getPage("http://localhost:8080/signup");
            final HtmlForm form = page1.getFormByName("addUserForm");

            final HtmlTextInput userName = form.getInputByName("name");
            userName.setValueAttribute("Max");

            final HtmlTextInput userEmail = form.getInputByName("email");
            userEmail.setValueAttribute("m@x.it");

            HtmlInput submitbutton = form.getInputByName("submitbutton");
            final HtmlPage page2 = submitbutton.click();

            final String pageAsText = page2.asXml();
            Assertions.assertTrue(pageAsText.contains("m@x.it"));
        }
    }
}
