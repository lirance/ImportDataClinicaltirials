package model;

public class LocationStudyKey {
    private String nctId;

    private Integer zip;

    public String getNctId() {
        return nctId;
    }

    public void setNctId(String nctId) {
        this.nctId = nctId == null ? null : nctId.trim();
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }
}