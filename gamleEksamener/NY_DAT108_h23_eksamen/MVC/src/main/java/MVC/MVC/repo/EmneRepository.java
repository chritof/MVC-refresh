package MVC.MVC.repo;

import MVC.MVC.model.emne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmneRepository extends JpaRepository<emne, String> {
    //List<emne> findAll()
    //emne findById(String emnekode)
}
