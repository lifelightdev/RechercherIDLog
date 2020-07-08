package Life.Light.RechercherIDLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {
    public List<String> readToURLs(File fichier) {
        List<String> urls = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(fichier);
            while (myReader.hasNextLine()) {
                urls.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return urls;
    }

    public List<String> readAllToURLs(List<File> fichiers) {
        List<String> urls = new ArrayList<>();
        fichiers.forEach(fichier->urls.addAll(readToURLs(fichier)));
        return urls;
    }

    public List<String> readDirectoryToURLs(String directory) {

        File file = new File(directory);
        List<File> listFiles = Arrays.asList(Objects.requireNonNull(file.listFiles()));

        return readAllToURLs(listFiles);
    }
}
