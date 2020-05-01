package mx.com.tiendas3b.evale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tiendas3b.evale.model.custom.KeyRequest;
import mx.com.tiendas3b.evale.model.custom.KeyResponse;
import mx.com.tiendas3b.evale.model.custom.SaldoRequest;
import mx.com.tiendas3b.evale.model.custom.SaldoResponse;
import mx.com.tiendas3b.evale.model.custom.TransactionRequest;
import mx.com.tiendas3b.evale.model.custom.TransactionResponse;
import mx.com.tiendas3b.evale.service.SaldoService;

@RestController(value = "/")
public class EvaleController {

	@Autowired
	SaldoService saldoService;

	@PostMapping(path = "/balance")
	public SaldoResponse getSaldo(@RequestBody SaldoRequest saldoRequest) {
		return saldoService.getSaldo(saldoRequest);
	}

	@PostMapping(path = "/key")
	public KeyResponse getSaldo(@RequestBody KeyRequest keyRequest) {
		return saldoService.getKey(keyRequest);
	}
	
	@PostMapping(path = "/transaction")
	public TransactionResponse registryTransaction(@RequestBody TransactionRequest transactionRequest) {
		return saldoService.registryTransaction(transactionRequest);
	}
}
