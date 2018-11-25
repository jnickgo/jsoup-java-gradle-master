package com.automationpractice;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Example of sign-in form with JSoup.
 * @author Nick G.
 */
public class SignInTest {

    private static final String URI = "http://automationpractice.com/index.php";
    private Map cookies;

    // FIXME: Test site was not working a last check
    // @Test
    public void loginTest() throws Exception
    {

        Map<String, String> paramsMap = new HashMap<String, String>();
        // email and password will need to be generated before test execution
        paramsMap.put("controller", "authentication");
        paramsMap.put("email", "nickgover@gmail.com");
        paramsMap.put("passwd","MCd74W2vWz0N");
        paramsMap.put("back","my-account");
        paramsMap.put("SubmitLogin","");

        Connection.Response response = Jsoup.connect(URI)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0")
                .timeout(10 * 1000)
                .data(paramsMap)
                .header("Content-Type","application/x-www-form-urlencoded")
                .header("Origin","http://automationpractice.com")
                .header("Connection","keep-alive")
                .header("Referer","http://automationpractice.com/index.php?controller=authentication&back=my-account")
                .header("Accept","ext/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .header("Upgrade-Insecure-Requests","1")
                .header("Accept-Language","en-US,en;q=0.9")
                .header("Accept-Encoding","gzip, deflate")
                .header("Host","automationpractice.com")
                .followRedirects(true)
                .method(Connection.Method.POST)
                .execute();

        cookies = response.cookies(); // get the cookies to continue the session if you want

        Document document = response.parse();
        System.out.println("Status: "+response.statusCode());
        System.out.println(document.toString());
        String docBody = document.body().toString(); // get the response body as your new document to parse

        String expectedTitle = "My account - My Store";
        assertThat(document.title(), is(expectedTitle));
    }

}

