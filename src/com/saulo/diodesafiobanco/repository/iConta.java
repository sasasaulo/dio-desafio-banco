package com.saulo.diodesafiobanco.repository;

import com.saulo.diodesafiobanco.model.Conta;

public interface iConta {

	void sacar (double valor);
	
	void depositar (double valor);
	
	void transferir(double valor, Conta contaDestino);
	
	void imprimirExtrato();
	
}
