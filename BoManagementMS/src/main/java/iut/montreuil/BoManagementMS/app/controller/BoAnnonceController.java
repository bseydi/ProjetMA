package iut.montreuil.BoManagementMS.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iut.montreuil.BoManagementMS.app.service.BoAnnonceService;
import iut.montreuil.BoManagementMS.app.model.Annonce;

@RestController
@RequestMapping("/boannonce")
public class BoAnnonceController {

	@Autowired
	private BoAnnonceService boAnnonceService;

	@GetMapping("get")
	public List<Annonce> getAllAnnonces(@RequestHeader("Authorization") String token) throws Exception {
		return boAnnonceService.getAllAnnonces();	
	}

	@GetMapping("get/{id}")
	public Optional<Annonce> getAnnonceById(@PathVariable Long id, @RequestHeader("Authorization") String token) throws Exception {
		return boAnnonceService.getAnnonceById(id);	
	}

	@DeleteMapping
	@RequestMapping("delete/{id}")
	public String deleteAnnonce(@PathVariable Long id, @RequestHeader("Authorization") String token) {    
		boAnnonceService.deleteAnnonce(id);
		return "Annonce " + id + " has been deleted successfully.";
	}
}
