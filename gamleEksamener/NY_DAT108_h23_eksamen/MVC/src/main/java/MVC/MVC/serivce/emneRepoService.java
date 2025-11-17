package MVC.MVC.serivce;

import MVC.MVC.model.emne;
import MVC.MVC.repo.EmneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class emneRepoService {

    @Autowired
    EmneRepository emneRepository;


    public List<emne> finnValgemnerForSemester(String semester) {
        char sem = semester.toLowerCase().charAt(0);

        return emneRepository.findAll().stream()
                .filter(emne -> emne.getSemester() == sem)
                .collect(Collectors.toList());
    }

    public void registrerInteresseFor(List<String> emnekoder){

    }


}






