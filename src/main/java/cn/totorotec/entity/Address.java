package cn.totorotec.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address extends AbstractEntity {
    private String city;

    private String province;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
