import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class TextAnalytics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String apiKey = "e31bb7195d7542328a2af30959e87521";
            String endpoint = "https://iaex04teste.cognitiveservices.azure.com/";
            System.out.println("Texto para ser analisado:");
            String textToAnalyze = sc.nextLine();

            String urlString = endpoint + "/text/analytics/v3.1/languages"; // Detecção de linguagem

            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Ocp-Apim-Subscription-Key", apiKey);
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            // Enviar o texto a ser analisado
            String jsonInputString = "{\"documents\":[{\"id\":\"1\",\"text\":\"" + textToAnalyze + "\"}]}";
            con.getOutputStream().write(jsonInputString.getBytes("UTF-8"));

            // Verificar o código de resposta
            int responseCode = con.getResponseCode();
            System.out.println("Código de resposta: " + responseCode);

            // Ler a resposta
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Exibir a resposta
            System.out.println("Linguagem detectada: " + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}