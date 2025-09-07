package com.genomatogenoma.togenoma.basicCompanyData.infrastructure.driven.DTO;

public class CompanyDTO {
    private Long id;
    private String companyName;
    private String nit;
    private String address;
    private String phone;
    private String email;
    private String legalRepresentative;
    private String dateIncorporation;
    private StateCompany state;

    public CompanyDTO() {
    }

    public CompanyDTO(Long id, String companyName, String nit, String address, String phone, String email,
            String legalRepresentative, String dateIncorporation, StateCompany state) {
        this.id = id;
        this.companyName = companyName;
        this.nit = nit;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.legalRepresentative = legalRepresentative;
        this.dateIncorporation = dateIncorporation;
        this.state = state;
    }

    public static CompanyDTO init(Long id, String companyName, String nit, String address, String phone, String email,
            String legalRepresentative, String dateIncorporation, StateCompany state) {
        return new CompanyDTO(
                id,
                companyName,
                nit,
                address,
                phone,
                email,
                legalRepresentative,
                dateIncorporation,
                state);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getDateIncorporation() {
        return dateIncorporation;
    }

    public void setDateIncorporation(String dateIncorporation) {
        this.dateIncorporation = dateIncorporation;
    }

    public StateCompany getState() {
        return state;
    }

    public void setState(StateCompany state) {
        this.state = state;
    }

    public enum StateCompany {
        ACTIVE,
        SUSPENDED,
        LIQUIDATION
    }
}