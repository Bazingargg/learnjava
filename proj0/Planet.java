public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public double calcDistance(Planet p) {
		double dx = p.xxPos - xxPos;
		double dy = p.yyPos - yyPos;
		double r = Math.sqrt(dx * dx + dy * dy);
		return r;
	}

	public double calcForceExertedBy(Planet p) {
		double r = calcDistance(p);
		double force = (G * mass * (p.mass))/(r * r);
		return force;
	}

	public double calcForceExertedByX(Planet p) {
		double force = calcForceExertedBy(p);
		double dx = p.xxPos - xxPos;
		double r = calcDistance(p);
		double forceByX = (force * dx) / r;
		return forceByX;
	}

	public double calcForceExertedByY(Planet p) {
		double force = calcForceExertedBy(p);
		double dy = p.yyPos - yyPos;
		double r = calcDistance(p);
		double forceByY = (force * dy) / r;
		return forceByY;
	}

	public double calcNetForceExertedByX(Planet[] planets) {
		double forceX = 0;
		for (Planet pl : planets) {
			if (this.equals(pl)) {
				continue;
			}
			forceX += this.calcForceExertedByX(pl);
		}
		return forceX;
	}

	public double calcNetForceExertedByY(Planet[] planets) {
		double forceY = 0;
		for (Planet pl : planets) {
			if (this.equals(pl)) {
				continue;
			}
			forceY += this.calcForceExertedByY(pl);
		}
		return forceY;
	}	

	public void update(double dt, double fX, double fY) {
		/**接下来需要更新星球的速度 */
		double ax = fX / mass;
		double ay = fY / mass;
		xxVel = xxVel + ax * dt;
		yyVel = yyVel + ay * dt;
		/**更新星球的位置 */
		xxPos = xxVel * dt + xxPos;
		yyPos = yyVel * dt + yyPos;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

}