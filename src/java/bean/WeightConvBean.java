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

    
}
