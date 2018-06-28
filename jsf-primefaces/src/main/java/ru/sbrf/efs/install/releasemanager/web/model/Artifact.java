package ru.sbrf.efs.install.releasemanager.web.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Artifact {

    private String name;

    private List<String> versions;

}
