package more_on_streams;

import org.assertj.core.util.Lists;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductInfo p1 = new ProductInfo("apples","123",1.00, 5);
        ProductInfo p2 = new ProductInfo("pear","765",2.00, 10);
        ProductInfo p3 = new ProductInfo("banana","344",0.33, 40);
        ProductInfo p4 = new ProductInfo("onions","877",0.89, 60);


        List<ProductInfo> products = Lists.newArrayList(new ProductInfo[]{p1,p2,p3,p4});

        System.out.println(products);

        int sumQuantity = products.stream()
                .map(product -> product.getQuantity())
                .reduce(0, (a,b) -> a+b);
        System.out.println(sumQuantity);
    }
}
