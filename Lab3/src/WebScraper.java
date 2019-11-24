import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * Counts the amount a certain word appears in a webpage.
     *
     * @param url url to retrieve contents from
     * @param target target string to count occurrences
     * @return the number of occurences of target word in the webpage. or an empty string on error
     */
    public static int counter(final String url, final String target) {
        if (url == null || target == null) {
            return -1;
        }

        String webpage = urlToString(url);
        int length = target.length();
        int count = 0;

        while(webpage.length() >= length) {
            String cut = webpage.substring(0, length);
            if (cut.equals(target)) {
                count++;
                webpage = webpage.substring(length, webpage.length());
            } else {
                webpage = webpage.substring(1, webpage.length());
            }
        }

        return count;
    }

    public static int counterIgnoreCase(final String url, final String target) {
        if (url == null || target == null) {
            return -1;
        }

        String urlIgnoreCase = url.toLowerCase();
        String targetIgnoreCase = target.toLowerCase();

        return counter(urlIgnoreCase, targetIgnoreCase);
    }


    public static void main (String[] unused) {
        Scanner lineScanner = new Scanner(System.in);
        System.out.println("Enter a url: ");
        String input1 = lineScanner.nextLine();

        System.out.println("Enter a word to count: ");
        String input2 = lineScanner.nextLine();

        //System.out.println(urlToString(input));

        System.out.println("Your word was counted " + counterIgnoreCase(input1, input2) + " times. ");
    }
}
