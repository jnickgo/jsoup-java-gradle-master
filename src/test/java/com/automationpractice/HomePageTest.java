package com.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Parse the homepage of www.automationpractice.com
 *
 * @author Nick G.
 */
public class HomePageTest {

    private static final Logger LOGGER = LogManager.getLogger("Home Page Test");
    private static final String BASE_URI = "http://automationpractice.com";
    private Document document;

    @Before
    public void getDocument() throws IOException {
        document = Jsoup.connect(BASE_URI + "/index.php").get();

        // save document as html file in resources
    }

    @Test
    public void checkTitle() {
        String expected_title = "My Store";
        String actual_title = document.title();
        System.out.println(actual_title);
        LOGGER.debug(actual_title);
        assertThat("Title Check", actual_title, equalTo(expected_title));
    }

    @Test
    public void checkFeaturedProductCount() {

        int expected_count = 7;
        Element featuredProductsList = document.
                getElementById("homefeatured");

        int actual_count = featuredProductsList.
                getElementsByClass("product-container").
                size();

        assertThat("Should be 7 products", actual_count, is(expected_count));

    }

    @Test
    public void getAllFooterLinks() {

        Elements columns = document.getElementsByClass("blockcategories_footer");

        for (Element column : columns) {

            Elements links = column.getElementsByTag("a");

            for (Element link : links) {
                LOGGER.info(link.text());
                System.out.println(link.text());
            }
        }
    }

}
