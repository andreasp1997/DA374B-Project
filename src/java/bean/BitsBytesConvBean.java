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
public class BitsBytesConvBean {

    public double BI2BY(double value) {
        double bytes;
        bytes = value / 8;
        return bytes;
    }

    public double BY2BI(double value) {
        double bit;
        bit = value * 8;
        return bit;
    }

    
}
