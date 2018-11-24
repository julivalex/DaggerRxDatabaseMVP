package com.java.note.dagger_rx_database_mvp.mvp.model;

class CakesResponseStaffContacts {
    private int id;
    private String name;
    private String[] email;
    private String role;
    private String dateOfBirth;
    private CakesResponseStaffContactsPhones phones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public CakesResponseStaffContactsPhones getPhones() {
        return phones;
    }

    public void setPhones(CakesResponseStaffContactsPhones phones) {
        this.phones = phones;
    }
}
