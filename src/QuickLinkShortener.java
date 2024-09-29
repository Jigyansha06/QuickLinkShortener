import java.util.HashMap;
import java.util.Scanner;

public class QuickLinkShortener {

    private HashMap<String, String> urlMap;
    private int idCounter;

    public QuickLinkShortener() {
        urlMap = new HashMap<>();
        idCounter = 0;
    }

    // Method to shorten the URL
    public String shortenUrl(String longUrl) {
        String shortUrl = "http://short.ly/" + (++idCounter);
        urlMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Method to retrieve the original URL
    public String getOriginalUrl(String shortUrl) {
        return urlMap.getOrDefault(shortUrl, "URL not found.");
    }

    public static void main(String[] args) {
        QuickLinkShortener shortener = new QuickLinkShortener();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("1. Shorten a URL");
            System.out.println("2. Retrieve the original URL");
            System.out.println("3. Exit");
            System.out.println("Choose an option:");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the long URL: ");
                    String longUrl = scanner.nextLine();
                    String shortUrl = shortener.shortenUrl(longUrl);
                    System.out.println("Shortened URL: " + shortUrl);
                    break;

                case "2":
                    System.out.print("Enter the shortened URL: ");
                    String inputShortUrl = scanner.nextLine();
                    String originalUrl = shortener.getOriginalUrl(inputShortUrl);
                    System.out.println("Original URL: " + originalUrl);
                    break;

                case "3":
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // Print an empty line for better readability
        } while (!choice.equals("3"));

        scanner.close();
    }
}
