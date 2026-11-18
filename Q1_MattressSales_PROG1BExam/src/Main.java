void main() {
    Scanner input= new Scanner(System.in);
// Single-dimensional array
    String[] products = {"Cozy Nights Monarch mattress", "Restonic Barbados mattress", "Sealy Phuket mattress"};
// Two-dimensional array
    int[][] sales = new int[3][3];
// Capture sales

    for (int i = 0; i < products.length; i++) {
        for (int j = 0; j < 3; j++) {
            System.out.print("Enter number of sales for month " + (j + 1) + " for" + products[i] + ": ");
            sales[i][j] = input.nextInt();
        }
        System.out.println();

    }
    Product productObj = new Product(products, sales);
    PrintProduct printer = new PrintProduct();
    printer.printReport(productObj);

    input.close();


}
