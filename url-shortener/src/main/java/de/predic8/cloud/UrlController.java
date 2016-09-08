package de.predic8.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@RestController
public class UrlController {
	@Autowired
	private UrlRepository urlRepository;

	@RequestMapping(value = "/shorten", method = RequestMethod.POST)
	public String shorten(@RequestParam("url") String url) {
		Url entity = urlRepository.findByUrl(url).orElseGet(() -> urlRepository.saveAndFlush(new Url(url)));

		return Long.toString(entity.getId(), 36);
	}

	@RequestMapping(value = "/{hash}", method = RequestMethod.GET)
	public String unShorten(@PathVariable("base36") String base36) {
		return urlRepository.findOne(Long.valueOf(base36, 36)).getUrl();
	}
}