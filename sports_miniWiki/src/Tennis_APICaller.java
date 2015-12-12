
import java.net.URL;
import java.net.URLConnection;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;

public class Tennis_APICaller {
	
	public static void main(String[] args) {
		try {
			new Tennis_APICaller().start();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void start () throws Exception {
		URL url = new URL("http://api.sportradar.us/tennis-t1/:season/d847c9f6-9cda-4ed5-9fad-c66679525f94/schedule.xml?api_key=hn38fgde5cn377xexv4a9rg6");
		URLConnection connection = url.openConnection();
		
		//Document doc = parseXML(connection.getInputStream());
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(connection.getInputStream());
			
        NodeList month = doc.getElementsByTagName("month");
	
		for (int i = 0; i < month.getLength(); i++) {
			String name = "unknown";

			//ArrayList<TennisLeagueSchedule> tournament_schedule = new ArrayList<TennisLeagueSchedule> ();
			
			name = month.item(i).getAttributes().getNamedItem("name").getTextContent();
			System.out.println(name);
			
			Element month_node = (Element) month.item(i);
			NodeList tournament  = month_node.getElementsByTagName("tournament");
			
			for (int j = 0; j < tournament.getLength(); j++) {
				String tournament_name = "unknown";
				String start = "0000-00-00";
				String end = "0000-00-00";
				String type = "unknown";
				String ground = "unknown";
				String prize = "unknown";
				String currency = "unknown";
				
				try {
					tournament_name = tournament.item(j).getAttributes().getNamedItem("name").getTextContent();
					start = tournament.item(j).getAttributes().getNamedItem("start").getTextContent();
					end = tournament.item(j).getAttributes().getNamedItem("end").getTextContent();
					type = tournament.item(j).getAttributes().getNamedItem("type").getTextContent();
					ground = tournament.item(j).getAttributes().getNamedItem("ground").getTextContent();
					prize = tournament.item(j).getAttributes().getNamedItem("prize_amount").getTextContent();
					currency = tournament.item(j).getAttributes().getNamedItem("prize_currency").getTextContent();
				} catch(Exception e) {}
				
				System.out.println(tournament_name + " " + start + " " + end + " " + " " + type + " " + ground + " " + prize + " " + currency);
				//TennisLeagueSchedule oneTournament = new TennisLeagueSchedule(tournament_name, start, end, type, ground, prize, currency);	
			}
	
	}
		
	}
	/*
	private Document parseXML(InputStream stream) throws Exception {
		DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch(Exception ex)
        {
            throw ex;
        }       

        return doc;
		
	}*/

}
