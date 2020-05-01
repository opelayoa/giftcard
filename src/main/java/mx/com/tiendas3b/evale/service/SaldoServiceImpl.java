package mx.com.tiendas3b.evale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;

import mx.com.tiendas3b.evale.model.EvaleTiendas;
import mx.com.tiendas3b.evale.model.RegistryTransaction;
import mx.com.tiendas3b.evale.model.Saldo;
import mx.com.tiendas3b.evale.model.custom.ErrorHandler;
import mx.com.tiendas3b.evale.model.custom.KeyRequest;
import mx.com.tiendas3b.evale.model.custom.KeyResponse;
import mx.com.tiendas3b.evale.model.custom.SaldoRequest;
import mx.com.tiendas3b.evale.model.custom.SaldoResponse;
import mx.com.tiendas3b.evale.model.custom.TransactionRequest;
import mx.com.tiendas3b.evale.model.custom.TransactionResponse;
import mx.com.tiendas3b.evale.repository.EvaleTiendasRepository;
import mx.com.tiendas3b.evale.repository.SaldoRepository;
import mx.com.tiendas3b.evale.repository.TransactionRepository;

@Service
public class SaldoServiceImpl implements SaldoService {

	@Autowired
	SaldoRepository saldoRepository;

	@Autowired
	EvaleTiendasRepository evaleTiendasRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public SaldoResponse getSaldo(SaldoRequest saldoRequest) {
		SaldoResponse saldoResponse = new SaldoResponse();
		Saldo saldo = null;

		EvaleTiendas evaleTiendas = evaleTiendasRepository.validateKey(saldoRequest.getKey(), saldoRequest.getTclave());
		if (evaleTiendas != null && evaleTiendas.getId() > 0) {
			Integer validateCard = saldoRepository.validaTarjeta(saldoRequest.getNumTarjeta());
			if (validateCard != null && validateCard > 0) {
				try {
					saldo = saldoRepository.getSaldo(saldoRequest.getNumTarjeta(), saldoRequest.getTclave(),
							saldoRequest.getCaja(), saldoRequest.getNumTicket(), saldoRequest.getIpLocal(),
							saldoRequest.getIpTrans(), saldoRequest.getBandera());

					saldoResponse.setSaldo(saldo);
					ErrorHandler errorHandler = new ErrorHandler();
					errorHandler.setCodigo("00");
					errorHandler.setErrorDescripcion("Consulta realizada con exito");
					saldoResponse.setErrorHandler(errorHandler);
					return saldoResponse;
				} catch (InvalidDataAccessResourceUsageException invalidDataAccessResourceUsageException) {
					ErrorHandler errorHandler = new ErrorHandler();
					errorHandler.setCodigo("03");
					errorHandler.setErrorDescripcion("Esta tarjeta no esta registrada en nuestra base de datos\\nPor favor contacte a su Soporte Regional\\nMensaje No. 80003 ");
					saldoResponse.setErrorHandler(errorHandler);
					saldoResponse.setSaldo(new Saldo());
					return saldoResponse;
				} catch (DataAccessException dataAccessException) {
					ErrorHandler errorHandler = new ErrorHandler();
					errorHandler.setCodigo("04");
					errorHandler.setErrorDescripcion("Error en BD al realizar consulta");
					saldoResponse.setErrorHandler(errorHandler);
					saldoResponse.setSaldo(new Saldo());
					return saldoResponse;
				}
			} else {
				ErrorHandler errorHandler = new ErrorHandler();
				errorHandler.setCodigo("03");
				errorHandler.setErrorDescripcion("Esta tarjeta no esta registrada en nuestra base de datos\\nPor favor contacte a su Soporte Regional\\nMensaje No. 80003 ");
				saldoResponse.setErrorHandler(errorHandler);
				saldoResponse.setSaldo(new Saldo());
				return saldoResponse;
			}

		} else {
			ErrorHandler errorHandler = new ErrorHandler();
			errorHandler.setCodigo("02");
			errorHandler.setErrorDescripcion("Validacion de llave incorrecta");
			saldoResponse.setErrorHandler(errorHandler);
			saldoResponse.setSaldo(new Saldo());
			return saldoResponse;
		}

	}

