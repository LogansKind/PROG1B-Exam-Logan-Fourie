public class PrintProduct {
    public void  printReport(Product product){
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("\n******************************************************");
        System.out.println("TOTAL PRODUCT SALES: "+ product.GetTotalProductsSold());
        System.out.println("AVERAGE PRODUCT SALES: "+ (int) product.GetAverageProductSold());
        System.out.println("MOST POPULAR PRODUCT SALES: "+ product.GetMostPopularProduct());

    }
}
