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
public class TimeConvBean {

    public double H2M(double value) {
        double minutes;
        minutes = value * 60;
        return minutes;
    }

    public double M2H(double value) {
        double hours;
        hours = value / 60;
        return hours;
    }

    public double S2H(double value) {
        double hours;
        hours = value / 3600;
        return hours;
             
    }

    public double H2S(double value) {
        double seconds;
        seconds = value * 3600;
        return seconds;
    }
     
}
