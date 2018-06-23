package ru.sbrf.efs.install.releasemanager.web.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
public class Release {

    private String id;

    private String name;

    private String date;

    private String author;

    private String status;

    private ConfigurationElement configurationElement;

    private Artifact artifact;

    private String version;

    private Route route;

}
