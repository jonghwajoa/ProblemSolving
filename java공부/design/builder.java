
public class sync {
	public static void main(String[] argv) {

		Something1 test = new Something1.Builder().setName("das").setNumber(55).build();
		System.out.println(test.toString());

	}
}

class Something1 {
	private int number;
	private String name;
	private double size;

	private Something1(int number, String name, double size) {
		this.number = number;
		this.name = name;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Something1 [number=" + number + ", name=" + name + ", size=" + size + "]";
	}

	public static class Builder {
		private int number;
		private String name;
		private double size;

		public Builder() {
			this.number = 0;
			this.name = null;
			this.size = 0d;
		}

		public Builder setNumber(int number) {
			this.number = number;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setSize(double size) {
			this.size = size;
			return this;
		}

		public Something1 build() {
			return new Something1(number, name, size);
		}
	}
}
