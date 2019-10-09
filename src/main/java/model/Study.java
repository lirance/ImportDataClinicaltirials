package model;

public class Study {
    private String nctId;

    private String url;

    private String source;

    private String overallStatus;

    private String phase;

    private String studyType;

    private String studyFirstSubmitted;

    private String resultsFirstSubmitted;

    private Integer contactId;

    private String officialTitle;

    private String startDate;

    private Integer criterId;

    public String getNctId() {
        return nctId;
    }

    public void setNctId(String nctId) {
        this.nctId = nctId == null ? null : nctId.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getOverallStatus() {
        return overallStatus;
    }

    public void setOverallStatus(String overallStatus) {
        this.overallStatus = overallStatus == null ? null : overallStatus.trim();
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase == null ? null : phase.trim();
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType == null ? null : studyType.trim();
    }

    public String getStudyFirstSubmitted() {
        return studyFirstSubmitted;
    }

    public void setStudyFirstSubmitted(String studyFirstSubmitted) {
        this.studyFirstSubmitted = studyFirstSubmitted == null ? null : studyFirstSubmitted.trim();
    }

    public String getResultsFirstSubmitted() {
        return resultsFirstSubmitted;
    }

    public void setResultsFirstSubmitted(String resultsFirstSubmitted) {
        this.resultsFirstSubmitted = resultsFirstSubmitted == null ? null : resultsFirstSubmitted.trim();
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getOfficialTitle() {
        return officialTitle;
    }

    public void setOfficialTitle(String officialTitle) {
        this.officialTitle = officialTitle == null ? null : officialTitle.trim();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public Integer getCriterId() {
        return criterId;
    }

    public void setCriterId(Integer criterId) {
        this.criterId = criterId;
    }
}