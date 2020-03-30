package com.hua.shardingjdbc;

/**
 * @author 倪勤华
 * @date 2020-03-15 22:32
 */
public class Test {
    public static void main(String[] args) {
        float fWeight = 1;//首重1kg
        float fPrice = 10;//首重10元一单
        float extWeight = 1, extPrice = 1;//续重1元/1kg
        float weight = 3.4f;//物品重量3.5kg
        System.out.println(weightCost(fWeight, fPrice, extWeight, extPrice, weight));


    }

    private static float weightCost(float fWeight, float fPrice, float extWeight, float extPrice, float weight) {
        float value = 0;
        if (weight <= 0)
            return value;
        if (weight <= fWeight)
            return fPrice;
        int overWeight = (int) (weight - fWeight);
        if (overWeight < weight - fWeight)
            overWeight++;
        return fPrice + overWeight / extWeight * extPrice;
    }

}
