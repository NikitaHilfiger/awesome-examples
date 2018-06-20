package ru.sbrf.efs.install.releasemanager.web.service;

import ru.sbrf.efs.install.releasemanager.web.model.ConfigurationElement;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ConfigurationElementService {

    private Boolean isVersionSelected;

    private ConfigurationElement coreCeEfs = new ConfigurationElement(
            "Единая Фронтальная Система",
            "EFS",
            "1",
            null,
            "global-efs-artifact"
    );

    private ConfigurationElement ceEfs = new ConfigurationElement(
            "sberbank-online",
            "sb-online",
            "2",
            coreCeEfs,
            "sb-online-artifact"
    );

    public String getCoreCeName() {
        return coreCeEfs.getName();
    }

    public String getCeName() {
        return ceEfs.getName();
    }

    public String getCeParentName() {
        return this.coreCeEfs.getName();
    }

}
