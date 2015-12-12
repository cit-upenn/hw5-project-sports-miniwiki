package sports_miniWiki;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.json.JSONException;

import java.awt.CardLayout;

import javax.swing.JComboBox;

import java.awt.Color;

public class Sports_miniWiki {

	private JFrame frame;
	private NBA_Schedule scheduleOfNBA;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sports_miniWiki window = new Sports_miniWiki();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Sports_miniWiki() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame("Sports miniWiki");
		frame.setBounds(100, 100, 1280, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel Main_window = new JPanel();
		frame.getContentPane().add(Main_window, "name_75543461813159");
		Main_window.setLayout(null);
		Main_window.setVisible(true);
		
		/*
		 * Caller to APIs.
		 */
		NBALeagueLeaders nbaLeaders = new NBALeagueLeaders();
		
		/*
		 * This is the FIFA page.
		 */
		final JPanel FIFA = new JPanel();
		frame.getContentPane().add(FIFA, "name_75551392776245");
		FIFA.setLayout(null);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FIFA.setVisible(false);
				Main_window.setVisible(true);
			}
		});
		btnHome.setBounds(25, 25, 120, 40);
		FIFA.add(btnHome);
		
		JLabel lblFifabackground = new JLabel("FIFA_background");
		lblFifabackground.setIcon(new ImageIcon(this.getClass().getResource("/resources/FIFA_background.jpg")));
		lblFifabackground.setBounds(-29, 6, 1280, 720);
		FIFA.add(lblFifabackground);
		FIFA.setVisible(false);
		
		
		/*
		 * This is the NBA page.
		 */
		final JPanel NBA = new JPanel();
		frame.getContentPane().add(NBA, "name_75555177344305");
		NBA.setLayout(null);
		
		
		JButton btnHome_1 = new JButton("Home");
		btnHome_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnHome_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(false);
				Main_window.setVisible(true);
			}
		});
		btnHome_1.setBounds(25, 25, 120, 40);
		NBA.add(btnHome_1);
		
		// A sub-page in NBA.
		JPanel NBA_leaders = new JPanel();
		frame.getContentPane().add(NBA_leaders, "name_111499636225905");
		NBA_leaders.setLayout(null);
		
		JComboBox<String> comboBoxLeaders = new JComboBox<String>();
		comboBoxLeaders.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		comboBoxLeaders.setBounds(700, 90, 200, 30);
		NBA_leaders.add(comboBoxLeaders);
		
		for (String category: nbaLeaders.categories) {
			comboBoxLeaders.addItem(category);
		}
		
		JTextArea text = new JTextArea(10, 45);
		text.setVisible(true);
		text.setEditable(false);
		text.setFont(new Font("Serif", Font.BOLD, 26));
		JScrollPane sp = new JScrollPane(text);
		
		sp.setBounds(240, 130, 800, 500);
		NBA_leaders.add(sp);
		
		comboBoxLeaders.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboBoxLeaders) {
					JComboBox<String> cb = (JComboBox<String>) e.getSource();
			        String selected = (String)cb.getSelectedItem();
			        
			        switch (selected) {
			        	case "points": 
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.pointsLeaders) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
			        	case "assists":
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.assistsLeaders) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
			        	case "threePoints": 
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.threePointsLeaders) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
			        	case "rebounds":
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.reboundsLeaders) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
			        	case "freeThrow":
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.freeThrowLeaders) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
			        	case "blocks":
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.blocksLeaders) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
			        	case "steals":
			        		text.setText(null);
			        		for (NBALeaders_Individual lead: nbaLeaders.stealsLeaders) {					        	
				        		text.append(" " + lead.toString() + "\n");
								text.append("\n");
				        	}	
			        		break;
					}
			        	
				}
			        
			}
			
			
		}); 