	@Override
	public KeyResponse getKey(KeyRequest keyRequest) {
		KeyResponse keyResponse = new KeyResponse();
		EvaleTiendas evaleTiendas = evaleTiendasRepository.getKey(keyRequest.getTclave());
		ErrorHandler errorHandler = new ErrorHandler();
		if (evaleTiendas != null) {
			int caja;
			String llaveAct = null;
			try {
				caja = Integer.parseInt(keyRequest.getCaja());
			} catch (NumberFormatException numberFormatException) {
				errorHandler.setCodigo("01");
				errorHandler.setErrorDescripcion("Llave no encontrada para la tienda");
				keyResponse.setErrorHandler(errorHandler);
				return keyResponse;
			}
			switch (caja) {
			case 1:
				llaveAct = evaleTiendas.getPv01();
				break;
			case 2:
				llaveAct = evaleTiendas.getPv02();
				break;
			case 3:
				llaveAct = evaleTiendas.getPv03();
				break;
			case 4:
				llaveAct = evaleTiendas.getPv04();
				break;
			case 5:
				llaveAct = evaleTiendas.getPv05();
				break;
			}
			if (llaveAct == null) {
				errorHandler.setCodigo("01");
				errorHandler.setErrorDescripcion("Llave no encontrada para la tienda");
				keyResponse.setErrorHandler(errorHandler);
				return keyResponse;
			}

			evaleTiendasRepository.keyRegistry(keyRequest.getTclave(), "pv" + keyRequest.getCaja(), llaveAct, 1);
			keyResponse.setKey(llaveAct);
			errorHandler.setCodigo("00");
			errorHandler.setErrorDescripcion("Llave generada con exito");
			keyResponse.setErrorHandler(errorHandler);

		} else {
			errorHandler.setCodigo("01");
			errorHandler.setErrorDescripcion("Llave no encontrada para la tienda");
			keyResponse.setErrorHandler(errorHandler);
		}
		return keyResponse;
	}

	@Override
	public TransactionResponse registryTransaction(TransactionRequest transactionRequest) {

		TransactionResponse transactionResponse = new TransactionResponse();

		EvaleTiendas evaleTiendas = evaleTiendasRepository.validateKey(transactionRequest.getLlave(),
				transactionRequest.getTclave());
		if (evaleTiendas != null && evaleTiendas.getId() > 0) {
			try {
			RegistryTransaction registryTransaction = transactionRepository.registryTransaction(
					transactionRequest.getLogId(), transactionRequest.getTarjetaNum(), transactionRequest.getTclave(),
					transactionRequest.getCaja(), transactionRequest.getNumTicket(), transactionRequest.getMonto());
			transactionResponse.setLogId(registryTransaction.getLogId());
			transactionResponse.setNcEnvio(registryTransaction.getNcEnvio());
			ErrorHandler errorHandler = new ErrorHandler();
			errorHandler.setCodigo("00");
			errorHandler.setErrorDescripcion("Transaccion terminada con exito");
			transactionResponse.setErrorHandler(errorHandler);
			} catch (InvalidDataAccessResourceUsageException invalidDataAccessResourceUsageException) {
				ErrorHandler errorHandler = new ErrorHandler();
				errorHandler.setCodigo("03");
				errorHandler.setErrorDescripcion("Esta tarjeta no esta registrada en nuestra base de datos\\nPor favor contacte a su Soporte Regional\\nMensaje No. 80003 ");
				transactionResponse.setErrorHandler(errorHandler);
				transactionResponse.setLogId(0);
				transactionResponse.setNcEnvio("");
				return transactionResponse;
			} catch (DataAccessException dataAccessException) {
				ErrorHandler errorHandler = new ErrorHandler();
				errorHandler.setCodigo("04");
				errorHandler.setErrorDescripcion("Error en BD al realizar consulta");
				transactionResponse.setErrorHandler(errorHandler);
				transactionResponse.setLogId(0);
				transactionResponse.setNcEnvio("");
				return transactionResponse;
			}
		} else {
			ErrorHandler errorHandler = new ErrorHandler();
			errorHandler.setCodigo("02");
			errorHandler.setErrorDescripcion("Validacion de llave incorrecta");
			transactionResponse.setErrorHandler(errorHandler);
			transactionResponse.setLogId(0);
			transactionResponse.setNcEnvio("");

			return transactionResponse;
		}
		return transactionResponse;
	}

}
