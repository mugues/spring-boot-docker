package com.sample.web;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static io.restassured.RestAssured.when;

public class SampleControllerIT {

    @Test
    public void testRestAssured() {
        when().
                get("/ping").
                then().
                statusCode(200);
    }

    @Test
    public void ping() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("http://localhost:8080/ping");

            final String pageAsXml = page.asXml();
            Assert.assertTrue(pageAsXml.contains("<html>"));

            final String pageAsText = page.asText();
            Assert.assertTrue(pageAsText.contains("Pooooong"));
        }
    }

    @Test
    public void homepage() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("http://localhost:8080/");

            final String pageAsXml = page.asXml();

        }
    }

    @Test
    public void submittingForm() throws Exception {
        try (final WebClient webClient = new WebClient()) {


            final HtmlPage page1 = webClient.getPage("http://localhost:8080/");

            // Get the form that we are dealing with and within that form,
            // find the submit button and the field that we want to change.
            final HtmlForm form = page1.getFormByName("personForm");

            final HtmlTextInput personName = form.getInputByName("name");
            personName.type("Max");

            final HtmlTextInput personAge = form.getInputByName("age");
            personAge.type("35");

            Optional<HtmlButton> submitbutton = form.getButtonsByName("submitbutton").stream().findFirst();
            final HtmlPage page2 = submitbutton.get().click();

            final String pageAsText = page2.asText();
            Assert.assertTrue(pageAsText.contains("Congratulations! You are old enough to sign up for this site."));
        }
    }
}
