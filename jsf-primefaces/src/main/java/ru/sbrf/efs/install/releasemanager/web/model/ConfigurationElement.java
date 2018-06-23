package ru.sbrf.efs.install.releasemanager.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfigurationElement {

    private String id;

    private String fullName;

    private String name;

    private ConfigurationElement parent;

    private String artifactId;

}
