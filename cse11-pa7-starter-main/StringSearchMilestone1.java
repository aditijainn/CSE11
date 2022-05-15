import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class StringSearch {
    public static void main(String[] args) throws IOException {
        String file = Files.readString(Paths.get(args[0]));
        String[] lines = file.split("\n");
        for(String words: lines) {
            System.out.println(words);
        }
    }
}