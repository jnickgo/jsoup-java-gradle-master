package com.automationpractice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

/**
 * Extract attributes, text, and HTML from elements
 *
 * @author Nick G.
 */
public class ReadSomeOtherAttributesTest
{
    private static final String BASE_URI = "http://automationpractice.com";

    /**
     * Print all links with the following attributes and html to the console.
     * - text
     * - href
     * - inner html
     * - outer html
     *
     * @throws IOException
     */
    @Test
    public void extractAllLinks() throws IOException
    {

        Document document = Jsoup.connect(BASE_URI + "/index.php").get();

        Elements links = document.body().getElementsByTag("a");

        for ( Element link : links )
        {
            if (!link.text().isEmpty())
            {
                String linkText = link.text();
                String linkHref = link.attr("href");
                String linkOuterH = link.outerHtml();
                String linkInnerH = link.html();

                System.out.println("link text " + linkText);
                System.out.println("link href " + linkHref);
                System.out.println("link outer html " + linkOuterH);
                System.out.println("link inner html " + linkInnerH);
            }

        }



    }
}
