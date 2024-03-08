package iut.montreuil.DbManagementMS.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import iut.montreuil.DbManagementMS.app.model.Annonce;
import iut.montreuil.DbManagementMS.app.service.AnnonceService;

@RestController
@RequestMapping("/annonce")
public class AnnonceController {
	
	@Autowired
	private AnnonceService annonceService;
	
	@PostMapping
	public Annonce createAnnonce(@RequestBody Annonce annonce) {
		return annonceService.createAnnonce(annonce);
	}
	
	@GetMapping("get")
	public List<Annonce> getAllAnnonces() {
		return annonceService.getAllAnnonces();
	}
	
	@GetMapping("get/{id}")
    public Optional<Annonce> getAnnonceById(@PathVariable Long id) {
		System.err.println(annonceService.getAnnonceById(id));
        return annonceService.getAnnonceById(id);
    }
	
    @PutMapping("put/{id}")
    public Annonce updateAnnonce(@PathVariable Long id, @RequestBody Annonce annonceDetails) {
    	System.err.println(annonceService.updateAnnonce(id, annonceDetails));
    	return annonceService.updateAnnonce(id, annonceDetails);
    }
	
    @DeleteMapping
    @RequestMapping("delete")
    public String deleteAllAnnonces() {
    	annonceService.deleteAllAnnonce();
        return "All annonces have been deleted successfully.";
    }

    @DeleteMapping
    @RequestMapping("delete/{id}")
    public String deleteAnnonce(@PathVariable Long id) {
        annonceService.deleteAnnonce(id);
        return "Annonce "+ id +" have been deleted successfully.";
    }
}
