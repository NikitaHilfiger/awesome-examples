package ru.sbrf.efs.install.releasemanager.web.service;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.sbrf.efs.install.releasemanager.web.model.Job;
import ru.sbrf.efs.install.releasemanager.web.model.PipeLine;

import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import java.util.ArrayList;
import java.util.List;

import static ru.sbrf.efs.install.releasemanager.web.model.Job.Status.FAIL;
import static ru.sbrf.efs.install.releasemanager.web.model.Job.Status.SUCCESS;

@Component
@Getter
public class PipeLineService {

    private List<PipeLine> naturalPipelines = new ArrayList<PipeLine>() {{
        add(
                PipeLine
                        .builder()
                        .id("1")
                        .name("DEV")
                        .jobs(
                                new ArrayDataModel<>(
                                        new Job[]{
                                                new Job("nginx", SUCCESS),
                                                new Job("WAS", SUCCESS),
                                                new Job("settings-install", SUCCESS),
                                                new Job("oracle-install", SUCCESS),
                                                new Job("migration-config", FAIL)
                                        }
                                )
                        )
                        .build()
        );

        add(
                PipeLine
                        .builder()
                        .id("1")
                        .name("ММВ")
                        .jobs(
                                new ArrayDataModel<>(
                                        new Job[]{
                                                new Job("nginx", SUCCESS),
                                                new Job("WAS", SUCCESS),
                                                new Job("settings-install", SUCCESS),
                                                new Job("postgre", FAIL),
                                                new Job("migration-config", SUCCESS)
                                        }
                                )
                        )
                        .build()
        );

        add(
                PipeLine
                        .builder()
                        .id("1")
                        .name("МСВ")
                        .jobs(
                                new ArrayDataModel<>(
                                        new Job[]{
                                                new Job("code-analyse", FAIL),
                                                new Job("WAS", FAIL),
                                                new Job("settings-install", FAIL),
                                                new Job("postgre", SUCCESS),
                                                new Job("migration-config", SUCCESS)
                                        }
                                )
                        )
                        .build()
        );

        add(
                PipeLine
                        .builder()
                        .id("1")
                        .name("ИФТ")
                        .jobs(
                                new ArrayDataModel<>(
                                        new Job[]{
                                                new Job("Apache", SUCCESS),
                                                new Job("Jetty", FAIL),
                                                new Job("Nginx", SUCCESS),
                                                new Job("Config-install", SUCCESS),
                                                new Job("Oracle -test", FAIL),
                                        }
                                )
                        )
                        .build()
        );

        add(
                PipeLine
                        .builder()
                        .id("1")
                        .name("НТ")
                        .jobs(
                                new ArrayDataModel<>(
                                        new Job[]{
                                                new Job("Apache", SUCCESS),
                                                new Job("Jetty", FAIL),
                                                new Job("Config-install", SUCCESS),
                                                new Job("Oracle -test", FAIL),
                                                new Job("migration-config", SUCCESS)
                                        }
                                )
                        )
                        .build()
        );

        add(
                PipeLine
                        .builder()
                        .id("1")
                        .name("ПСИ")
                        .jobs(
                                new ArrayDataModel<>(
                                        new Job[]{
                                                new Job("nginx", SUCCESS),
                                                new Job("code-analyse", FAIL),
                                                new Job("settings-install", FAIL),
                                                new Job("postgre", SUCCESS),
                                                new Job("migration-config", SUCCESS)
                                        }
                                )
                        )
                        .build()
        );

        add(
                PipeLine
                        .builder()
                        .id("1")
                        .name("Hotfix")
                        .jobs(
                                new ArrayDataModel<>(
                                        new Job[]{
                                                new Job("nginx", SUCCESS),
                                                new Job("WAS", SUCCESS),
                                                new Job("settings-install", SUCCESS),
                                                new Job("postgre", SUCCESS),
                                                new Job("migration-config", SUCCESS)
                                        }
                                )
                        )
                        .build()
        );

        add(
                PipeLine
                        .builder()
                        .id("1")
                        .name("ПРОМ")
                        .jobs(
                                new ArrayDataModel<>(
                                        new Job[]{
                                                new Job("nginx", SUCCESS),
                                                new Job("WAS", SUCCESS),
                                                new Job("settings-install", SUCCESS),
                                                new Job("postgre", SUCCESS),
                                                new Job("migration-config", SUCCESS)
                                        }
                                )
                        )
                        .build()
        );
    }};

    private DataModel<PipeLine> mockPipeLines = new ArrayDataModel<>(
            naturalPipelines.toArray(
                    new PipeLine[naturalPipelines.size()]
            )
    );


}
