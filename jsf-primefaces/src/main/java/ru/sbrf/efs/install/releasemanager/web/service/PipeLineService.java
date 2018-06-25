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
                                new ArrayDataModel<Job>() {{
                                    adnew Job()
                                }}
                        )
                        .build()
        );
    }};


}
