package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import singleton.Session;

public class CUDProjectTest extends BaseTodoLy {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    LeftSection leftSection = new LeftSection();
    CentralSection centralSection = new CentralSection();

    @Test
    public void verifyCUDProject() throws InterruptedException {
        mainPage.loginImage.click();
        loginModal.login("clean@upb222.com","abc123");

        leftSection.addNewProjectButton.click();
        leftSection.nameProjectTxtBox.setText("EYNAR");
        leftSection.addButton.click();
        Thread.sleep(2000);
        Assertions.assertEquals("EYNAR",
                centralSection.currentProjectLabel.getTextControl(),
                "ERROR el projecto ni fue creado");

        leftSection.clickNameProject("EYNAR");
        leftSection.optionButton.click();
        leftSection.editButton.click();
        leftSection.newNameTextBox.clearSetText("UPDATE");
        leftSection.saveButton.click();
        Thread.sleep(2000);
        Assertions.assertEquals("UPDATE",
                centralSection.currentProjectLabel.getTextControl(),
                "ERROR el projecto no fue actualizado");

        leftSection.clickNameProject("UPDATE");
        leftSection.optionButton.click();
        leftSection.deleteButton.click();

        Session.getInstance().getDriver().switchTo().alert().accept();

        Thread.sleep(2000);
        Assertions.assertFalse(leftSection.isProjectNameDisplayed("UPDATE"),
                "ERROR el projecto no fue delete");


    }

}
