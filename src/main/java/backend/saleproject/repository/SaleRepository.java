package backend.saleproject.repository;

import backend.saleproject.models.Seller;
import backend.saleproject.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findBySellerAndDateBetween(Seller seller, String startDate, String endDate);
}
