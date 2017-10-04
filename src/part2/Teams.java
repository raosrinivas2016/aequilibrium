/*---    Battle between Autobot and Decepticons*/


package part2;
import java.math.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Teams {


	public static void main(String[] args) {

		//add as many transformers as needed from both teams
		//add id's so it easy to handle duplicates
		Transformer t1=new Transformer(101,"Optimus Prime",10, 10, 8, 10, 10, 8, 10, 10);
		Transformer t2=new Transformer(102,"prowl",7, 5, 8, 8, 7, 6, 4, 8);
		Transformer t3=new Transformer(103,"Punch",8, 4, 5, 6, 4, 7, 4, 4);
		Transformer t4=new Transformer(104,"Predaking",10, 5, 8, 8, 7, 9, 9, 8);
		Transformer t5=new Transformer(105,"Shockwave",4, 5, 5, 8, 4, 3, 4, 7);
		Transformer t6=new Transformer(106,"Sixshot",9, 9, 5, 6, 8, 7, 9, 9);


		List<Transformer> Autobot=new ArrayList<Transformer>();
		List<Transformer> Deception=new ArrayList<Transformer>();
		Autobot.add(t1);
		Autobot.add(t2);
		Autobot.add(t3);
		Deception.add(t4);
		Deception.add(t5);
		Deception.add(t6);


		Teams t=new Teams();
		t.SortedTeamsbyranking(Autobot);
		t.SortedTeamsbyranking(Deception);

		//Temporary variables for handling intermediate operations
		Transformer t21=null,t22=null,winning_transformer=null,loosing_transformer=null;
		int noof_battles=1,autobot_win=0,deception_win=0,id=0,autobotid=0,deceptionid=0,tie=0;

		do{// in case you want to battle x no of times,validate loop accordingly at the end of do-while loop
			Scanner s=new Scanner(System.in);
			String format="%15d %-18s %9d %13d %10d %10d %10d %7d %7d %7d %8d \n";
			System.out.println("\n 		Select Transformer from Autobot and Deception By their ID's 	\n");

			System.out.println("Transformer ID||Transformer Name: ||overAll Rating||Strength||Intelligence||Speed||Endurance||Rank||Courage||FirePower||Skill");
			for (Transformer aut : Autobot) 
				System.out.format(format,aut.getID(),aut.getName(),aut.overallRating(),aut.getStrength(),aut.getIntelligence(),aut.getSpeed(),aut.getEndurance(),aut.getRank(),aut.getCourage(),aut.getFirepower(),aut.getSkill());

			System.out.println("1.Team-Autobot :Select Transfomer By Entering corrosponding ID");
			autobotid=s.nextInt();

			//minor validation for valid autobot id
			while(Math.abs(autobotid)<100 || Math.abs(autobotid)>104){
				System.out.println("enter valid Autobot ID");
				autobotid=s.nextInt();
			}

			for(Transformer Atra:Autobot){
				if(Atra.getID()==autobotid){
					t21=Atra;
					break;}
			}

			System.out.println("\n 2:Team-Decepticons Select Transfomer By Entering corrosponding ID");
			System.out.println("Transformer ID||Transformer Name: ||overAll Rating||Strength||Intelligence||Speed||Endurance||Rank||Courage||FirePower||Skill");
			for (Transformer dec : Deception) 
				System.out.format(format,dec.getID(),dec.getName(),dec.overallRating(), dec.getStrength(),dec.getIntelligence(),dec.getSpeed(),dec.getEndurance(),dec.getRank(),dec.getCourage(),dec.getFirepower(),dec.getSkill());


			deceptionid=s.nextInt();

			//minor validation for valid decepticons id
			while(Math.abs(deceptionid)<103 || Math.abs(deceptionid)>106){
				System.out.println("enter valid Deception ID ");
				deceptionid=s.nextInt();
			}

			for(Transformer Dtra:Deception){

				if(Dtra.getID()==deceptionid){
					t22=Dtra;
					break;}
			}

			//call battle between Autobots and Decepticons
			winning_transformer=t.battle(t21, t22);
			if(winning_transformer==null)
				tie=1;
			else if(winning_transformer.getID()==t21.getID())
				loosing_transformer=t22;
			else if(winning_transformer.getID()==t22.getID())
				loosing_transformer=t21;
			if(winning_transformer!=null){
				if(winning_transformer.getID()<104)
					autobot_win++;
				else if(winning_transformer.getID()>103 && winning_transformer.getID()<107)
					deception_win++;
			}
			noof_battles++;
		}while(noof_battles<=1);	

		System.out.println("no of battles : "+(noof_battles-1));
		if(noof_battles-1<2){
			if(autobot_win>deception_win){
				System.out.println("Winning team(autobots):"+winning_transformer.getName());
				System.out.println("Survivors from the losing team(Decepticons)"+loosing_transformer.getName());
			}
			else if(deception_win>autobot_win){
				System.out.println("Winning team(autobots):"+winning_transformer.getName());
				System.out.println("Survivors from the losing team(Decepticons)"+loosing_transformer.getName());
			}
			else
				System.out.println("its tie ;none of them won");
		}

		else if(noof_battles>2)
		{
			if(autobot_win>deception_win){
				System.out.println("Winning team is autobots, no of games won : "+autobot_win);
				System.out.println("losing team is Decepticon");}
			else if(deception_win>autobot_win){
				System.out.println("Winning team is Decepticons, no of games won : "+deception_win);
				System.out.println("losing team is autobot");
			}
			else{
				System.out.println("its tie ;none of them won any match");}
		}	

	}





	/*			System.out.println("over all rating for both transformers :"+t1.overallRating()+","+t2.overallRating());
	}*/

	public void  SortedTeamsbyranking(List Teamslist)
	{
		Collections.sort(Teamslist);

	}



	public Transformer battle(Transformer t21,Transformer t22)
	{


		int x,y,z;
		Transformer tx1=t21,ty1=t22;

		x=tx1.getCourage()-ty1.getCourage();
		y=tx1.getStrength()-ty1.getStrength();
		z=tx1.getSkill()-ty1.getSkill();

		if(tx1.getName().equals("Optimus Prime")||tx1.getName().equals("Predaking"))
			return tx1;
		if(ty1.getName().equals("Optimus Prime")||ty1.getName().equals("Predaking"))
			return ty1;
		if(tx1.getName().equals("Optimus Prime")&& ty1.getName().equals("Predaking"))
			return null;
		if(tx1.getName().equals("Predaking")&& ty1.getName().equals("Optimus Prime"))
			return null;



		if(x==4||y==3||z==3){
			//System.out.println(tx1.getName()+" : tx1 is winner");
			return tx1;}				

		else if(x==-4||y==-3||z==-3){
			//System.out.println(ty1.getName()+" : ty1 is winner");
			return ty1;}

		else if(tx1.overallRating()>ty1.overallRating()){
			//System.out.println(tx1.getName()+" : tx1 is winner");
			return tx1;
		}

		else if(tx1.overallRating()>ty1.overallRating()){
			//System.out.println(ty1.getName()+" : ty1 is winner");
			return ty1;}
		else
			System.out.println("its a tie ; both transformers are destroyed");
		return null;
	}



}







