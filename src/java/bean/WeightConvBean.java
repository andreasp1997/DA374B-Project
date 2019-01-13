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
public class WeightConvBean {

    public double P2K(double value) {
        double kilogram;
        kilogram = value * 0.45359237;
        return kilogram;
    }

    public double K2P(double value) {
        double pound;
        pound = value / 0.45359237;
        return pound;
    }
    
    public double K2MG(double value) {
        double mg;
        mg = value * 1000000;
        return mg;
    }
    
    public double MG2K(double value) {
        double kilo;
        kilo = value / 1000000;
        return kilo;
    }
    
    public double K2O(double value)  {
        double ounces;
        ounces = value * 35.2739619;
        return ounces;
    }
    
    public double O2K(double value) {
        double kilo;
        kilo = value / 35.2739619;
        return kilo;
    }
    
    public double P2O(double value) {
        double ounces;
        ounces = value * 16;
        return ounces;
    }
    
    public double O2P(double value){
        double pounds;
        pounds = value / 16;
        return pounds;
    }
    
    public double P2MG(double value) {
        double mg;
        mg = value * 453592.37;
        return mg;
    }
    
    public double MG2P(double value) {
        double pounds;
        pounds = value / 453592.37;
        return pounds;
    }
    
    public double MG2O(double value) {
        double ounces;
        ounces = value / 28349.5231;
        return ounces;
    }
    
    public double O2MG(double value) {
        double mg;
        mg = value * 28349.5231;
        return mg;
    }
    
    
    
}
