package Exam2_review;

public class hehe {
	
	public static void main(String[] args) {
		
//		Playable a = new Horn();
//		a.play();
		
//		Playable p = new Horn();
//		System.out.println(p.getName());
		
//		FrenchHorn f = new FrenchHorn();
//		f.toot();
		
//		Horn h = new FrenchHorn();
//		h.play();
		
//		Instrument i = new Horn();
//		i.toot();
		
//		Instrument i = new Instrument("Bassoon");
//		System.out.println(i.getName());
		
		Playable p = new Horn();
		FrenchHorn f;
		
		f = (FrenchHorn) p;
		f.play();
//		System.out.println(p.getName());

	}
}


