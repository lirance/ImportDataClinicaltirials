package model;

public class StudyWithBLOBs extends Study {
    private String briefTitle;

    private String briefSummary;

    private String detailedDescription;

    public String getBriefTitle() {
        return briefTitle;
    }

    public void setBriefTitle(String briefTitle) {
        this.briefTitle = briefTitle == null ? null : briefTitle.trim();
    }

    public String getBriefSummary() {
        return briefSummary;
    }

    public void setBriefSummary(String briefSummary) {
        this.briefSummary = briefSummary == null ? null : briefSummary.trim();
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription == null ? null : detailedDescription.trim();
    }
}