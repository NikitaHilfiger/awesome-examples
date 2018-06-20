package ru.sbrf.efs.install.releasemanager.web.model;

import lombok.Data;

@Data
public class ConfigurationElement {

    private final String fullName;

    private final String name;

    private final String id;

    private final ConfigurationElement parent;

    private final String artifactId;

}
