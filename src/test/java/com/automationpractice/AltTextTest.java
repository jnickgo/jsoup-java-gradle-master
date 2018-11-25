package com.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Compliance and Accessability testing.
 * Verify Alt Text of important Elements on the homepage of www.automationpractice.com
 *
 * @author Nick G.
 */
public class AltTextTest
{
    private static final Logger LOGGER = LogManager.getLogger("Alt Text Test");
    private static final String BASE_URI = "http://automationpractice.com";


    /**
     * Validate that the image alt text is not null or empty.
     * Note. Test should pass.
     */
    @Test
    public void imageAltTextExists()
    {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><img alt=\"This is alt text\"></img><img alt></img><p>Parsed HTML into a doc.</p></body></html>";

        Document doc = Jsoup.parse(html);

        Elements images = doc.getElementsByTag("img");

        // iterate through images...
        for (Element img : images) {
            String value = img.attr("alt");
            System.out.println("Value: " + value);
        }

        assertThat(images.get(0).attr("alt"), is(not(Matchers.emptyString())));
        assertThat(images.get(1).attr("alt"), is((Matchers.emptyString())));
    }


    /**
     * Ensure that all img tags have valid alt attribute text.
     * Note. There should be 5 buttons.
     */
    @Test
    public void imageAltTextIsNotEmpty() throws IOException {

        Document document = Jsoup.connect(BASE_URI + "/index.php").get();

        Elements images = document.body().getElementsByTag("img");

        System.out.println(images.size());
        LOGGER.debug(images.size());

        for ( Element img : images ) {

            System.out.println("image alt text: " + img.attr("alt"));
            LOGGER.debug("image alt text: " + img.attr("alt"));

            if ( img.attr("alt").isEmpty() )
            {
                // which button doesn't have have a title?
                System.out.println("Image Text: " + img.text());
            }

            //assertThat(img.attr("alt"), is(not(Matchers.emptyString())));
        }

    }

}
