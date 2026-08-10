package MenghitungDerajat;

public class Termometer {
    private double celcius;

    public Termometer(double celcius) {
        this.celcius = celcius;
    }

    public void setCelcius(double celcius) {
        this.celcius = celcius;
    }

    public double getCelcius() {
        return celcius;
    }

    public double keFahrenheit() {
        return (celcius * 9 / 5) + 32;
    }

    public double keReamur() {
        return celcius * 4 / 5;
    }

    public double keKelvin() {
        return celcius + 273.15;
    }
}