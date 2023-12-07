package Tests;

import Pages.AddToCart;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AddToCartTest extends TestBase {
    @Test
    void addToCart(){
        AddToCart addToCartItem= new AddToCart(page);
        addToCartItem.addToCart();
        assertThat(addToCartItem.getItemInCart()).isVisible();
        assertThat(page).hasURL("https://checkout.biltema.se/");
    }
}
