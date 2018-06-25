package ru.sbrf.efs.install.releasemanager.web.view;

import org.springframework.stereotype.Component;

@Component
public class SelectOneView {

    private String option;

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}