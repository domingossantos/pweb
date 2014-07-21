package br.com.domsantos.common;

public class ListaApp {

	public static final int COD_TIPO_REGISTRO_PROCESSO = 0;
	public static final int COD_TIPO_REGISTRO_PROTOCOLO = 1;
	
	public static final int LOCAL_ARQUIVO_NIVEL_RAIZ = 0;
	public static final char CD_NIVEL_ADMIN_ENTIDADE = 'A';
	public static final char CD_NIVEL_ADMIN_SUPERADMIN = 'S';
	public static final char CD_NIVEL_ADMIN_SEM_ADMIN = 'N';
	
	public static final char LOTACAOATIVADA = 'A';
	public static final char LOTACAODESATIVADA = 'D';
	public static final char SITUACAOTIPOPROCATIVA = 'S';
	public static final char SITUACAOTIPOPROCDESATIVA = 'N';
	
	public static final char SITUACAOTRAMITEESPERA = 'E';
	public static final char SITUACAOTRAMITETRAMITADO = 'T';
	public static final char SITUACAOTRAMITERECEBIDO = 'R';
	public static final char SITUACAOTRAMITEFINALIZADO = 'F';
	public static final char SITUACAOTRAMITEDEFERIDO = 'D';
	public static final char SITUACAOTRAMITEINDEFERIDO = 'I';
	
	public static final char SITUACAOPROCESSOABERTO = 'A';
	public static final char SITUACAOPROCESSOENCERRADO = 'E';
	public static final char SITUACAOPROCESSOARQUIVADO = 'F';
	public static final char SITUACAOPROCESSOCANCELADO = 'C';
	
	public static final int ROTAPRIORIDADEBAIXA = 3;
	public static final int ROTAPRIORIDADENORMAL = 2;
	public static final int ROTAPRIORIDADEALTA = 1;
	
	public static final int ROTAPARALELASIM = 1;
	public static final int ROTAPARALELANAO = 2;
	
	public static final char SITUACAOTRIBUTOEXCLUSIVOSIM = 'S';
	public static final char SITUACAOTRIBUTOEXCLUSIVONAO = 'N';
	public static final String SITUACAOCODIGODESMEMBRAMENTOBRANCO = "0";
	
	public static final char SITUACAO_DAM_EM_ABERTO = '1';
	public static final char SITUACAO_DAM_PAGA = '2';
	public static final int  NUMDIASDATAVENCIMENTO = 5;
	
	public static final char LOG_OPERACAO_ALTERACAO = 'A';
	public static final char LOG_OPERACAO_INSERCAO = 'I';
	public static final char LOG_OPERACAO_EXCLUSAO = 'E';
	
