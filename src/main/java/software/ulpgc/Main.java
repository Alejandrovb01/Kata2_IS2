package software.ulpgc;

import software.ulpgc.control.TsvTitleReader;
import software.ulpgc.model.Title;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\aleja\\Downloads\\title.basics.tsv");
        List<Title> titles = new TsvTitleReader(file).read();

        HashMap<Title.TitleType, Integer> histogram = new HashMap<>();

        for (Title title : titles) {
            histogram.put(title.titleType(), histogram.getOrDefault(title.titleType(), 0) + 1);
        }

        for (Title.TitleType titleType : histogram.keySet()) {
            System.out.println(titleType + ": " + histogram.get(titleType));
        }
    }
}