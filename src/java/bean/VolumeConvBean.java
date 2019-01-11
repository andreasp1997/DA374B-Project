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

    
}
