package com.automationpractice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Parse HTML as a String into a walkable document.
 *
 * @author Nick G.
 */
public class ParseDocumentFromStringTest {

    private static String html = "<html><head><title>First parse</title></head>"
            + "<body><h1 id=\"heading\">Heading One</h1><p>Parsed HTML into a doc.</p></body></html>";

    private Document document;

    @Before
    public void setUp() {

        document = Jsoup.parse(html);
    }

    @Test
    public void headerOneTest() {

        assertThat("Check Heading", document.getElementById("heading").text(), equalTo("Heading One"));
    }

    @Test
    public void paragraphTextTest() {

        Element paragraph = document.getElementsByTag("p").first();
        String text = paragraph.text();
        assertThat("Paragaph", "Parsed HTML into a doc.", equalTo(text));
    }



}
