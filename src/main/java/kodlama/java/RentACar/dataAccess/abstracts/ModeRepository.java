package kodlama.java.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.java.RentACar.entities.concretes.Model;

public interface ModeRepository extends JpaRepository<Model, Integer>{

}
