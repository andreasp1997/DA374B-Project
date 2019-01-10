/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;

/**
 *
 * @author Jun
 */
@Stateless
public class ConversionBean {

    public double F2C(double value) {
        double celcius;
        celcius = ((value-32)*5)/ 9;
        return celcius;
    }

    public double C2F(double value) {
        double fahrenheit;
        fahrenheit = ((value * 9) / 5) + 32;
        return fahrenheit;
    }

    public double F2M(double value) {
        double meter;
        meter = value * 0.3048;
        return meter;
    }

    public double M2F(double value) {
        double feet;
        feet = value / 0.3048;
        return feet;
    }

    public double K2P(double value) {
        double pound;
        pound = value / 0.45359237;
        return pound;
    }

    public double P2K(double value) {
        double kilogram;
        kilogram = value * 0.45359237;
        return kilogram;
    }

    public double L2G(double value) {
        double gallon;
        gallon = value * 0.264172;
        return gallon;
    }

    public double G2L(double value) {
        double liter;
        liter = value /  0.264172;
        return liter;
    }

    public double BY2BI(double value) {
        double bit;
        bit = value * 8;
        return bit;
    }

    public double BI2BY(double value) {
        double bytes;
        bytes = value / 8;
        return bytes;
    }
    
}
