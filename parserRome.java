import java.net.URL;
import java.io.InputStreamReader;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.rometools.rome.feed.synd.SyndEntry;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

public class parserRome {
	public static void main(String[] args) {

		try {
			URL feedURL = new URL("https://www.lavanguardia.com/mvc/feed/rss/home");

			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(feedURL));
			System.out.println(feed.getTitle());
			List<SyndEntry> synd = new ArrayList<SyndEntry>();
			synd = feed.getEntries();
				//for (SyndEntry entry : synd) {
				  //System.out.println("Título de la noticia: ");
				  //System.out.println(entry.getTitle());
				  //System.out.println("Link de la noticia: ");
				  //System.out.println(entry.getLink());
				  //System.out.println("Descripción de la noticia: ");
				  //System.out.println(entry.getDescription().getValue());
				  //System.out.println();
				//}
			Stream<SyndEntry> stream = synd.stream();
			stream
			.limit(5)
			.forEach(s -> System.out.println("\nTítulo de la noticia: \n" + s.getTitle() + "\n Link de la noticia: \n" + s.getLink() + "\n Descripción de la noticia: \n" + s.getDescription().getValue() + "\n"));

		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
		}


	}
}
