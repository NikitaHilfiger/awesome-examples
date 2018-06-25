package ru.sbrf.efs.install.releasemanager.web.service;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.sbrf.efs.install.releasemanager.web.model.Job;
import ru.sbrf.efs.install.releasemanager.web.model.PipeLine;

import javax.faces.model.ArrayDataModel;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class PipeLineService {

    private List<PipeLine> mockPipeLines = new ArrayList<PipeLine>() {{
        add(
                PipeLine
                        .builder()
                        .id("1")
                        .jobs(
                                new ArrayDataModel<>(
                                        new Job[] {
                                            new Job("nginx"),
                                            new Job("WAS"),
                                            new Job("settings-install"),
                                            new Job("oracle-install"),
                                            new Job("migration-configuration")
                                        }
                                )
                        )
                        .build()
        );

        add(
                PipeLine
                        .builder()
                        .id("1")
                        .jobs(
                                new ArrayDataModel<>(
                                        new Job[] {
                                                new Job("nginx"),
                                                new Job("WAS"),
                                                new Job("settings-install"),
                                                new Job("postgre"),
                                                new Job("migration-configuration")
                                        }
                                )
                        )
                        .build()
        );
    }};


}
