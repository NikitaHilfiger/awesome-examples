package ru.sbrf.efs.install.releasemanager.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.model.DataModel;

@Getter
@Setter
@Builder
public class PipeLine {

    private String id;

    private String name;

    private Contour contour;

    private DataModel<Job> jobs;

    public String getName() {
        return name;
    }
}
