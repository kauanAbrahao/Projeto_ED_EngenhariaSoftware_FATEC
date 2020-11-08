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
	
	
	
	
	public Candidato(String nome, String telefone, String cpf, String processoSeletivo, String lattes, String historico, String notaEntrevista2,
			String notaLattes2, String notaFinal2, String status) {
		this.processoSeletivo.setCurso(processoSeletivo);
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.lattes = lattes;
		this.historico = historico;
		this.notaEntrevista = notaEntrevista2;
		this.notaLattes = notaLattes2;
		this.notaFinal = notaFinal2;
		this.status = status;
	}

	public Candidato() {
		processoSeletivo = new ProcessoSeletivo();
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
	
	
	

}
