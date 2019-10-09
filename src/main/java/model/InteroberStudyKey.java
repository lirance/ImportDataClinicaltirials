package model;

public class InteroberStudyKey {
    private String nctId;

    private Integer interoberId;

    public String getNctId() {
        return nctId;
    }

    public void setNctId(String nctId) {
        this.nctId = nctId == null ? null : nctId.trim();
    }

    public Integer getInteroberId() {
        return interoberId;
    }

    public void setInteroberId(Integer interoberId) {
        this.interoberId = interoberId;
    }
}