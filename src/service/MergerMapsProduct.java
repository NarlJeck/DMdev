package service;

import entity.Product;

import java.util.HashMap;
import java.util.Map;

public class MergerMapsProduct {
    public static Map<String, Product> createNewMap(Map<String, Product> firstCollectProducts, Map<String, Product> secondCollectProducts){
        Map<String, Product> newListProduct = new HashMap<>();
        for (Map.Entry<String, Product> entryProductList1 : firstCollectProducts.entrySet()) {
            String firstKeyProduct = entryProductList1.getKey();
            for (Map.Entry<String, Product> entryProductList2 : secondCollectProducts.entrySet()) {
                String secondKeyProduct = entryProductList2.getKey();
                if (firstKeyProduct.equals(secondKeyProduct)) {
                    newListProduct.put(firstKeyProduct, new Product(entryProductList2.getKey(), entryProductList1.getValue().getPrice(), entryProductList2.getValue().getName()));
                    break;
                }
            }
        }
        return newListProduct;
    }
}
