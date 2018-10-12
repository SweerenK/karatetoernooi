package week1.vrijdag.code_samen;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		 System.out.println("Leuk dat je een tournooi organiseert. \n Hoe heet je tournooi?");
		 Scanner scanner = new Scanner(System.in); String naamTournooi =
		 scanner.nextLine(); Tournooi karateTournooi = new Tournooi();
		 karateTournooi.setNaam(naamTournooi); karateTournooi.welkom();
		
	
		System.out.println("Wil u al mensen aanmelden? \n 1 ja 2 nee");
		int antwoordNogEen = scanner.nextInt();
		if (antwoordNogEen == 1) {
			System.out.println("je hebt 1 gedrukt");
			karateTournooi.voegDeelnemersToe();
		} else {
			System.out.println("wordt een kort tournooi");
		}
	
		//Tournooi karateTournooi = testToernooi.testData();
		
		//HIER
		
		while(karateTournooi.deelnemers.size() > 1) {
			if(karateTournooi.deelnemers.size() == 2) {
				System.out.println("Wat een spanning dames en heren. De finale gaat tussen " + karateTournooi.deelnemers.get(0)
				+ " en " + karateTournooi.deelnemers.get(1));	
			}
			karateTournooi.speelWedstrijd();
			System.out.println(karateTournooi.deelnemers);
			
		}
	}
}

class Tournooi {
	String naam;
	ArrayList<Deelnemer> deelnemers = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();

	void welkom() {
		System.out.println("Welkom bij " + naam);
	}

	void setNaam(String naam) {
		this.naam = naam;
	}

	void voegDeelnemersToe() {

		System.out.print("Wat is uw naam");
		String deNaam = scanner.next();
		Deelnemer deelnemer = new Deelnemer(deNaam);
		deelnemers.add(deelnemer);
		System.out.println("Wilt u nog iemand aanmelden?\n 1 ja 2 nee");
		int antwoordNogEen = scanner.nextInt();
		if (antwoordNogEen == 1) {
			voegDeelnemersToe();
		} else {
			
			//HIER
			
			shuffleDeelnemers();
		}
	}

	Deelnemer speelWedstrijd() {
		System.out.println("Lets get ready to rumble");
		System.out.println(deelnemers.get(0).naam + " speelt tegen " + deelnemers.get(1).naam);
		Deelnemer winnaar = deelnemers.get(random.nextInt(2));
		System.out.println("De winnaar is: " + winnaar.naam);
		deelnemers.add(deelnemers.size(), winnaar);
		deelnemers.remove(0);
		deelnemers.remove(0);
		return winnaar;
	}

	void shuffleDeelnemers() {
		Collections.shuffle(deelnemers);
		int z = deelnemers.size();
		for(int y = 0; y < z ; y+=2) {
			System.out.println(deelnemers.get(y).naam + " speelt tegen " + deelnemers.get(y+1).naam);
		}
	}
}

class Deelnemer {
	String naam;

	Deelnemer(String deNaam) {
		naam = deNaam;
	}

	@Override
	public String toString() {
		return naam;
	}
}

class testToernooi {
	static Tournooi testData() {
		Deelnemer deelnemer1 = new Deelnemer("fred");
		Deelnemer deelnemer2 = new Deelnemer("jan");
		Deelnemer deelnemer3 = new Deelnemer("piet");
		Deelnemer deelnemer4 = new Deelnemer("kees");
		Tournooi toernooi1 = new Tournooi();
		toernooi1.setNaam("demoTournooi");
		toernooi1.deelnemers.add(deelnemer1);
		toernooi1.deelnemers.add(deelnemer2);
		toernooi1.deelnemers.add(deelnemer3);
		toernooi1.deelnemers.add(deelnemer4);
		toernooi1.shuffleDeelnemers();
		return toernooi1;
	}
}