public class Hadith {
    private final int id;
    private final String book;
    private final String chapter;
    private final String hadithText;

    public Hadith(int id, String book, String chapter, String hadithText) {
        this.id = id;
        this.book = book;
        this.chapter = chapter;
        this.hadithText = hadithText;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nBook: " + book + "\nChapter: " + chapter + "\nHadith: " + hadithText + "\n---";
    }
}
