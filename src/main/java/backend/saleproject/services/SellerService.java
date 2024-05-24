package backend.saleproject.services;

import backend.saleproject.models.Sale;
import backend.saleproject.models.Seller;
import backend.saleproject.repository.SaleRepository;
import backend.saleproject.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private SaleRepository saleRepository;

    public List<SellerSalesData> getSellersSalesData(String startDate, String endDate) {
        List<Seller> sellers = sellerRepository.findAll();

        return sellers.stream().map(seller -> {
            List<Sale> sales = saleRepository.findBySellerAndDateBetween(seller, startDate, endDate);

            long start = Long.parseLong(startDate);
            long end = Long.parseLong(endDate);
            double totalSales = sales.stream().mapToDouble(Sale::getAmount).sum();
            long days = Long.sum(start, end);
            double dailyAverage = days > 0 ? totalSales / days : 0;

            return new SellerSalesData(seller.getName(), totalSales, dailyAverage);}).collect(Collectors.toList());
    }

    public static class SellerSalesData {
        private String sellerName;
        private double totalSales;
        private double dailyAverage;

        public SellerSalesData(String sellerName, double totalSales, double dailyAverage) {
            this.sellerName = sellerName;
            this.totalSales = totalSales;
            this.dailyAverage = dailyAverage;
        }

        public String getSellerName() {
            return sellerName;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public double getTotalSales() {
            return totalSales;
        }

        public void setTotalSales(double totalSales) {
            this.totalSales = totalSales;
        }

        public double getDailyAverage() {
            return dailyAverage;
        }

        public void setDailyAverage(double dailyAverage) {
            this.dailyAverage = dailyAverage;
        }
    }
}


