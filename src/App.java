public class App {
    public static void main(String[] args) throws Exception {
        OperasiBilangan opl = new OperasiBilangan();

        opl.setA(10);
        opl.setB(20);
        opl.info();
        System.out.println(opl.getA() + " + " + opl.getB() + " = " + opl.getHasil());
        System.out.println(opl.getA() + " - " + opl.getB() + " = " + opl.getHasil());
        System.out.println(opl.getA() + " * " + opl.getB() + " = " + opl.getHasil());
        System.out.println(opl.getA() + " / " + opl.getB() + " = " + opl.getHasil());
        System.out.println(opl.getA() + " % " + opl.getB() + " = " + opl.getHasil());
    }
}
