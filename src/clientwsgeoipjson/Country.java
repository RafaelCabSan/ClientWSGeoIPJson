/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientwsgeoipjson;

import java.io.Serializable;

/**
 *
 * @author entrar
 */
public class Country implements Serializable {
    
    private String name;
    private String alpha2_code;
    private String alpha3_code;

    public String getName() {
        return name;
    }

    public String getAlpha2_code() {
        return alpha2_code;
    }

    public String getAlpha3_code() {
        return alpha3_code;
    }
}
