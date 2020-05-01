package mx.com.tiendas3b.evale.service;

import mx.com.tiendas3b.evale.model.custom.KeyRequest;
import mx.com.tiendas3b.evale.model.custom.KeyResponse;
import mx.com.tiendas3b.evale.model.custom.SaldoRequest;
import mx.com.tiendas3b.evale.model.custom.SaldoResponse;
import mx.com.tiendas3b.evale.model.custom.TransactionRequest;
import mx.com.tiendas3b.evale.model.custom.TransactionResponse;

public interface SaldoService {
	SaldoResponse getSaldo(SaldoRequest saldoRequest);

	KeyResponse getKey(KeyRequest keyRequest);
	
	TransactionResponse registryTransaction(TransactionRequest transactionRequest);
}
