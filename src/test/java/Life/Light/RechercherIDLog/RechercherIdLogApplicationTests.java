package Life.Light.RechercherIDLog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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

	@Test
	void find_IDs_in_2_URL() {
		List<String> urls = new ArrayList<>();
		urls.add("http://a.com?id=43");
		urls.add("https://test.net?a=1&id=446&b=2&c=3");
		Find find = new Find();
		List<Integer> resultatObtenu = find.iDsIn(urls);
		List<Integer> resultatAttendu = new ArrayList<>();
		resultatAttendu.add(43);
		resultatAttendu.add(446);
		Assertions.assertThat(resultatObtenu).isEqualTo(resultatAttendu);
	}

	@Test
	void find_max_nb_ID_in_URL_list() {
		List<String> urls = new ArrayList<>();
		urls.add("http://a.com?id=43");
		urls.add("https://test.net?a=1&id=446&b=2&c=3");
		urls.add("https://test.net?a=1&id=446&b=2&c=3");
		urls.add("https://test.net?a=1&id=156&b=2&c=3");
		urls.add("http://bid.org?a=1&id=551");
		urls.add("http://a.com?id=578");
		urls.add("https://test.net?a=1&id=446&b=2&c=3");
		urls.add("http://a.com?id=307");
		urls.add("http://a.com?id=331");
		Find find = new Find();
		Integer resultatObtenu = find.maxNbIDIn(urls);
		Assertions.assertThat(resultatObtenu).isEqualTo(446);
	}

	@Test
	void find_5_max_nb_ID_in_URL_list() {
		List<String> urls = new ArrayList<>();
		urls.add("http://bid.org?a=1&id=177");
		urls.add("http://a.com?id=177");
		urls.add("https://test.net?a=1&id=177&b=2&c=3");
		urls.add("http://bid.org?a=1&id=177");
		urls.add("http://bid.org?a=1&id=70");
		urls.add("http://bid.org?a=1&id=177");
		urls.add("http://a.com?id=177");
		urls.add("http://a.com?id=897");
		urls.add("https://test.net?a=1&id=897&b=2&c=3");
		urls.add("https://test.net?a=1&id=897&b=2&c=3");
		urls.add("https://test.net?a=1&id=70&b=2&c=3");
		urls.add("https://test.net?a=1&id=70&b=2&c=3");
		urls.add("http://bid.org?a=1&id=897");
		urls.add("https://test.net?a=1&id=177&b=2&c=3");
		urls.add("https://test.net?a=1&id=897&b=2&c=3");
		urls.add("https://test.net?a=1&id=897&b=2&c=3");
		urls.add("https://test.net?a=1&id=70&b=2&c=3");
		urls.add("http://bid.org?a=1&id=70");
		urls.add("http://bid.org?a=1&id=551");
		urls.add("http://a.com?id=43");
		urls.add("https://test.net?a=1&id=446&b=2&c=3");
		urls.add("https://test.net?a=1&id=446&b=2&c=3");
		urls.add("https://test.net?a=1&id=156&b=2&c=3");
		urls.add("http://bid.org?a=1&id=551");
		urls.add("http://a.com?id=578");
		urls.add("https://test.net?a=1&id=446&b=2&c=3");
		urls.add("http://a.com?id=307");
		urls.add("http://a.com?id=331");
		Find find = new Find();
		List<Integer> resultatObtenu = find.cinqMaxNbIDIn(urls);
		List<Integer> resultatAttendu = new ArrayList<>();
		resultatAttendu.add(177);
		resultatAttendu.add(897);
		resultatAttendu.add(70);
		resultatAttendu.add(446);
		resultatAttendu.add(551);
		Assertions.assertThat(resultatObtenu).isEqualTo(resultatAttendu);
	}

}
