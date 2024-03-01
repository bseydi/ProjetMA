package iut.montreuil.DbManagementMS.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iut.montreuil.DbManagementMS.app.model.Annonce;
import iut.montreuil.DbManagementMS.app.repository.AnnonceRepository;

@Service
public class AnnonceService {

	@Autowired
	private AnnonceRepository annonceRepository;
	
	public Annonce createAnnonce(Annonce annonce) {
		return annonceRepository.save(annonce);
	}
	
	public List<Annonce> getAllAnnonces() {
		return annonceRepository.findAll();
	}
	
    public Optional<Annonce> getAnnonceById(Long id) {
        return annonceRepository.findById(id);
    }
    
 
    public Annonce updateAnnonce(Long id, Annonce annonceDetails) {
        Optional<Annonce> annonce = annonceRepository.findById(id);
        if (annonce.isPresent()) {
            Annonce existingAnnonce = annonce.get();
            existingAnnonce.setTitle(annonceDetails.getTitle());
            existingAnnonce.setMail(annonceDetails.getMail());
            return annonceRepository.save(existingAnnonce);
        }
        return null;
    }
	
    public void deleteAllAnnonce() {
        annonceRepository.deleteAll();
    }
    
    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }
	
}
