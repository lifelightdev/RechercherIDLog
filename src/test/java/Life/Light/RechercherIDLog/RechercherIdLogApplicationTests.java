package Life.Light.RechercherIDLog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RechercherIdLogApplicationTests {

	@Test
	void find_the_ID_690_in_URL() {
		String url = "https://test.net?a=1&id=690&b=2&c=3";
		Find find = new Find();
		Assertions.assertThat(find.iDIn(url)).isEqualTo(690);
	}

	@Test
	void find_the_ID_835_in_URL() {
		String url = "http://a.com?id=835";
		Find find = new Find();
		Assertions.assertThat(find.iDIn(url)).isEqualTo(835);
	}

}
