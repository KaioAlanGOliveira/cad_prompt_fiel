package dizimista;

import java.sql.Date;

public class Pagamento {
	int id;
	int cpf;
	Date dataPagamento;
	boolean pago;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Pagamento() {
		
	}
	public Pagamento(int cpf, Date dataPagamento, boolean pago) {
		super();
		this.cpf = cpf;
		this.dataPagamento = dataPagamento;
		this.pago = pago;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public boolean getPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}
}
