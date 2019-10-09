package model;

public class OutcomeKey {
    private String nctId;

    private String outcomeType;

    public String getNctId() {
        return nctId;
    }

    public void setNctId(String nctId) {
        this.nctId = nctId == null ? null : nctId.trim();
    }

    public String getOutcomeType() {
        return outcomeType;
    }

    public void setOutcomeType(String outcomeType) {
        this.outcomeType = outcomeType == null ? null : outcomeType.trim();
    }
}