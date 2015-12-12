package sports_miniWiki;

import java.util.ArrayList;
import java.util.HashMap;

public class TennisScheduleTester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		GetTennisSchedule scheduleInfo = new GetTennisSchedule();
		
		//HashMap<String, ArrayList<TennisLeagueSchedule>> atp = scheduleInfo.getATPschedule();
		HashMap<String, ArrayList<TennisLeagueSchedule>> wta = scheduleInfo.getWTAschedule();

		for(String element : wta.keySet()) {
			System.out.println(element);
			ArrayList<TennisLeagueSchedule> month_schedule = wta.get(element);
			
			for (TennisLeagueSchedule tournament : month_schedule) {
				System.out.println(tournament.getName());
				System.out.println(tournament.getStart());
				System.out.println(tournament.getEnd());
				System.out.println(tournament.getGround());
				System.out.println(tournament.getType());
				System.out.print(tournament.getPrize() + "   ");
				System.out.println(tournament.getCurrency());
				
				
			}
		
		}
		
	}

}
