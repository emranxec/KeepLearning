package programs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class printAllWordsFromFile {

    public static void main(String[] args) throws IOException {
        Stream<String> lines= Files.lines(Paths.get("README.md"));

        lines.sorted()
                .filter(i->i.length()>9)
                .forEach(x-> System.out.println(x+ " "));
        lines.close();
    }
}
