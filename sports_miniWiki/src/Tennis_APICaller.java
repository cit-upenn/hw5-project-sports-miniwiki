import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
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
		URL url = new URL("http://api.sportradar.us/tennis-t1/tournament/0abbaeaf-d0bc-4aed-b15a-c929070eb60f/competitors.xml?api_key=hn38fgde5cn377xexv4a9rg6");
		URLConnection connection = url.openConnection();
		
		Document doc = parseXML(connection.getInputStream());
		NodeList descNodes = doc.getElementsByTagName("competitor");
		
		for (int i = 0; i < descNodes.getLength(); i++) {
			System.out.println(descNodes.item(i).getAttributes().getNamedItem("name"));
		}
	}
	
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
		
	}

}