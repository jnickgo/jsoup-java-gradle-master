package com.automationpractice;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * In the case to allow untrusted users to supply HTML for output on your website (e.g. as comment submission).
 *
 * @author Nick G.
 */
public class SanatizeHtmlTest {

    // https://jsoup.org/cookbook/cleaning-html/whitelist-sanitizer

    String unsafeHtml =
            "<p><a href='http://example.com/' onclick='stealCookies()'>Link</a></p>";
    String safeHtml = Jsoup.clean(unsafeHtml, Whitelist.basic());

    // now: <p><a href="http://example.com/" rel="nofollow">Link</a></p>

}
