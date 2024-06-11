package us.tobyschz.authlink.common;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class URLUtil {
    private URLUtil() { //util classes should never be init
    }

    /**
     * Get the base url from string
     * @param input Valid url
     * @return Base of input url
     * @throws MalformedURLException URL validation
     */
    public static String getBase(String input) throws MalformedURLException {
        URL url = URI.create(input).toURL();

        return (url.getPort() == -1) ? String.format("%s://%s/", url.getProtocol(), url.getHost())
                : String.format("%s://%s:%s/", url.getProtocol(), url.getHost(), url.getPort());
    }
}
