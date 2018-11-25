package com.automationpractice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

/**
 * Use  Jsoup.parseBodyFragment(String html) method to parse a subset of an HTML document.
 *
 * @author Nick G.
 */
public class ParseDocumentFragementTest {

    // there is invalid html within the html body.
    // The Document.body() method retrieves the element children of the document's body element;
    // it is equivalent to doc.getElementsByTag("body").
    @Test
    public void fragementTest() {

        String html = "<html><head><body><div><p>Lorem ipsum.</p></body></head></html>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();

        System.out.println(body.toString());
    }


    @Test
    public void nestedFragmentTest() {

        String URI = "https://nekcchamber.com/the-nearly-forgotten-historic-northeast-kansas-city/";

    }
}
