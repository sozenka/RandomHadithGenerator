import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HadithGenerator {
    private final List<String> hadiths;

    public HadithGenerator(String filePath) {
        this.hadiths = loadHadiths(filePath);
    }

    private List<String> loadHadiths(String filePath) {
        List<String> loadedHadiths = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder hadithBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("---")) {
                    loadedHadiths.add(hadithBuilder.toString());
                    hadithBuilder = new StringBuilder();
                } else {
                    hadithBuilder.append(line).append("\n");
                }
            }
            if (!hadithBuilder.toString().isEmpty()) {
                loadedHadiths.add(hadithBuilder.toString());
            }
        } catch (Exception e) {
            System.out.println("Failed to load hadiths: " + e.getMessage());
        }
        return loadedHadiths;
    }

    public String getRandomHadith() {
        if (this.hadiths.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return this.hadiths.get(random.nextInt(this.hadiths.size()));
    }

    public static String wrapText(String text, int maxWidth) {
        String[] words = text.split(" ");
        StringBuilder wrappedText = new StringBuilder();
        int lineLen = 0;
        for (String word : words) {
            if (word.length() + lineLen + 1 > maxWidth) {
                wrappedText.append("\n");
                lineLen = 0;
            }
            wrappedText.append(lineLen > 0 ? " " : "").append(word);
            lineLen += word.length() + 1;
        }
        return wrappedText.toString();
    }
}
