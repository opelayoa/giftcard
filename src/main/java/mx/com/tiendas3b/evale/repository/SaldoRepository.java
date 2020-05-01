package mx.com.tiendas3b.evale.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.tiendas3b.evale.model.Saldo;

@Repository
public interface SaldoRepository extends CrudRepository<Saldo, Integer> {

	@Query(value = "call tregalo_consulta_saldo(?1, ?2, ?3, ?4, ?5, ?6, ?7);", nativeQuery = true)
	Saldo getSaldo(String numTarjeta, String tclave, String caja, Integer numTicket, String ipLocal, String ipTrans,
			Integer bandera);

	@Query(value = "select tregalo_tarjeta_id_num (?1) as tarjeta_id;", nativeQuery = true)
	Integer validaTarjeta(String numTarjeta);
}
