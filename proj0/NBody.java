public class NBody {
	public static double readRadius(String filename) {
		In in = new In(filename);
		int firstline = in.readInt(); //我不知道需不需要把第一行的数字读出来
		double radius = in.readDouble();
		return radius; 
	}

	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		int num = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[num];
		for (int i = 0; i < num; i++) {
			double num1 = in.readDouble();
			double num2 = in.readDouble();
			double num3 = in.readDouble();
			double num4 = in.readDouble();
			double num5 = in.readDouble();
			String num6 = in.readString();
			planets[i] = new Planet(num1, num2, num3, num4, num5, num6);
		}
		return planets;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		
	}

}