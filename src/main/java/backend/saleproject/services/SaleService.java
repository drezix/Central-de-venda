package backend.saleproject.services;

import backend.saleproject.models.Sale;
import backend.saleproject.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }
}
