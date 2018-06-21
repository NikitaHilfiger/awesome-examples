package ru.sbrf.efs.install.releasemanager.web.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Release {

    private ConfigurationElement configurationElement;

    private Artifact artifact;

    private String version;

    private Route route;

    public void setConfigurationElement(ConfigurationElement configurationElement) {
        this.configurationElement = configurationElement;
    }

}
