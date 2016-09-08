package de.predic8.cloud;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
public interface UrlRepository extends JpaRepository<Url, Long> {
	Optional<Url> findByUrl(String url);
}
