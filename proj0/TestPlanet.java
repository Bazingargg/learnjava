public class TestPlanet {
	public static void main(String[] args) {
		Planet p1 = new Planet(1, 1, 2, 0, 3, "lala");
		Planet p2 = new Planet(3, 3, -5, 0, 2, "haha");
		double d1 = p1.calcDistance(p2);
		double d2 = p2.calcDistance(p1);
		double f1 = p1.calcForceExertedByX(p2);
		double f2 = p2.calcForceExertedByY(p1);
		double f_1 = p1.calcForceExertedBy(p2);
		System.out.printf("两个星球间的距离是%f%n两个星球间的距离是%f%n", d1, d2);
		System.out.printf("两个星球之间的作用力是%e", f_1);
		if (f1 * f1 + f2 * f2 == f_1 * f_1) {
			System.out.printf("程序运行正常！");
			System.out.println("这句话仅仅是为了测试是否还有%富豪");
			System.out.printf("难道是printf有问题？");
		} 
	}
}