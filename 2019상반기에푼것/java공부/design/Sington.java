
public class Main {
	public static void main(String[] argv) {
		System.out.println(Sington.getInstance());
		System.out.println(Sington.getInstance());

		Sington s = new Sington();
		System.out.println(s.getInstance());
		s.changeInstance();
		System.out.println(s.getInstance());
		System.out.println(Sington.getInstance());
	}
}

class Sington {
	private static Sington instance;

	public Sington() {
	}

	public static Sington getInstance() {
		if (instance == null) {
			synchronized (Sington.class) {
				if (instance == null) {
					instance = new Sington();
				}
			}
		}
		return instance;
	}

	public Sington changeInstance() {
		this.instance = new Sington();
		return instance;
	}
}