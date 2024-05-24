package backend.saleproject.controllers;

import backend.saleproject.models.Sale;
import backend.saleproject.models.Seller;
import backend.saleproject.repository.SellerRepository;
import backend.saleproject.services.SellerService;
import backend.saleproject.services.SellerService.SellerSalesData;
import backend.saleproject.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private SellerRepository sellerRepository;

    @PostMapping("/")
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        Sale createdSale = saleService.createSale(sale);
        Seller seller = createdSale.getSeller();
        String startDate = "5";
        String endDate = "30";
        List<SellerSalesData> sellerSalesData = sellerService.getSellersSalesData(startDate, endDate);
        Sale sales = new Sale(startDate, sale.getAmount(), seller);
        return ResponseEntity.ok(sales);
    }
}
