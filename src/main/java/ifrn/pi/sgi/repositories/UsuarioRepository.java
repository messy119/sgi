package ifrn.pi.sgi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.sgi.models.SGI;
import ifrn.pi.sgi.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	List<Usuario> findBySgi(SGI sgi);

	
}
