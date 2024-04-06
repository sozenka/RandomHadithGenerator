import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonToText {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Json File Path: ");
        String jsonFilePath = input.nextLine();
        System.out.println("Text File Path: ");
        String textFilePath = input.nextLine();

        input.close();

        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        JSONObject jsonObject = new JSONObject(jsonContent);
        JSONArray hadiths = jsonObject.getJSONArray("hadith");

        try (PrintWriter writer = new PrintWriter(textFilePath)) {
            for (int i = 0; i < hadiths.length(); i++) {
                JSONObject hadith = hadiths.getJSONObject(i);
                writer.println("ID: " + hadith.getInt("id"));
                writer.println("Book: " + hadith.getString("book"));
                writer.println("Chapter: " + hadith.optString("chapterName", "Not Available"));
                writer.println("Hadith: " + hadith.getString("hadith_english"));
                writer.println("---");
            }
        }
        System.out.println("Conversion completed.");
    }
}
