package mx.com.tiendas3b.evale.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tiendas3b.evale.model.EvaleTiendas;

public interface EvaleTiendasRepository extends CrudRepository<EvaleTiendas, Integer> {

	@Query(value = "call tregalo_valida_llave(?1, ?2);", nativeQuery = true)
	EvaleTiendas validateKey(String key, String tclave);

	@Query(value = "call tregalo_trae_llave(?1);", nativeQuery = true)
	EvaleTiendas getKey(String tclave);
	
	@Modifying
	@Transactional
	@Query(value = "call tregalo_registra_llave(?1, ?2, ?3, ?4);", nativeQuery = true)
	void keyRegistry(String tclave, String caja, String key, Integer id);

}
