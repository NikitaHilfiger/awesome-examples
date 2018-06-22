package ru.sbrf.efs.install.releasemanager.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConfigurationElement {

    private String id;

    private String fullName;

    private String name;

    private ConfigurationElement parent;

    private String artifactId;

}
