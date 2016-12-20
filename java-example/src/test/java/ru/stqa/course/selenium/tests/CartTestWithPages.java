package ru.stqa.course.selenium.tests;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Maria.Guseva on 20.12.2016.
 */
public class CartTestWithPages extends BaseTest{

    private static final String NO_ITEMS_TEXT = "There are no items in your cart.";

    @Test
    public void test() {
        List<String> productNames = Arrays.asList(new String[] { "Green Duck", "Blue Duck", "Purple Duck" });

        for (String productName : productNames) {
            app.addProductToCart(productName);
        }

        app.openCart();
        int itemsCount = app.getCartItemsCount();
        for (int i = 0; i < itemsCount; i++) {
            app.removeProductFromCart();
        }

        Assert.assertEquals(app.getCartPageNoItemsText(), NO_ITEMS_TEXT);
    }
}
