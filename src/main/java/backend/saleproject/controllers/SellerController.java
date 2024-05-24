package backend.saleproject.controllers;

import backend.saleproject.repository.SellerRepository;
import backend.saleproject.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import backend.saleproject.models.Seller;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private SellerService sellerService;

    @PostMapping("/")
    public ResponseEntity<Seller> create(@RequestBody Seller seller) {
        Seller sellerName = this.sellerRepository.findByName(seller.getName());

        if (sellerName != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        Seller createdSeller = this.sellerRepository.save(seller);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeller);
    }

    @GetMapping("/data-venda")
    public ResponseEntity<SellerService.SellerSalesData> getSalesData(
            @RequestParam String startDate,
            @RequestParam String endDate) {

        SellerService.SellerSalesData salesDate = (SellerService.SellerSalesData) sellerService.getSellersSalesData(startDate, endDate);
        return ResponseEntity.ok(salesDate);
    }

}
