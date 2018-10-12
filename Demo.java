package week1.vrijdag.code_samen;

public class Demo {

	public static void main(String[] args) {
		Toernooi karateToernooi = new Toernooi();
		karateToernooi.setNaam("Jochiro");
		karateToernooi.welkom();
		
		
	}

}

class Toernooi{
	String naam;
	
	void welkom() {
		System.out.println("Welkom bij " + naam);
	}
	void setNaam(String naam) {
		this.naam = naam;
	}
	
}
