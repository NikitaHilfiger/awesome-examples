package ru.sbrf.efs.install.releasemanager.web.service;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.sbrf.efs.install.releasemanager.web.model.ConfigurationElement;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConfigurationElementService {

    @Getter
    private List<ConfigurationElement> mockConfigurationElements = new ArrayList<ConfigurationElement>() {{
        add(
                new ConfigurationElement(
                        "0",
                        "Единая Фронтальная Система",
                        "EFS",
                        null,
                        "global-efs-artifact"
                )
        );

        add(
                new ConfigurationElement(
                        "1",
                        "sberbank",
                        "sb",
                        get(0),
                        "sb-online-artifact"
                )
        );
    }};
}
