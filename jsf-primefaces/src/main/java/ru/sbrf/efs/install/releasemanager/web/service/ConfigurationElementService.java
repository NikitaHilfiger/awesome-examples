package ru.sbrf.efs.install.releasemanager.web.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.sbrf.efs.install.releasemanager.web.model.ConfigurationElement;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConfigurationElementService {

    @Getter
    @Setter
    private ConfigurationElement configurationElement;

    private List<ConfigurationElement> mockConfigurationElements = new ArrayList<ConfigurationElement>() {{
        add(
                new ConfigurationElement(
                        "Единая Фронтальная Система",
                        "EFS",
                        "1",
                        null,
                        "global-efs-artifact"
                )
        );

        add(
                new ConfigurationElement(
                        "sberbank-online",
                        "sb-online",
                        "2",
                        get(0),
                        "sb-online-artifact"
                )
        );
    }};

    public List<ConfigurationElement> getMockConfigElements() {
        return mockConfigurationElements;
    }

/*    public void setConfigElement(ConfigurationElement configElement) {
        this.release.setConfigurationElement(configElement);
    }*/

}
