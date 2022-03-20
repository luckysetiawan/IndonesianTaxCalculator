package model;

import lombok.NoArgsConstructor;

public enum Assessable {
    PERSONAL(54000000.0),
    MARRIED(4500000.0),
    RELATIVES(4500000.0);

    private final Double assessable;

    Assessable (Double assessable) {
        this.assessable = assessable;
    }

    public Double getAssessable() {
        return assessable;
    }
}
