import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {

        // Print results from each API
        System.out.println(getStoreDetails());
        System.out.println(getItemsDetails());

        System.out.println("Complete");

    }

    /**
     * /getStoreDetails
     * Get Request: Returns all Stores with their address and phone number
     */
    public static String getStoreDetails() {
        String results = "Request Failed";  // Placeholder if function fails
        String url = "https://apimdev.wakefern.com/mockexample/V1/getStoreDetails"; // getStoreDetails URL

        // 1 - Create Client
        HttpClient clientStores = HttpClient.newHttpClient();

        // 2 - Build Request with headers
        HttpRequest requestStores = HttpRequest.newBuilder()
                .uri(URI.create(url))     //Set URL
                .header("Ocp-Apim-Subscription-Key", "4ae9400a1eda4f14b3e7227f24b74b44")      //Set Other Headers
                .method("GET", HttpRequest.BodyPublishers.noBody())                              //Set Method
                .build();


        // 3 - Client sends request and saves the response in a variable
        HttpResponse responseStores = null;
        try {
            responseStores = clientStores.send(requestStores, HttpResponse.BodyHandlers.ofString());

            // 4 - Save response in results variable
            results = (String) responseStores.body();

            // 5 - Error Handling
            /**
             * Error Handling Conventions:
             * Errors are generally saved in a separate log file to be accessed in the future
             * In production, code generally should not print anything on the console
             * Console logging is okay for development/debugging purposes
             */
        } catch (IOException e) {
            System.out.println("Cannot send request to " + url + " : " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Cannot send request to " + url + " : " + e.getMessage());
        }

        return results;
    }


    /**
     * /getItemDetails
     * Get Request: Returns all items sold in a store with their base price and discount prices
     */
    public static String getItemsDetails() {
        String results = "Request Failed";  // Placeholder if function fails
        String url = "https://apimdev.wakefern.com/mockexample/V1/getItemDetails";  // getItemDetails URL

        // 1 - Create Client
        HttpClient clientItems = HttpClient.newHttpClient();

        // 2 - Build Request with headers
        HttpRequest requestItems = HttpRequest.newBuilder()
                .uri(URI.create(url))      //Set URL
                .header("Ocp-Apim-Subscription-Key", "4ae9400a1eda4f14b3e7227f24b74b44")      //Set Headers
                .method("GET", HttpRequest.BodyPublishers.noBody())                             //Set Method
                .build();

        try {
            // 3 - Client sends request and saves the response in a variable
            HttpResponse responseItems = clientItems.send(requestItems, HttpResponse.BodyHandlers.ofString());

            // 4 - Save response in results variable
            results = (String) responseItems.body();

            // 5 - Error Handling
            /**
             * Error Handling Conventions:
             * Errors are generally saved in a separate log file to be accessed in the future
             * In production, code generally should not print anything on the console
             * Console logging is okay for development/debugging purposes
             */
        } catch (IOException e) {
            System.out.println("Cannot send request to " + url + " : " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Cannot send request to " + url + " : " + e.getMessage());
        }

        return results;
    }


}