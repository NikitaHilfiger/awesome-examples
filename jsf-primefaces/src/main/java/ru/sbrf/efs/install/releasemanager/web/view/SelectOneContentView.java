package ru.sbrf.efs.install.releasemanager.web.view;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class SelectOneContentView {

    private String version;

    private String content = "";

    private Boolean isArtifactVersionSelected;

    private Boolean isDiscussSelected;

    private Boolean isHistorySelected;

    public void setIsDiscussSelected(Boolean isDiscussSelected) {
        this.isHistorySelected = false;
    }

    public void setIsHistorySelected(Boolean setIsHistorySelected) {
        this.isDiscussSelected = false;
    }

    public void changeArtifactVersion() {
        this.isArtifactVersionSelected = true;
    }
}