//		comboBoxLeaders.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent event) {
//				if (event.getStateChange() == ItemEvent.SELECTED) {
//					
//					for (NBALeaders_Individual lead: nbaLeaders.pointsLeaders) {			        	
//						text.setText(" " + lead.toString() + "\n");
//						text.append("\n");			        					
//					}
//				}
//			}
//		});
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(true);
				Main_window.setVisible(false);
				NBA_leaders.setVisible(false);
			}
		});
		btnBack_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnBack_3.setBounds(25, 25, 120, 40);
		NBA_leaders.add(btnBack_3);
		
		JLabel lblSelectTheItem = new JLabel("Select item from the list:");
		lblSelectTheItem.setForeground(Color.WHITE);
		lblSelectTheItem.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblSelectTheItem.setBounds(300, 90, 400, 30);
		NBA_leaders.add(lblSelectTheItem);
		
		JLabel lblNbaleadersbackground = new JLabel("NBA_leaders_background");
		lblNbaleadersbackground.setIcon(new ImageIcon(this.getClass().getResource("/resources/NBA_players_trophy.jpg")));
		lblNbaleadersbackground.setBounds(0, 0, 1280, 720);
		NBA_leaders.add(lblNbaleadersbackground);
		
		
		// A sub-page in NBA which displays NBA player profile.
		
		JPanel NBA_players = new JPanel();
		frame.getContentPane().add(NBA_players, "name_111060986091776");
		NBA_players.setLayout(null);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(true);
				Main_window.setVisible(false);
				NBA_players.setVisible(false);
			}
		});
		btnBack_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnBack_1.setBounds(25, 25, 120, 40);
		NBA_players.add(btnBack_1);
		
		JLabel lblNbaplayersbackground = new JLabel("NBA_players_background");
		lblNbaplayersbackground.setIcon(new ImageIcon(this.getClass().getResource("/resources/NBA_Logo.jpg")));
		lblNbaplayersbackground.setBounds(0, 0, 1280, 720);
		NBA_players.add(lblNbaplayersbackground);
		
		
		// A sub-page in NBA which displays NBA schedule in 2015-2016 season.
		
		JPanel NBA_schedule = new JPanel();
		frame.getContentPane().add(NBA_schedule, "name_111337211737580");
		NBA_schedule.setLayout(null);
		
		
		scheduleOfNBA = new NBA_Schedule();
		
		JComboBox<String> comboBoxDate = new JComboBox<String>();
		comboBoxDate.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		comboBoxDate.setBounds(820, 90, 200, 30);
		NBA_schedule.add(comboBoxDate);
		
		for (int i = 0; i < scheduleOfNBA.dates.size(); i++) {
			comboBoxDate.addItem(scheduleOfNBA.dates.get(i));
		}
		
		JTextArea textArea = new JTextArea(10, 45);
		textArea.setVisible(true);
		textArea.setEditable(false);
		textArea.setFont(new Font("Serif", Font.BOLD, 26));
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		scrollPane.setBounds(140, 130, 1000, 500);
		NBA_schedule.add(scrollPane);
		
		for (NBASchedule_Individual game: scheduleOfNBA.schedule) {
			textArea.append(" " + game.toString() + "\n");
			textArea.append("\n");
        				
		}
		
		comboBoxDate.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboBoxDate) {
					textArea.setText(null);
					JComboBox<String> cb = (JComboBox<String>) e.getSource();
			        String selectedDate = (String)cb.getSelectedItem();
			        ArrayList<NBASchedule_Individual> temp = new ArrayList<NBASchedule_Individual>();
			        for (NBASchedule_Individual game: scheduleOfNBA.schedule) {
			        	if (game.getDate() == selectedDate) {
			        		temp.add(game);      		
			        	}				
					}
			        
			        for (NBASchedule_Individual game: temp) {
						textArea.append(" " + game.toString() + "\n");
						textArea.append("\n");
			        				
					}
				}
			}
			
		}); 
