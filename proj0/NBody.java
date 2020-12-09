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
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "images/starfield.jpg"); 
		// 成功了，路径上的“ ./ ”可有可没有，以及我把背景画出来了
		// 先画背景，再画星球，这样就不会cover掉。
		for (Planet p : planets) {
			p.draw();
		}
		StdDraw.enableDoubleBuffering();
		double time = 0.0;
		while (time < T) {
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for (int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for (int i = 0; i < planets.length; i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.clear();
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for (Planet p : planets) {
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time = time + dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
							planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, 
							planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}
	}

}





























