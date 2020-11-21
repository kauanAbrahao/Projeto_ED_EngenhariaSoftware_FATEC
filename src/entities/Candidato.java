package entities;

public class Candidato {
	
	Candidato proximo;
	Candidato anterior;
	private String login;
	private String senha;
	private String nome;
	private String telefone;
	private String cpf;
	private ProcessoSeletivo processoSeletivo = new ProcessoSeletivo();
	private String lattes;
	private String historico;
	private String notaEntrevista;
	private String notaLattes;
	private String notaFinal;
	private String status;
	private String dataEntrevista;
	private String divulgaNotaFinal;
	
	
	
	public Candidato(String login, String senha, String nome, String cpf, String telefone, String lattes, String historico,
			String notaLattes2, String notaEntrevista2, String notaFinal2, String status, String dataEntrevista, String divulgaNotaFinal) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.lattes = lattes;
		this.historico = historico;
		this.notaLattes = notaLattes2;
		this.notaEntrevista = notaEntrevista2;
		this.notaFinal = notaFinal2;
		this.status = status;
		this.dataEntrevista = dataEntrevista;
		this.divulgaNotaFinal = divulgaNotaFinal;
	}
	
	public Candidato() {
		processoSeletivo = new ProcessoSeletivo();
		this.lattes = "semlattes";
		this.historico = "semhistorico";
		this.notaEntrevista = "ne-1";
		this.notaLattes = "nl-1";
		this.notaFinal = "nf-1";
		this.status = "semstatus";
		this.dataEntrevista = "semdata";
		this.divulgaNotaFinal = "N";
	}
	
	public Candidato getProximo() {
		return proximo;
	}

	public void setProximo(Candidato proximo) {
		this.proximo = proximo;
	}

	public Candidato getAnterior() {
		return anterior;
	}

	public void setAnterior(Candidato anterior) {
		this.anterior = anterior;
	}

	public ProcessoSeletivo getProcessoSeletivo() {
		return processoSeletivo;
	}
	public void setProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
		this.processoSeletivo = processoSeletivo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNotaEntrevista() {
		return notaEntrevista;
	}

	public String getDataEntrevista() {
		return dataEntrevista;
	}

	public void setDataEntrevista(String dataEntrevista) {
		this.dataEntrevista = dataEntrevista;
	}

	public void setNotaEntrevista(String notaEntrevista) {
		this.notaEntrevista = notaEntrevista;
	}

	public String getNotaLattes() {
		return notaLattes;
	}

	public void setNotaLattes(String notaLattes) {
		this.notaLattes = notaLattes;
	}

	public String getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(String notaFinal) {
		this.notaFinal = notaFinal;
	}

	public String getStatus() {
		return status;
	}
	public String getLattes() {
		return lattes;
	}

	public void setLattes(String lattes) {
		this.lattes = lattes;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getdivulgaNotaFinal() {
		return divulgaNotaFinal;
	}

	public void setdivulgaNotaFinal(String divulgaNotaFinal) {
		this.divulgaNotaFinal = divulgaNotaFinal;
	}
	
	

}

