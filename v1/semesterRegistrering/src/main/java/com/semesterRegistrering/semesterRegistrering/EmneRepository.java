package com.semesterRegistrering.semesterRegistrering;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmneRepository extends JpaRepository<Emne, String> {

    // Henter alle emner for et gitt semester
    List<Emne> findBySemester(String semester);

    // (valgfritt) Henter alle valgemner for et gitt semester og type (hvis du bruker det senere)
    List<Emne> findBySemesterAndType(String semester, String type);
}