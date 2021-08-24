
package de.intellinet.ausbildung.kundenportal.persistence.utils;

import java.util.List;

/**
 * 
 * 
 * @author ahmalk
 *
 * @since 13.02.2020
 */
public class PreparedWhere {

    private String bedingung;
    private List<Object> parameter;

    public PreparedWhere(String bedingung, List<Object> parameter) {
        super();
        this.bedingung = bedingung;
        this.parameter = parameter;
    }

    public String getBedingung() {
        return bedingung;
    }

    public void setBedingung(String bedingung) {
        this.bedingung = bedingung;
    }

    public List<Object> getParameter() {
        return parameter;
    }

    public void setParameter(List<Object> parameter) {
        this.parameter = parameter;
    }

}
