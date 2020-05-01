package mx.com.tiendas3b.evale.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mx.com.tiendas3b.evale.model.RegistryTransaction;

public interface TransactionRepository extends CrudRepository<RegistryTransaction, Integer> {

	@Query(value = "call tregalo_log_inserta_trans_uni(?1, ?2, ?3, ?4, ?5, ?6);", nativeQuery = true)
	RegistryTransaction registryTransaction(Integer logId, String numTarjeta, String tclave, String caja,
			Integer numTicket, Double monto);
}
