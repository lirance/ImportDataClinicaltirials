package model;

public class Sponsor {
    private Integer sponsorId;

    private String agency;

    private String agencyClass;

    public Integer getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(Integer sponsorId) {
        this.sponsorId = sponsorId;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency == null ? null : agency.trim();
    }

    public String getAgencyClass() {
        return agencyClass;
    }

    public void setAgencyClass(String agencyClass) {
        this.agencyClass = agencyClass == null ? null : agencyClass.trim();
    }
}