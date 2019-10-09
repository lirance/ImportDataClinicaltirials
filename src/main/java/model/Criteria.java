package model;

public class Criteria {
    private Integer criterId;

    private String gender;

    private String minimumAge;

    private String maximumAge;

    private String criteriaiText;

    public Integer getCriterId() {
        return criterId;
    }

    public void setCriterId(Integer criterId) {
        this.criterId = criterId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(String minimumAge) {
        this.minimumAge = minimumAge == null ? null : minimumAge.trim();
    }

    public String getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(String maximumAge) {
        this.maximumAge = maximumAge == null ? null : maximumAge.trim();
    }

    public String getCriteriaiText() {
        return criteriaiText;
    }

    public void setCriteriaiText(String criteriaiText) {
        this.criteriaiText = criteriaiText == null ? null : criteriaiText.trim();
    }
}