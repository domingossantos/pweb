package br.com.domsantos.processoweb.mb.common;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.domsantos.common.FuncoesUteis;
import br.com.domsantos.common.PaginacaoUtil;
import br.com.domsantos.processoweb.model.Advogado;

public class PaginaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String USUARIO_SESSAO = "USUARIO_SESSAO";

	/**
	* variaveis para paginacao
	*/
	private String pagina;
	private List<String> paginasView;
	private String linkpag = "/portal/noticias/";
	private String pagInicio = PaginacaoUtil.FIRST;
	private String pagFinal = PaginacaoUtil.LAST;
	
	
	
	/*
	 * Data corrente
	 * 
	 */
	private String dataCorrente;
	
	
	/**
     * Adiciona uma nova mensagem do tipo info.
     *
     * @param mensagem
     */
    public void addInfo(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO ,"Informação", mensagem));
    }

    /**
     * Adiciona uma nova mensagem do tipo warn.
     *
     * @param mensagem
     */
    public void addWarn(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atenção", mensagem));
    }

    /**
     * Adiciona um novo atributo na sessão.
     * 
     * @param chave
     * @param valor
     */
    public void addAtributo(String chave, Object valor) {
        getSession().setAttribute(chave, valor);
    }

    /**
     * Retorna o valor de um atributo da sessão dado uma chave.
     * 
     * @param chave
     * @return valor do tipo Object
     */
    public Object getAtributo(String chave) {
    	if(getSession() != null)
    		return getSession().getAttribute(chave);
    	
    	return null;
    }
    
    /**
     * Remove o valor de um atributo da sessão.
     * 
     * @param chave
     * @return valor do tipo Object
     */
    public Object removerAtributo(String chave) {
    	Object obj = getSession().getAttribute(chave);
    	getSession().removeAttribute(chave);
        return obj;
    }
    
    /**
     * Adiciona uma variável no request.
     * 
     * @param chave
     * @param valor
     */
    public void addRequestParameter(String chave, Object valor) {
    	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(chave, valor);
    }

    /**
     * Cria um cookie dado um nome.
     * 
     * @param nome
     * @param valor
     */
    public void addCookie(String nome, String valor) {
        Cookie cookie = new Cookie(nome, valor);
        cookie.setMaxAge(3600);
        getResponse().addCookie(cookie);
    }

    /**
	 * Retorna um cookie dado um nome.
	 *  
	 * @param nome
	 */
    public String getCookie(String nome) {
        Cookie cookies[] = getRequest().getCookies();
        if (cookies != null && cookies.length > 0)
            for (Cookie cookie : cookies)
                if (nome.equals(cookie.getName()))
                    return cookie.getValue();
        return null;
    }

    /**
     * Retorna uma referência do HttpServletResponse.
     * 
     * @return HttpServletResponse
     */
    protected HttpServletResponse getResponse() {
        return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }

    /**
     * Retorna uma referência do HttpServletRequest.
     * 
     * @return HttpServletRequest
     */
    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
    
    protected Advogado getUsuarioLogado() {
    	Object obj = getAtributo(USUARIO_SESSAO);
    	if(obj == null)
    		return null;
    	
    	return (Advogado) obj;
    }
    
    protected void setUsuarioLogado(Advogado usuario) {
    	addAtributo(USUARIO_SESSAO, usuario);
    }

    /**
     * Retorna a sessão aberta.
     * 
     * @return HttpSession
     */
    private HttpSession getSession() {
    	Object session = FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	if(session == null)
    		return null;
    	
        return (HttpSession) session;
    }
    
    /**
     * gets e sets de paginacao
     */
    public String getPagina() {
		return pagina;
	}
	
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	
	
	public List<String> getPaginasView() {
		return paginasView;
	}
	
	public void setPaginasView(List<String> paginasView) {
		this.paginasView = paginasView;
	}
	
	public String getLinkpag() {
		return linkpag;
	}
	
	public String getPagInicio() {
		return pagInicio;
	}
	
	public String getPagFinal() {
		return pagFinal;
	}

	public String getDataCorrente() {
		dataCorrente = FuncoesUteis.converteDataToStringExtenso(Calendar.getInstance().getTime());
		return dataCorrente;
	}

	public void setDataCorrente(String dataCorrente) {
		this.dataCorrente = dataCorrente;
	}
}