package com.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/**
 * Extract attributes, text, and HTML from elements
 *
 * @author Nick G.
 */
public class ModifyElementsTest
{
    private static final Logger LOGGER = LogManager.getLogger("Alt Text Test");
    private static final String BASE_URI = "http://automationpractice.com";

    private static String html = "<html><head><title>First parse</title></head>"
            + "<body><h1 id=\"heading\">Heading One</h1><p>Parsed HTML into a doc.</p></body></html>";
    @Test
    public void modifyIdAttribute()
    {
        Document document = Jsoup.parse(html);

        document.body().select("h1").attr("id","pageHeading");

        html = document.toString();

        LOGGER.debug("Modified HTML: " + html);
        System.out.println("Modified HTML: " + html);
    }


}
