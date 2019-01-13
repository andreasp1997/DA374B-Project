/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateful;

/**
 *
 * @author andreas
 */
@Stateful
public class VolumeConvBean {

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
    
    public double L2Q(double value){
        double quarts;
        quarts = value * 1.05668821;
        return quarts;
    }
    
    public double Q2L(double value) {
        double liters;
        liters = value / 1.05668821;
        return liters;
    }
    
    public double L2CL(double value) {
        double cl;
        cl = value * 100;
        return cl;
    }
    
    public double CL2L(double value) {
        double liter;
        liter = value / 100;
        return liter;
    }
    
    public double G2Q(double value) {
        double quarts;
        quarts = value *4;
        return quarts;
    }
    
    public double Q2G(double value) {
        double gallons;
        gallons = value / 4;
        return gallons;
    }
    
    public double G2CL(double value) {
        double cl;
        cl = value * 378.541178;
        return cl;
    }
    
    public double CL2G(double value) {
        double gallons;
        gallons = value / 378.541178;
        return gallons;
    }
    
    public double CL2Q(double value) {
        double quarts;
        quarts = value * 0.0105668821;
        return quarts;
    }
    
    public double Q2CL(double value) {
        double cl;
        cl = value / 0.0105668821;
        return cl;
    }
    
}
