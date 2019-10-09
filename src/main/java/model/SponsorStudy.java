package model;

public class SponsorStudy extends SponsorStudyKey {
    private String sponsorType;

    public String getSponsorType() {
        return sponsorType;
    }

    public void setSponsorType(String sponsorType) {
        this.sponsorType = sponsorType == null ? null : sponsorType.trim();
    }
}