package ru.sbrf.efs.install.releasemanager.web.service;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.sbrf.efs.install.releasemanager.web.model.Artifact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Data
public class ArtifactService {

    private List<Artifact> mockArtifacts = new ArrayList<Artifact>() {{
        add(
                Artifact.builder()
                        .name("installer-ui-ear")
                        .versions(
                                Arrays.asList(
                                        "0.1",
                                        "0.2",
                                        "0.3"
                                )
                        )
                        .build()
        );

        add(
                Artifact.builder()
                        .name("sb-payment-ear")
                        .versions(
                                Arrays.asList(
                                        "0.1",
                                        "0.2",
                                        "0.3"
                                )
                        )
                        .build()

        );

    }};
}
