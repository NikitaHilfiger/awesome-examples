package ru.sbrf.efs.install.releasemanager.web.service;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.sbrf.efs.install.releasemanager.web.model.Artifact;
import ru.sbrf.efs.install.releasemanager.web.model.ConfigurationElement;
import ru.sbrf.efs.install.releasemanager.web.model.Release;
import ru.sbrf.efs.install.releasemanager.web.model.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Getter
public class ReleaseService {

    private ConfigurationElement sbConfEl = ConfigurationElement.builder()
            .name("sb")
            .build();

    private ConfigurationElement efsConfEl = ConfigurationElement.builder()
            .name("efs")
            .build();

    private List<Release> mockReleases = new ArrayList<Release>() {{
        add(
                Release.builder()
                        .id("LLMH98")
                        .name("payment-fp")
                        .version("0.1")
                        .author("Vasiliy Vasin")
                        .date("2018.06.20-13:30")
                        .status("PROCEED")
                        .configurationElement(sbConfEl)
                        .artifact(new Artifact("efs-admin-ear.ear"))
                        .route(new Route("DEV -> TEST -> PROD"))
                        .status("SUCCESS")
                        .build()
        );

        add(
                Release.builder()
                        .id("JJHFT8")
                        .name("credits-fp")
                        .author("Nikita Korev")
                        .date("2018.06.18-15:30")
                        .status("INSTALLED")
                        .configurationElement(efsConfEl)
                        .build()
        );

        add(
                Release.builder()
                        .id("GGHKY6")
                        .name("sms-fp")
                        .author("Sergei Vasin")
                        .date("2018.06.20-12:30")
                        .status("PROCEED")
                        .configurationElement(efsConfEl)
                        .build()
        );

        add(
                Release.builder()
                        .id("KKHMH90")
                        .name("cards-fp")
                        .author("Alex Pavlov")
                        .date("2018.06.20-18:30")
                        .status("REJECTED")
                        .configurationElement(efsConfEl)
                        .build()
        );

        add(
                Release.builder()
                        .id("Oofgdg12")
                        .name("sb-online-fp")
                        .author("Vasiliy Vasin")
                        .date("2018.06.20-13:27")
                        .status("FAILED")
                        .configurationElement(sbConfEl)
                        .build()
        );
    }};

    private List<String> ceNames = mockReleases.stream().map(
            release -> release.getConfigurationElement().getName()
    ).distinct().collect(Collectors.toList());
}
