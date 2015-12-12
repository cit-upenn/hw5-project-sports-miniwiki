package sports_miniWiki;

import java.util.ArrayList;
import java.util.HashMap;

public class TennisPlayerTester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		GetTennisPlayerInfo playerInfo = new GetTennisPlayerInfo();
		
		//ArrayList<TennisPlayer> apt = playerInfo.getTop10ATPplayers();
		ArrayList<TennisPlayer> wta = playerInfo.getTop10WTAplayers();

		for(TennisPlayer element : wta) {
			System.out.println(element.getName());
			System.out.println(element.getRanking());
			System.out.println(element.getRanking_points());
			HashMap<String, String> myhash = element.getTournament_round();
			for (String key : myhash.keySet()) {
				System.out.println(key + "     " + myhash.get(key));
			}
		}
		
	}

}
