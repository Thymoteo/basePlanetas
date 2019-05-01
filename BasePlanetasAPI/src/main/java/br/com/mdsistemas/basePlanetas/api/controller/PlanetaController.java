package br.com.mdsistemas.basePlanetas.api.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mdsistemas.basePlanetas.api.dto.PlanetaDTO;
import br.com.mdsistemas.basePlanetas.api.exception.PlanetaNaoEncontradoException;
import br.com.mdsistemas.basePlanetas.api.service.PlanetaService;
import br.com.mdsistemas.basePlanetas.api.service.facade.ServiceFacade;


@RestController
@RequestMapping("/planeta")
public class PlanetaController {
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/listar",
					produces = {"application/json"},
					method = RequestMethod.GET
					)
	public ResponseEntity<?> listarTodos() {
		
		List<PlanetaDTO> planetas = new ArrayList<PlanetaDTO>();
		try {
			planetas = serviceFacade.listarPlanetasDTO();
			return new ResponseEntity(planetas, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(planetas, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/listarHabitaveis",
					produces = {"application/json"},
					method = RequestMethod.GET
					)
	public ResponseEntity<?> listarHabitaveis() {
		
		List<PlanetaDTO> planetas = new ArrayList<PlanetaDTO>();
		try {
			planetas = serviceFacade.listaPlanetasHabitaveis();
			return new ResponseEntity(planetas, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(planetas, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
		
	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/listarPlanetasPorQuadrante/{id}", 
			 produces = { "application/json" }, 
			 method = RequestMethod.GET)
	public ResponseEntity<?> listarPlanetasPorQuadrante(@PathVariable("id") Integer codigo) {
			
			List<PlanetaDTO> planetas = new ArrayList<PlanetaDTO>();
			try {
				planetas = serviceFacade.listaPlanetasPorQuadrante(codigo);
				return new ResponseEntity(planetas,HttpStatus.OK);
			} catch (Exception ex) {
				return new ResponseEntity(planetas, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/listarPlanetasPorClasse/{id}", 
			 produces = { "application/json" }, 
			 method = RequestMethod.GET)
	public ResponseEntity<?> listarPlanetasPorClasse(@PathVariable("id") String codigo) {
			
			List<PlanetaDTO> planetas = new ArrayList<PlanetaDTO>();
			try {
				planetas = serviceFacade.listaPlanetasPorClasse(codigo);
				return new ResponseEntity(planetas,HttpStatus.OK);
			} catch (Exception ex) {
				return new ResponseEntity(planetas, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/listarPlanetasPorAtmosfera/{id}", 
			 produces = { "application/json" }, 
			 method = RequestMethod.GET)
	public ResponseEntity<?> listarPlanetasPorTipoAtmosfera(@PathVariable("id") Integer codigo) {
			
			List<PlanetaDTO> planetas = new ArrayList<PlanetaDTO>();
			try {
				planetas = serviceFacade.listaPlanetasPorTipoAtmosfera(codigo);
				return new ResponseEntity(planetas,HttpStatus.OK);
			} catch (Exception ex) {
				return new ResponseEntity(planetas, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/listarPlanetasPorMassa/{massa}", 
			 produces = { "application/json" }, 
			 method = RequestMethod.GET)
	public ResponseEntity<?> listarPlanetasPorMassa(@PathVariable("massa") Integer massa) {
			
			List<PlanetaDTO> planetas = new ArrayList<PlanetaDTO>();
			try {
				planetas = serviceFacade.listaPlanetasPorMassa(massa);
				return new ResponseEntity(planetas,HttpStatus.OK);
			} catch (Exception ex) {
				return new ResponseEntity(planetas, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/listarPlanetaDiametroEntre/{diametro_inicial}/{diametro_final}", 
			 produces = { "application/json" }, 
			 method = RequestMethod.GET)
	public ResponseEntity<?> listarPlanetaDiametroEntre(
			@PathVariable("diametro_inicial") Integer diametro_inicial,
			@PathVariable("diametro_final") Integer diametro_final
			) {
			
			List<PlanetaDTO> planetas = new ArrayList<PlanetaDTO>();
			try {
				planetas = serviceFacade.listarPlanetaDiametroEntre(diametro_inicial,diametro_final);
				return new ResponseEntity(planetas,HttpStatus.OK);
			} catch (Exception ex) {
				return new ResponseEntity(planetas, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/listarPlanetasDescobertosEntre/{data_inicial}/{data_final}", 
			 produces = { "application/json" }, 
			 method = RequestMethod.GET)
	public ResponseEntity<?> listarPlanetasDescobertosEntre(
			@PathVariable("data_inicial") String string_inicial,
			@PathVariable("data_final") String string_final
			) {
			
			List<PlanetaDTO> planetas = new ArrayList<PlanetaDTO>();
			try {
				
				SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
				
				Date data_inicial = formato.parse(string_inicial);
				Date data_final = formato.parse(string_final);
				
				planetas = serviceFacade.listaPlanetasDescobertosEntre(data_inicial,data_final);
				return new ResponseEntity(planetas,HttpStatus.OK);
			} catch (Exception ex) {
				return new ResponseEntity(planetas, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/salvar",
    produces = { "application/json" }, 
    consumes = { "application/json" }, 
    method = RequestMethod.POST)
	public ResponseEntity<?> salvarPlaneta(@RequestBody PlanetaDTO planeta) {
		try {
			
 			int id = serviceFacade.salvarPlaneta(planeta);
			String response = "{\"id\":"+id+"}";
			return new ResponseEntity(response, HttpStatus.OK) ;
			
		} catch (PlanetaNaoEncontradoException cnex) { 
			String response = "{\"message\":\""+cnex.getMessage()+"\"}";
			return new ResponseEntity(response, HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			String response = "{\"message\":\""+ex.getMessage()+"\"}";
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/excluir/{id}",
	produces = { "application/json" }, 
    method = RequestMethod.DELETE)
	public ResponseEntity<?> excluirPlaneta(@PathVariable("id") Integer idPlaneta) {
		try {
			
			serviceFacade.excluirPlaneta(idPlaneta);
			return new ResponseEntity(null, HttpStatus.OK) ;
			
		} catch (PlanetaNaoEncontradoException cnex) { 
			String response = "{\"message\":\""+cnex.getMessage()+"\"}";
			return new ResponseEntity(response, HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			String response = "{\"message\":\""+ex.getMessage()+"\"}";
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
