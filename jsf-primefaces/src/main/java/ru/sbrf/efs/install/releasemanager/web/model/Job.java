package ru.sbrf.efs.install.releasemanager.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Job {

    private String name;

    private Status status;

    public enum Status {
        SUCCESS,
        FAIL
    }
}
