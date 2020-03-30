import java.net.URL;
import java.io.InputStreamReader;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.rometools.rome.feed.synd.SyndEntry;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Hashtable;
import java.util.Set;


public class parserRome {
	public static void main(String[] args) {
		//Diccionarios
                Hashtable<String, String> hash = new Hashtable<String, String>();
		hash.put("elp", "http://ep00.epimg.net/rss/tags/ultimas_noticias.xml");
		hash.put("bbc", "http://feeds.bbci.co.uk/news/rss.xml");
		//hash.put("lav", "http://www.lavanguardia.com/mvc/feed/rss/home");
		//hash.put("cnn", "http://rss.cnn.com/rss/edition.rss");
		hash.put("abc", "https://sevilla.abc.es/rss/feeds/Sevilla_Sevilla.xml");
		//hash.put("elm", "http://estaticos.elmundo.es/elmundo/rss/portada.xml");

                Hashtable<String, String> hashT = new Hashtable<String, String>();
                hashT.put("elp", "El país");
                hashT.put("bbc", "BBC Headlines");
                //hashT.put("lav", "La vanguardia");
                //hashT.put("cnn", "CNN Headlines");
                hashT.put("abc", "ABC: Sevilla");
                //hashT.put("elm", "El mundo");


		try {
			  Set<String> setTitle = hashT.keySet();
 			  Set<String> setURL = hash.keySet();

			  for (String key : setTitle){
			   System.out.println(hashT.get(key));
			   //URL
			   for (String key1 : setURL) {
			    URL feedURL = new URL(hash.get(key));
			    //Feed
			    SyndFeedInput input = new SyndFeedInput();
    			    //SyndFeed feed = input.build(new InputStreamReader(feedURL.openStream()));
			    SyndFeed feed = input.build(new XmlReader(feedURL));
			    System.out.println(feed.getTitle());
			    //Lista  que tiene el retorno de getEntries
			    List<SyndEntry> synd = new ArrayList<SyndEntry>();
			    synd = feed.getEntries();


			    //Stream
			    Stream<SyndEntry> stream = synd.stream();
			    stream
			    .limit(5)
			    .forEach(s -> System.out.println("\nTítulo de la noticia: \n" + s.getTitle() + "\n Link de la noticia: \n" + s.getLink() + "\n Descripción de la noticia: \n" + s.getDescription().getValue() + "\n"));
			    
			   }
			  }
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
		}


	}
}
