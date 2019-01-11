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
    
}
