package br.com.fiap.samf.mbean.utils;

import java.awt.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageWarn {
   
	public static void addInfo(ActionEvent actionEvent,String title,String warn) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,title,warn));  
    }  
  
    public static void addWarn(ActionEvent actionEvent,String title,String warn) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,title,warn));  
    }  
  
    public static void addError(ActionEvent actionEvent,String title,String warn) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,title,warn));  
    }  
  
    public static void addFatal(ActionEvent actionEvent,String title,String warn) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,title,warn));  
    }  
}
