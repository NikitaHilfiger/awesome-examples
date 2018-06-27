package ru.sbrf.efs.install.releasemanager.web.view;

import org.springframework.stereotype.Component;
import ru.sbrf.efs.install.releasemanager.web.model.Job;

@Component
public class IconView {

    public String getJobIcon(Job job) {
        switch (job.getStatus()) {
            case FAIL:
                return "fa fa-remove";
            case SUCCESS:
                return "fa fa-check-square";

            default:
                throw new NullPointerException();
        }
    }
}
