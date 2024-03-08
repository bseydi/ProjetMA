package iut.montreuil.BoManagementMS.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import iut.montreuil.BoManagementMS.app.configuration.AppConfig;
import iut.montreuil.BoManagementMS.app.model.Annonce;

@Service
public class BoAnnonceService {

	private AppConfig appConfig = new AppConfig();

	@Autowired
	private RestTemplate restTemplate = appConfig.restTemplate();

	public List<Annonce> getAllAnnonces() {
		String baseUrl = "http://localhost:8080/annonce";
		String endPoint = "/get";

		ResponseEntity<List<Annonce>> responseEntity = restTemplate.exchange(
				baseUrl + endPoint,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Annonce>>() {}
				);
		List<Annonce> annonces = responseEntity.getBody();

		HttpStatusCode statusCode = responseEntity.getStatusCode();

		System.out.println(annonces);
		System.out.println(statusCode);
		
		return annonces;
	}
	
	public Optional<Annonce> getAnnonceById(Long id) {
		String baseUrl = "http://localhost:8080/annonce";
		String endPoint = "/get/" + id;
		
		ResponseEntity<Optional<Annonce>> responseEntity = restTemplate.exchange(
				baseUrl + endPoint,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<Optional<Annonce>>() {}
				);
		Optional<Annonce> annonces = responseEntity.getBody();
		
		return annonces;	
	}
	
	public void deleteAnnonce(Long id) {
	    String baseUrl = "http://localhost:8080/annonce";
	    String endPoint = "/delete/" + id;
    
	    try {
	    	restTemplate.delete(baseUrl + endPoint);
	        System.out.println("Annonce "+ id + " supprimée avec succès.");
	    } catch (HttpStatusCodeException e) {
	        System.out.println("Erreur lors de la suppression de l'annonce : " + e.getStatusCode());
	    }
	}
	
}
