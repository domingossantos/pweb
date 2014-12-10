package br.com.domsantos.processoweb.ws;

import br.com.domsantos.processoweb.service.ProcessoSrv;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * Created by domingos on 18/11/14.
 */
@Path("/processo")
public class ProcessoRest {

    @EJB
    private ProcessoSrv processoSrv;
}
