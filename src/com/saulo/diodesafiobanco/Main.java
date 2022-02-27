package com.saulo.diodesafiobanco;

import java.util.ArrayList;
import java.util.List;

import com.saulo.diodesafiobanco.model.Banco;
import com.saulo.diodesafiobanco.model.Cliente;
import com.saulo.diodesafiobanco.model.Conta;

public class Main {

	public static void main(String[] args) {
		
		Banco banco = new Banco();
		
		System.out.println("=========== " + banco.getNome() + " ==============");
		
		banco.adicionarCliente("Saulo");
		banco.adicionarCliente("Maria");
		banco.adicionarCliente("João");
		banco.adicionarCliente("Renata");
		
		System.out.println("\n=========== Imprimindo Extratos Zerados ==============");
		imprimirExtratos(banco.getListaCliente());
		
		System.out.println("\n=========== Depositando na conta da Renata ==============");	
		banco.getListaCliente().get(banco.getListaCliente().indexOf(new Cliente("Renata"))).getContaCorrente().depositar(200);
		banco.getListaCliente().get(banco.getListaCliente().indexOf(new Cliente("Renata"))).getContaPoupanca().depositar(400);
		
		System.out.println("\n=========== Sacando da conta da Renata ==============");	
		banco.getListaCliente().get(banco.getListaCliente().indexOf(new Cliente("Renata"))).getContaCorrente().sacar(20);
		banco.getListaCliente().get(banco.getListaCliente().indexOf(new Cliente("Renata"))).getContaPoupanca().sacar(40);
		
		System.out.println("\n===== Transferindo da cc Renata para cp Saulo ==============");
		banco.getListaCliente().get(banco.getListaCliente().indexOf(new Cliente("Renata"))).getContaCorrente().transferir(20, banco.getListaCliente().get(banco.getListaCliente().indexOf(new Cliente("Saulo"))).getContaPoupanca());
		
		
		System.out.println("\n=========== Imprimindo Extratos Depois das Transações ==============");
		imprimirExtratos(banco.getListaCliente());
		
	}
	
	private static void imprimirExtratos(List<Cliente> clientes) {
		for(int i = 0; i < clientes.size(); i++) {
			imprimirExtrato(clientes.get(i).getContaCorrente(), clientes.get(i).getContaPoupanca());
			System.out.println("----------");
		}
		
	}

	private static void imprimirExtrato(Conta cc, Conta cp) {
		cc.imprimirExtrato();
		cp.imprimirExtrato();
	}

}
