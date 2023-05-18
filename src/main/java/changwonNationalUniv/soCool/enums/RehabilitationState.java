package changwonNationalUniv.soCool.enums;

public enum RehabilitationState {

    BEFORE("재활시작전"), ING("재활중"), AFTER("재활종료");

    private final String description;

    RehabilitationState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
