package com.avdelingCRUDRepo.avdelingCRUDRepo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Autowired private AvdelingRepo avdelingRepo;
    @Autowired private AnsattRepo ansattRepo;
    @Autowired
    private FirmaService aService;

    /**
     * denne metoden gjør det samme som metoden under!
    @GetMapping(value = "/avdelinger")
    public String avdelinger(Model model) {
        List<Avdeling> avdelinger = avdelingRepo.findAll();
        model.addAttribute("avdelinger", avdelinger);
        return "avdelingerView";
    }
     */

    @GetMapping(value = "/avdelinger")
    @ResponseBody
    public List<Avdeling> avdelinger() {
        return aService.finnAlleAvdelinger();
    }

    //metode for å liste alle ansatte:
    @GetMapping(value = "/ansatte")
    public String alleAnsatte(Model model) {
        List<Ansatt> ansatte = ansattRepo.findAll();
        model.addAttribute("ansatte", ansatte);
        return "ansattView";
    }

    @GetMapping(value = "/avdpaaid", produces = "text/plain")
    @ResponseBody
    public String avdpaaid(@RequestParam int id) {
        Optional<Avdeling> optAvd = avdelingRepo.findById(id);
        if (optAvd.isEmpty()) {
            return "INGEN AVDELING";
        }
        return optAvd.get().toString();
    }

    //hente ut ansatte på id
    @GetMapping(value ="/ansattId")
    public String ansattId(Model model, @RequestParam int id) {
        Ansatt ansatt = ansattRepo.findById(id).get();
        List<Ansatt> liste = List.of(ansatt);
        model.addAttribute("ansatte", liste);
        return "ansattView";
    }


    @GetMapping(value = "/avdpaanavn", produces = "text/plain")
    @ResponseBody
    public String avdpaanavn(@RequestParam String navn) {
        return avdelingRepo.findByNavn(navn).toString(); //Avdeling | null
    }



    //FY - Denne burde vært POST!
    @PostMapping(value = "/nyavd", produces = "text/plain")
    @ResponseBody
    public String nyavd(@RequestParam String navn) {
        Avdeling ny = new Avdeling();
        ny.setNavn(navn);
        avdelingRepo.save(ny);
        return ny.toString();
    }


    @GetMapping(value = "/snittlonnIT", produces = "text/plain")
    @ResponseBody
    public String snittlonn() {
        return "" + aService.snittlonn("IT");
    }

    // ------------------------------------------------------------------------

//	private <T> String listToString(List<T> elementer) {
//		String resultat = elementer.stream()
//    			.map(T::toString)
//    			.collect(Collectors.joining("\n"));
//		return resultat;
//	}
}
