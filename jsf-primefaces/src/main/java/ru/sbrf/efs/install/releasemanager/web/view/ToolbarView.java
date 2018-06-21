package ru.sbrf.efs.install.releasemanager.web.view;

import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component
public class ToolbarView {

    public void reset() {
        addMessage("Success", "New template");
    }

    public void openTemplate() {
        addMessage("Success", "Template opened");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}