package backend.saleproject.repository;

import backend.saleproject.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Seller findByName(String name);
    @Query("SELECT se FROM Seller se JOIN FETCH se.sales.data BETWEEN :startDate AND :endDate")
    List<Seller> findSellers(LocalDate startDate, LocalDate endDate);
}
