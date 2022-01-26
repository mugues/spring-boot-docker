package com.sample.web;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static io.restassured.RestAssured.given;

public class SampleControllerIT {

    @Test
    public void testRestAssured() {
        Response response=given().
                get("/ping").
                then().
                statusCode(200)
                .and()
                .log().all()
                .extract().response();


        XmlPath jsXpath= new XmlPath(response.asString());
    }

    @Test
    public void ping() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("http://localhost:8080/ping");

            final String pageAsXml = page.asXml();
            Assertions.assertTrue(pageAsXml.contains("<html>"));

            final String pageAsText = page.asText();
            Assertions.assertTrue(pageAsText.contains("Pooooong"));
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
            Assertions.assertTrue(pageAsText.contains("Congratulations! You are old enough to sign up for this site."));
        }
    }
}
