/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbldung.kundenportal.pages.components;

import java.math.BigDecimal;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 08.04.2021
 */
public class Betrag {

    private String waehrung;
    private BigDecimal value;

    public String getWaehrung() {
        return waehrung;
    }

    public void setWaehrung(String waehrung) {
        this.waehrung = waehrung;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
