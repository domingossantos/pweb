package br.com.domsantos.processoweb.mb.common;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import br.com.domsantos.processoweb.exception.MBException;
import br.com.domsantos.processoweb.exception.ServiceException;

public class ProcessoWebActionListener implements ActionListener {

	private static Logger logger = Logger.getLogger(ProcessoWebActionListener.class.getName());

	private final ActionListener delegate;

	public ProcessoWebActionListener(ActionListener delegate) {
		this.delegate = delegate;
	}

	public void processAction(ActionEvent event) throws AbortProcessingException {
		try {
			delegate.processAction(event);
		} catch (Exception e) {
			e.printStackTrace();
			messageExceptions(e);
		}
	}

	/**
	 * Registra as exceções no FacesMessage
	 * 
	 * @param exception
	 */
	private void messageExceptions(Exception e) {
		FacesContext context = getCurrentInstance();
		
		Throwable causa = e;
		causa = causa.getCause();
		if ((causa instanceof ServiceException) || (causa instanceof MBException) ) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, causa.getMessage(), null));
			logger.log(Level.WARNING, causa.getMessage(), causa);
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, causa.getMessage(), null));
			logger.log(Level.SEVERE, causa.getMessage(), causa);
		}
	}
}
