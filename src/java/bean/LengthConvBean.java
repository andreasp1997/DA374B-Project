/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;

/**
 *
 * @author andreas
 */
@Stateless
public class LengthConvBean {

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
    
    public double M2CM(double value) {
        double cm;
        cm = value * 100;
        return cm;
    }
    
    public double CM2M(double value) {
        double meter;
        meter = value / 100;
        return meter;
    }
    
    public double M2IN(double value) {
        double inches;
        inches = value *39.3700787;
        return inches;
    }
    
    public double IN2M(double value) {
        double meter;
        meter = value / 39.3700787;
        return meter;
    }
    
    public double F2IN(double value) {
        double inches;
        inches = value *12;
        return inches;
               
    }
    
    public double IN2F(double value) {
        double feet;
        feet = value / 12;
        return feet;
    }
    
    public double F2CM(double value) {
        double cm;
        cm = value * 32.48;
        return cm;
    }
    
    public double CM2F(double value) {
        double feet;
        feet = value / 32.48;
        return feet;
    }
    
    public double IN2CM(double value) {
        double cm;
        cm = value * 2.54;
        return cm;
    }
    
    public double CM2IN(double value) {
        double inches;
        inches = value / 2.54;
        return inches;
    }

}
