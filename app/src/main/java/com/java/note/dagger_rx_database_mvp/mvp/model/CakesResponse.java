package com.java.note.dagger_rx_database_mvp.mvp.model;

public class CakesResponse {
    private String product;
    private int version;
    private String releaseDate;
    private CakesResponseCakes[] cakes;
    private CakesResponseStaffContacts[] staffContacts;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public CakesResponseCakes[] getCakes() {
        return cakes;
    }

    public void setCakes(CakesResponseCakes[] cakes) {
        this.cakes = cakes;
    }

    public CakesResponseStaffContacts[] getStaffContacts() {
        return staffContacts;
    }

    public void setStaffContacts(CakesResponseStaffContacts[] staffContacts) {
        this.staffContacts = staffContacts;
    }
}
