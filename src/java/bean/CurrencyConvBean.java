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
public class CurrencyConvBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public double U2S(double value) {
        double sek;
        sek = value * 8.9368;
        return sek;
    }

    public double U2E(double value) {
        double eur;
        eur = value * 0.871875308;
        return eur;
    }

    public double U2Y(double value) {
        double yen;
        yen = value * 108.55406;
        return yen;
    }

    public double S2U(double value) {
        double usd;
        usd = value * 0.111954;
        return usd;
    }

    public double S2Y(double value) {
        double yen;
        yen = value * 12.1530612;
        return yen;
    }

    public double S2E(double value) {
        double eur;
        eur = value * 0.0976099282;
        return eur;
    }

    public double E2S(double value) {
        double sek;
        sek = value * 10.2448595;
        return sek;
    }

    public double E2U(double value) {
        double usd;
        usd = value * 1.146953;
        return usd;
    }

    public double E2Y(double value) {
        double yen;
        yen = value * 124.506405;
        return yen;
    }

    public double Y2S(double value) {
        double sek;
        sek = value * 0.0822837951;
        return sek;
    }

    public double Y2U(double value) {
        double usd;
        usd = value * 0.009212;
        return usd;
    }

    public double Y2E(double value) {
        double eur;
        eur = value * 0.00803171534;
        return eur;
    }
    
    
}
