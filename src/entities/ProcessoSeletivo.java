package entities;

import java.util.Calendar;
import java.util.Date;

public class ProcessoSeletivo {
		private String curso;
		private Date datainicio;
		private Date datafinal;
		private int vagas;
		Calendar cal = Calendar.getInstance();
		
		
//		Aqui est� definido a data de in�cio do ProcessoSeletivo para 01/11/2020, e t�rmino 30 dias ap�s. O curso e a vaga
//		est�o chumbados. (Mestado em Intelig�ncia Artifical com 5 Vagas). Mas podemos criar uma funcionalidade para o 
//		CRA ou o CPS criar esse Processo Seletivo com as informa��es que eles quiserem, s� passar os par�metros.
		
		@SuppressWarnings("deprecation")
		public ProcessoSeletivo() {
			this.curso = "Mestrado em Intelig�ncia Artificial";
			this.vagas = 5;
			this.datainicio = new Date(2020, 11, 1);
			this.cal.setTime(datainicio);
			cal.add(Calendar.DATE, 30);
			this.datafinal = cal.getTime();
		}
		
		

//		M�todos get e set
		public String getCurso() {
			return curso;
		}


		public void setCurso(String curso) {
			this.curso = curso;
		}


		public Date getDatainicio() {
			return datainicio;
		}


		public void setDatainicio(Date datainicio) {
			this.datainicio = datainicio;
		}


		public Date getDatafinal() {
			return datafinal;
		}


		public void setDatafinal(Date datafinal) {
			this.datafinal = datafinal;
		}


		public int getVagas() {
			return vagas;
		}


		public void setVagas(int vagas) {
			this.vagas = vagas;
		}
}
