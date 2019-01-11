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
public class TempConvBean {

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

    
}
