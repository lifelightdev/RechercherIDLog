package Life.Light.RechercherIDLog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootTest
public class ReadFileTest {

    @Test
    void read_file_to_url_list() {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            File fichier = new File(Objects.requireNonNull(classLoader.getResource("logs/20130201-0000.log")).getFile());
            ReadFile readFile = new ReadFile();
            int resultat = readFile.readToURLs(fichier).size();
            Assertions.assertThat(resultat).isEqualTo(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void read_tow_file_to_url_list() {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            File fichier = new File(Objects.requireNonNull(classLoader.getResource("logs/20130201-0000.log")).getFile());
            File fichierDeux = new File(Objects.requireNonNull(classLoader.getResource("logs/20130201-0100.log")).getFile());
            List<File> fichiers = new ArrayList<>();
            fichiers.add(fichier);
            fichiers.add(fichierDeux);
            ReadFile readFile = new ReadFile();
            int resultat = readFile.readAllToURLs(fichiers).size();
            Assertions.assertThat(resultat).isEqualTo(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
