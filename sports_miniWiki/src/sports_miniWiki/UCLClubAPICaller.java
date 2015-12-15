package sports_miniWiki;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class UCLClubAPICaller {
	private ArrayList<UCLClub> clubs;
	private HashMap<String, String> teamAPI;

	public UCLClubAPICaller() throws Exception{
		clubs = new ArrayList<UCLClub>();
		teamAPI = new HashMap<String, String>();
		teamAPI.put("Bayern Munich", "b8c6dc82-0d24-4758-9a85-6586931cfeba");
		teamAPI.put("FCBarcelona", "74b8c4ed-116a-4f73-b673-04d5b8c92447");
		teamAPI.put("Real Madrid", "8337a86d-8c89-4641-bc39-cd4a4dedfd61");
		teamAPI.put("Man City", "4472bef8-8d80-4c13-86b6-b1c60e021724");
		teamAPI.put("Paris Saint-German", "2d0c0cca-445a-4c05-83ce-ffcbf18d3554");
		teamAPI.put("Wolfsburg", "4819069a-cf3a-46a6-84dd-b0e8dccc429c");
		teamAPI.put("Benfica", "3e85e074-47dc-40bd-b8d5-9c9ed8b0b443");
		teamAPI.put("Chelsea", "618e7f40-7a78-47de-afcf-3ad1fee9f677");
		teamAPI.put("Dynamo Kyiv", "fb78bcfc-5df9-4d3f-9097-944b1fa305aa");
		teamAPI.put("Zenit", "21068a55-b3c2-42dd-aa6f-44ef776e9e3d");
		teamAPI.put("Arsenal", "0b97014f-1a82-46d5-bfbf-89857ef8f44a");
		teamAPI.put("Roma", "2f7749b5-88e0-478e-af8c-1efbe47c7ee9");
		teamAPI.put("Gent", "66d8d7de-9fbe-4720-9412-607a388d3d02");
		teamAPI.put("At.Madrid", "3bb38fcd-0cbd-45f2-a133-0aeaab6657b2");
		teamAPI.put("Juventus", "a46fb708-5b9a-48d1-a44b-f4d6e538b2ab");
		teamAPI.put("PSV", "b55b5c50-5e49-4a6e-9fdc-1629e2f141a9");
		
	}
	
	public void getClubProfile() throws Exception {
		for (String uclTeam : teamAPI.keySet()) {
			String reqURL = "http://api.sportradar.us/soccer-t2/eu/teams/" + teamAPI.get(uclTeam) + "/profile.xml?api_key=s7rzcwtqss8bdry9fkmxp88d";
			URL url = new URL(reqURL);
			URLConnection reqConnection = url.openConnection();
			Document doc = parseXML(reqConnection.getInputStream());
			NodeList teamNodes = doc.getElementsByTagName("team");
			NodeList mngNodes = doc.getElementsByTagName("manager");
			NodeList playerNodes = doc.getElementsByTagName("player");
			
			UCLClub newClub = new UCLClub(uclTeam);
			ArrayList<UCLPlayer> newRoster = new ArrayList<UCLPlayer>();
			
			for (int i = 0; i < teamNodes.getLength(); i++) {
				newClub.setName(teamNodes.item(i).getAttributes().getNamedItem("name").getTextContent());
				newClub.setAlias(teamNodes.item(i).getAttributes().getNamedItem("alias").getTextContent());
				newClub.setTeamCountry(teamNodes.item(i).getAttributes().getNamedItem("country").getTextContent());
			}
			
			for (int i = 0; i < mngNodes.getLength(); i++) {
				newClub.setManagerFN(mngNodes.item(i).getAttributes().getNamedItem("first_name").getTextContent());
				newClub.setManagerLN(mngNodes.item(i).getAttributes().getNamedItem("last_name").getTextContent());
				newClub.setManagerCountry(mngNodes.item(i).getAttributes().getNamedItem("country").getTextContent());
				newClub.setManagerBirthDate(mngNodes.item(i).getAttributes().getNamedItem("birthdate").getTextContent());	
			}
			
			for (int i = 0; i < playerNodes.getLength(); i++) {
				String firstName = playerNodes.item(i).getAttributes().getNamedItem("first_name").getTextContent();
				String lastName = playerNodes.item(i).getAttributes().getNamedItem("last_name").getTextContent();
				UCLPlayer newPlayer = new UCLPlayer(firstName, lastName);
				newPlayer.setFirstName(firstName);
				newPlayer.setLastName(lastName);
				newPlayer.setCountry(playerNodes.item(i).getAttributes().getNamedItem("country").getTextContent());
				newPlayer.setPreferredFoot(playerNodes.item(i).getAttributes().getNamedItem("preferred_foot").getTextContent());
				newPlayer.setDateOfBirth(playerNodes.item(i).getAttributes().getNamedItem("birthdate").getTextContent());
				newPlayer.setHeight_cm(playerNodes.item(i).getAttributes().getNamedItem("height_cm").getTextContent());
				newPlayer.setWeight_kg(playerNodes.item(i).getAttributes().getNamedItem("weight_kg").getTextContent());
				newPlayer.setJerseyNumber(playerNodes.item(i).getAttributes().getNamedItem("jersey_number").getTextContent());
				newPlayer.setPosition(playerNodes.item(i).getAttributes().getNamedItem("position").getTextContent());
				newRoster.add(newPlayer);
			}
			
			newClub.setRoster(newRoster);
			clubs.add(newClub);			
		}
	}

	private Document parseXML(InputStream inputStream) throws Exception {
		DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(inputStream);
        }
        catch(Exception ex)
        {
            throw ex;
        }       

        return doc;
		
	}

}
