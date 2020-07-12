package org.sachindramaharjan.chaining;

public class Temperature {

    private int temp;

    public Temperature(int temp) {
        this.temp = temp;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Temperature [temp=" + temp + "]";
    }

}