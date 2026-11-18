public class Product implements IProducts{
    // Single-dimensional array for  product names
    private String[] productNames;
    // Two-dimensional array for sales
    private  int[][] sales;
   public Product(String[] productNames, int[][] sales){
       this.productNames= productNames;
       this.sales= sales;
   }

    @Override
    public int GetTotalProductsSold() {
       int total=0;
       for (int i=0; i< sales.length;i++){
           for (int j=0; j< sales[i].length; j++){
               total += sales[i][j];
           }
       }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
      int total= GetTotalProductsSold();
      int count= sales.length *  sales[0].length; //3x3=9
       return(double) total/ count;
    }

    @Override
    public String GetMostPopularProduct() {
       int maxTotal= 1;
       String popular= "";
       for (int i=0; i< sales.length; i++){
           int productTotal= 0;
           for (int j=0; j< sales[i].length; j++){
               productTotal+= sales[i][j];
           }
           if (productTotal > maxTotal){
               maxTotal= productTotal;
               popular= productNames[i];
           }
       }
        return popular;
    }

    public String[] getProductNames() {
        return productNames;
    }

    public int[][] getSales() {
        return sales;
    }
}
