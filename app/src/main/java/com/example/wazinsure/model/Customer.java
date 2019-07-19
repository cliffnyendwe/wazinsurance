package com.example.wazinsure.model;

import com.google.gson.annotations.SerializedName;

public class Customer {
    @SerializedName("customer_id")
    private Integer customerId;
    @SerializedName("id_no")
    private String idNo;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("dob")
    private String dob;
    @SerializedName("kra_pin")
    private String kraPin;
    @SerializedName("occupation")
    private String occupation;
    @SerializedName("mobile_no")
    private String mobileNo;
    @SerializedName("email")
    private String email;
    @SerializedName("location")
    private String location;
    @SerializedName("postal_address")
    private String postalAddress;
    @SerializedName("postal_code")
    private String postalCode;
    @SerializedName("town")
    private String town;
    @SerializedName("country")
    private Object country;
    @SerializedName("photo_url")
    private Object photoUrl;
    @SerializedName("nok_fullname")
    private String nokFullname;
    @SerializedName("nok_mobileno")
    private String nokMobileno;
    @SerializedName("nok_relation")
    private String nokRelation;
    @SerializedName("agent_code")
    private Object agentCode;
    @SerializedName("agent_usercode")
    private Object agentUsercode;
    @SerializedName("sales_channel")
    private String salesChannel;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getKraPin() {
        return kraPin;
    }

    public void setKraPin(String kraPin) {
        this.kraPin = kraPin;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Object getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(Object photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getNokFullname() {
        return nokFullname;
    }

    public void setNokFullname(String nokFullname) {
        this.nokFullname = nokFullname;
    }

    public String getNokMobileno() {
        return nokMobileno;
    }

    public void setNokMobileno(String nokMobileno) {
        this.nokMobileno = nokMobileno;
    }

    public String getNokRelation() {
        return nokRelation;
    }

    public void setNokRelation(String nokRelation) {
        this.nokRelation = nokRelation;
    }

    public Object getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(Object agentCode) {
        this.agentCode = agentCode;
    }

    public Object getAgentUsercode() {
        return agentUsercode;
    }

    public void setAgentUsercode(Object agentUsercode) {
        this.agentUsercode = agentUsercode;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

}