	public static final String HOME = "MENU PRINCIPAL";
	public static final String LISTAENTID = "LISTA ENTIDADES";
	public static final String ADDENTID = "ADICIONAR ENTIDADES";
	public static final String EDITENTID = "EDITAR ENTIDADES";
	public static final String LISTASETORES = "LISTAR SETORES";
	public static final String ADDSETOR = "ADICIONAR SETOR";
	public static final String EDITSETOR = "EDITAR SETOR";
	public static final String LISTALOTACAO = "LISTAR LOTACAO";
	public static final String ADDLOTACAO = "ADICIONAR LOTACAO";
	public static final String EDITLOTACAO = "EDITAR LOTACAO";
	public static final String ATIVLOTACAO = "ATIVAR LOTACAO";
	public static final String DESATIVLOTACAO = "DESATIVAR LOTACAO";
	public static final String ADDUSER = "ADICIONAR USUARIO";
	public static final String LISTUSER = "LISTAR USUARIO";
	public static final String EDITUSER = "EDITAR USUARIO";
	public static final String REDEFSENHAUSER = "REDEFINIR SENHA USUARIO";
	public static final String LISTAPERFIL = "LISTAR PERFIL";
	public static final String ADDPERFIL = "ADICIONAR PERFIL";
	public static final String EDITPERFIL = "EDITAR PERFIL";
	public static final String PROCPORENTIDADE = "PROCESSOS POR ENTIDADE";
	public static final String PROCPORSETOR = "PROCESSOS POR SETOR";
	public static final String PROCRESUMO = "PROCESSOS RESUMO";
	public static final String NOVOPROC = "NOVO PROCESSO";
	public static final String NOVOINTERESSADO = "NOVO INTERESSADO";
	public static final String EDITINTERESSADO = "EDITAR INTERESSADO";
	public static final String LISTTPPROC = "LISTAR TIPO PROCESSO";
	public static final String ADDTPPROC = "ADICIONAR TIPO PROCESSO";
	public static final String EDITTPPROC = "EDITAR TIPO PROCESSO";
	public static final String ADDTRAMITE = "ADICIONAR TRAMITE";
	public static final String DETALHARPROCESSO = "DETALHAR PROCESSO";
	public static final String RECEBERTRAMITE = "RECEBER TRAMITE";
	public static final String PESQUISARPROCESSO = "PESQUISAR PROCESSO";
	public static final String ENCERRARPROCESSO = "ENCERRAR PROCESSO";
	public static final String ADICIONAROTA = "ADICIONAR ROTA";
	public static final String LISTROTA = "LISTAR ROTA";
	public static final String EDITARROTA = "EDITAR ROTA";
	public static final String LISTREGRAS = "LISTAR REGRA";
	public static final String ADDREGRAS = "ADICIONAR REGRA";
	public static final String EDITREGRAS = "EDITAR REGRA";
	public static final String LISTDOCSEXIGIDOS = "LISTAR DOCUMENTOS EXIGIDOS";
	public static final String ADDDOCSEXIGIDOS = "ADICIONAR DOCUMENTOS EXIGIDOS";
	public static final String EDITDOCSEXIGIDOS = "EDITAR DOCUMENTOS EXIGIDOS";
	public static final String ADDTRIBUTO = "ADICIONAR TRIBUTO";
	public static final String EDITTRIBUTO = "EDITAR TRIBUTO";
	public static final String LISTTRIBUTO = "LISTAR TRIBUTO";
	public static final String ADDUSOATIVIDADE = "ADICIONAR USO ATIVIDADE";
	public static final String LISTUSOATIVIDADE = "LISTAR USO ATIVIDADE";
	public static final String EDITUSOATIVIDADE = "EDITAR USO ATIVIDADE";
	public static final String ADDUFIR = "ADICIONAR UFIR";
	public static final String LISTUFIR = "LISTAR UFIR";
	public static final String EDITUFIR = "EDITAR UFIR";
	public static final String ADDDAM = "ADICIONAR DAM";
	public static final String LISTADAMSDOPROCESSO = "LISTAR GUIAS DO PROCESSO";
	public static final String LISTDOCANEXO = "LISTAR DOCUMENTOS ANEXOS";
	public static final String ADDDOCANEXO = "ADICIONAR DOCUMENTOS ANEXOS";
	public static final String EDITDOCANEXO = "EDITAR DOCUMENTOS ANEXOS";
	public static final String MENU_ADMIN = "MENU ADMINISTRATIVO";
	
	public static final String MENU_RELATORIOS = "MENU RELATORIOS";
	public static final String RELATORIO_PROCESSOS_EM_ATRASO = "RELATORIO PROCESSOS EM ATRASO";
	public static final String RELATORIO_PROCESSOS_VS_SETOR = "RELATORIO PROCESSOS VS SETOR";
	public static final String CAPA_DO_PROCESSO = "CAPA DO PROCESSO";
	public static final String LISTA_PROCESSOS_ENCERRADOS = "LISTA DE PROCESSOS ENCERRADOS";
	public static final String ARQUIVAR_PROCESSO = "ARQUIVAR PROCESSO";
	public static final String LISTA_TRAMITES_ESTORNO = "LISTA DE TRAMITES A ESTORNAR";
	public static final String NOVO_PROCESSO_ANONIMO = "NOVO PROCESSO ANONIMO";
	public static final String ESTORNO_TRAMITE = "ESTORNAR TRAMITE";
	public static final String LOCAL_ARQUIVAMENTO_CAD = "CADASTRAR LOCAL DE ARQUIVAMENTO";
	public static final String LOCAL_ARQUIVAMENTO_LISTA = "LISTA DE LOCAIS DE ARQUIVAMENTO";
	public static final String LOCAL_ARQUIVAMENTO_EDITAR = "EDITAR LOCAL DE ARQUIVAMENTO";
	public static final String LOCAL_ARQUIVAMENTO_EXCLUIR = "EXCLUIR LOCAL DE ARQUIVAMENTO";
	public static final String JUNTAR_PROCESSO = "JUNTAR PROCESSO";
	public static final String DOWNLOAD_ANEXO = "BAIXAR ARQUIVO DO DOC. EM ANEXO";
}
