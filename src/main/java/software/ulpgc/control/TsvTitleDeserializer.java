package software.ulpgc.control;

import software.ulpgc.model.Title;

public class TsvTitleDeserializer implements TitleDeserializer {

    @Override
    public Title deserialize(String line) {
        return deserialize(line.split("\t"));
    }

    private Title deserialize(String[] fields) {
        return new Title(fields[0], toTitleType(fields[1]), fields[2]);

    }

    private Title.TitleType toTitleType(String field) {
        return Title.TitleType.valueOf(normalize(field));
    }

    private String normalize(String line) {
        return (line.toUpperCase().charAt(0) + line.substring(1)).replace("-", "");
    }
}