//		comboBoxDate.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent event) {
//				if (event.getStateChange() == ItemEvent.SELECTED) {
//					
//					for (NBASchedule_Individual game: scheduleOfNBA.schedule) {
//			        	if (game.getDate() == comboBoxDate.getSelectedItem()) {
//			        		textArea.setText(" " + game.toString() + "\n");
//							textArea.append("\n");
//			        	}				
//					}
//				}
//			}
//		});
			
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(true);
				Main_window.setVisible(false);
				NBA_schedule.setVisible(false);
			}
		});
		btnBack_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnBack_2.setBounds(25, 25, 120, 40);
		NBA_schedule.add(btnBack_2);
		
		JLabel lblInstruction = new JLabel("View complete 2015-16 schedule below or select date from right:");
		lblInstruction.setForeground(Color.BLUE);
		lblInstruction.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblInstruction.setBounds(170, 90, 620, 30);
		NBA_schedule.add(lblInstruction);
		
		JLabel lblNbaschedulebackground = new JLabel("NBA_schedule_background");
		lblNbaschedulebackground.setIcon(new ImageIcon(this.getClass().getResource("/resources/NBA_court.jpg")));
		lblNbaschedulebackground.setBounds(0, 0, 1280, 720);
		NBA_schedule.add(lblNbaschedulebackground);
		
		
		// A sub-page in NBA.
		JPanel NBA_teams = new JPanel();
		frame.getContentPane().add(NBA_teams, "name_110655200741455");
		NBA_teams.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(true);
				Main_window.setVisible(false);
				NBA_teams.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnBack.setBounds(25, 25, 120, 40);
		NBA_teams.add(btnBack);
		
		JLabel lblNbateambackground = new JLabel("NBATeamBackground");
		lblNbateambackground.setIcon(new ImageIcon(this.getClass().getResource("/resources/NBA_team_logos.jpg")));
		lblNbateambackground.setBounds(-53, -19, 1280, 720);
		NBA_teams.add(lblNbateambackground);
		
		
		JButton btnTeamProfile = new JButton("Team Profile");
		btnTeamProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(false);
				Main_window.setVisible(false);
				NBA_teams.setVisible(true);
			}
		});
		btnTeamProfile.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnTeamProfile.setBounds(150, 510, 200, 80);
		NBA.add(btnTeamProfile);
		
		JButton btnPlayerProfile = new JButton("Player Profile");
		btnPlayerProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(false);
				Main_window.setVisible(false);
				NBA_players.setVisible(true);
			}
		});
		btnPlayerProfile.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnPlayerProfile.setBounds(150, 400, 200, 80);
		NBA.add(btnPlayerProfile);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(false);
				Main_window.setVisible(false);
				NBA_schedule.setVisible(true);
			}
		});
		btnSchedule.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnSchedule.setBounds(150, 290, 200, 80);
		NBA.add(btnSchedule);
		
		JButton buttonLeaders = new JButton("Leaders");
		buttonLeaders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(false);
				Main_window.setVisible(false);
				NBA_leaders.setVisible(true);
			}
		});
		buttonLeaders.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		buttonLeaders.setBounds(150, 180, 200, 80);
		NBA.add(buttonLeaders);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/resources/NBA_trophy.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1280, 720);
		NBA.add(lblNewLabel_1);
		NBA.setVisible(false);
		
		
		/*
		 * This is the tennis page.
		 */
		final JPanel ATP_WTA = new JPanel();
		ATP_WTA.setBackground(Color.WHITE);
		frame.getContentPane().add(ATP_WTA, "name_75561060277162");
		ATP_WTA.setLayout(null);
		
		JButton btnHome_2 = new JButton("Home");
		btnHome_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnHome_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATP_WTA.setVisible(false);
				Main_window.setVisible(true);
			}
		});
		btnHome_2.setBounds(25, 25, 120, 40);
		ATP_WTA.add(btnHome_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/atp_world_tour_brand_mark-converted_1024.jpg")));
		lblNewLabel_2.setBounds(131, 78, 454, 490);
		ATP_WTA.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 =  new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Sports_miniWiki.class.getResource("/resources/Women’s-Tennis-Association-Logo.jpg")));
		lblNewLabel_3.setBounds(620, 60, 660, 602);
		ATP_WTA.add(lblNewLabel_3);
		
		JButton goToATPpanel = new JButton("ATP");
		goToATPpanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_window.setVisible(false);
				ATP_WTA.setVisible(false);
				
				
			}
		});
		goToATPpanel.setBounds(305, 597, 117, 29);
		ATP_WTA.add(goToATPpanel);
		
		
		JButton btnFifa = new JButton("FIFA");
		btnFifa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FIFA.setVisible(true);
				Main_window.setVisible(false);
			}
		});
		btnFifa.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnFifa.setBounds(200, 520, 200, 80);
		Main_window.add(btnFifa);
		
		JButton btnNba = new JButton("NBA");
		btnNba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NBA.setVisible(true);
				Main_window.setVisible(false);
			}
		});
		btnNba.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnNba.setBounds(540, 520, 200, 80);
		Main_window.add(btnNba);
		
		
		JButton btnAtpWta = new JButton("ATP & WTA");
		btnAtpWta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATP_WTA.setVisible(true);
				Main_window.setVisible(false);
			}
		});
		btnAtpWta.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnAtpWta.setBounds(880, 520, 200, 80);
		Main_window.add(btnAtpWta);
		
		JLabel lblNewLabel = new JLabel("background");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/resources/Sports_background.jpg")));
		lblNewLabel.setSize(720, 480);
		lblNewLabel.setBounds(0, 0, 1280, 720);
		Main_window.add(lblNewLabel);

	}
}
