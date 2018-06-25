package ru.sbrf.efs.install.releasemanager.web.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionService {

    @Getter
    private List<String> mockComments;
}
