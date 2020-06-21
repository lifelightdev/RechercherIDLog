package Life.Light.RechercherIDLog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
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

}
