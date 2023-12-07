package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ChangeLanguage {

    private final Page page;
        Locator cookies;
        Locator iconToChangeLanguage;
        Locator chooseEnglishSuchAsWebsiteLanguage;
        Locator selectedLanguage;

        public ChangeLanguage(Page page) {
            this.page = page;
            this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar alla cookies"));
            this.iconToChangeLanguage = page.locator("li.lang__selector--desktop.s__show--on-tablet--large--up a.js__navfeature--toggle svg.icon__right").first();
            this.chooseEnglishSuchAsWebsiteLanguage = page.getByTitle("Välj språk: English (Sweden)");
            this.selectedLanguage = page.locator(".icon[aria-label='Selected language: English (Sweden)']").first();
        }
        public void changeWebsiteLanguage(){
                page.navigate("https://www.biltema.se/");
                cookies.click();
                iconToChangeLanguage.click();
                chooseEnglishSuchAsWebsiteLanguage.click();

        }

    public Page getPage() {
        return page;
    }

    public Locator getCookies() {
        return cookies;
    }

    public void setCookies(Locator cookies) {
        this.cookies = cookies;
    }

    public Locator getIconToChangeLanguage() {
        return iconToChangeLanguage;
    }

    public void setIconToChangeLanguage(Locator iconToChangeLanguage) {
        this.iconToChangeLanguage = iconToChangeLanguage;
    }

    public Locator getChooseEnglishSuchAsWebsiteLanguage() {
        return chooseEnglishSuchAsWebsiteLanguage;
    }

    public void setChooseEnglishSuchAsWebsiteLanguage(Locator chooseEnglishSuchAsWebsiteLanguage) {
        this.chooseEnglishSuchAsWebsiteLanguage = chooseEnglishSuchAsWebsiteLanguage;
    }

    public Locator getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(Locator selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }
}


