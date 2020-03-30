import java.net.URL;
import java.io.InputStreamReader;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.rometools.rome.feed.synd.SyndEntry;
import java.util.List;
import java.util.ArrayList;


public class parserRome {
	public static void main(String[] args) {
		boolean ok = false;

		try {
			URL feedURL = new URL("https://www.lavanguardia.com/mvc/feed/rss/home");

			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(feedURL));
			System.out.println(feed.getTitle());
			List<SyndEntry> synd = feed.getEntries();
				for (SyndEntry entry : synd) {
				  System.out.println("Título de la noticia: ");
				  System.out.println(entry.getTitle());
				  System.out.println("Link de la noticia: ");
				  System.out.println(entry.getLink());
				  System.out.println("Descripción de la noticia: ");
				  System.out.println(entry.getDescription().getValue());
				  System.out.println();
				}


			ok = true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
		}

		if (!ok) {
			System.out.println();
			System.out.println("FeedReader reads and prints any RSS/Atom feed type,");
			System.out.println("The first parameter must be the URL of the feed to read,");
			System.out.println();
		}

	}
}
