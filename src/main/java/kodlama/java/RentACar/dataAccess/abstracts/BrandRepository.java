package kodlama.java.RentACar.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.java.RentACar.entities.concretes.Brand;


public interface BrandRepository extends JpaRepository<Brand,Integer>{
	boolean existsByName(String name);
}
