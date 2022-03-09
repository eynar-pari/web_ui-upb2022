package pages;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class LeftSection {

    public Button addNewProjectButton = new Button(By.xpath("//td[text()='Add New Project']"));
    public Button addButton = new Button(By.id("NewProjNameButton"));
    public TextBox nameProjectTxtBox = new TextBox(By.id("NewProjNameInput"));

    public Button optionButton = new Button(By.xpath("//div[@style='display: block;']/img"));
    public Button editButton = new Button(By.xpath("//ul[contains(@style,'block')]/li/a[text()='Edit']"));
    public TextBox newNameTextBox = new TextBox(By.xpath("//td/div/input[@id='ItemEditTextbox']"));
    public Button saveButton = new Button(By.xpath("//td/div/img[@id='ItemEditSubmit']"));

    public Button deleteButton = new Button(By.id("ProjShareMenuDel"));

    public  LeftSection(){}

    public boolean isProjectNameDisplayed(String name){
        Label nameProject = new Label(By.xpath("//li[last()]//td[text()='"+name+"']"));
        return nameProject.isControlDisplayed();
    }

    public void clickNameProject(String name){
        Label nameProject = new Label(By.xpath("//li[last()]//td[text()='"+name+"']"));
        nameProject.click();
    }



}
