package com.PracticeProject.library.step_definitions;

import com.PracticeProject.library.pages.UsersPage;
import com.PracticeProject.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.List;


public class UsersTableDefinitions {
    UsersPage usersPage = new UsersPage();

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumnNames) {

      //  System.out.println("expectedColumnName = "+expectedColumnNames);
     //   System.out.println("expectedColumnNames.size()= "+ expectedColumnNames.size());

        BrowserUtils.waitForVisibility(usersPage.showRecordsDropdown, 2);

        List<String> actualColumnNames = BrowserUtils.getElementsText(usersPage.tableHeaders);

        Assert.assertEquals( "Account username is not expected!", expectedColumnNames, actualColumnNames);
    }


}
