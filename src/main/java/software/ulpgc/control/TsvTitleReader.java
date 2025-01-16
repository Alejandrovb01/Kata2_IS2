package software.ulpgc.control;

import software.ulpgc.model.Title;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleReader implements TitleReader {
    private final File file;

    public TsvTitleReader(File file) {
        this.file = file;
    }

    public List<Title> read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            reader.readLine();
            return readWith(reader);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Title> readWith(BufferedReader reader) throws IOException {
        List<Title> result = new ArrayList<>();
        TsvTitleDeserializer deserializer = new TsvTitleDeserializer();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            Title title = deserializer.deserialize(line);
            result.add(title);
        }
        return result;
    }
}
