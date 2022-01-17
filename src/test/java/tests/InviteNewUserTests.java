package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.InvitesTestData;
import ui.utils.PropertyReader;

public class InviteNewUserTests extends BaseTest implements InvitesTestData {

    @Test(groups = {"Smoke"}, description = "The test creates an invitation of a new team member")
    public void createInvitationOfNewUserTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        navigationMenuPage.clickOnWorkspaceNavigationTab()
                .clickOnInvitesSubMenuTab()
                .clickOnInviteNewMemberButton()
                .inviteNewUserFillingInAllInputFields(DATA_FOR_INVITATION_OF_NEW_USER_1);
        Assert.assertTrue(verificationUtils.verifyNewUserInvitation(DATA_FOR_INVITATION_OF_NEW_USER_1));
    }

    @Test(groups = {"Critical"}, description = "The test creates an invitation of a new team member without filling in the required input fields")
    public void createInvitationOfNewUserWithoutFillingInRequiredInputFieldsTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        navigationMenuPage.clickOnWorkspaceNavigationTab()
                .clickOnInvitesSubMenuTab()
                .clickOnInviteNewMemberButton()
                .inviteNewUserUsingInvalidData(DATA_FOR_INVITATION_OF_NEW_USER_2);
        Assert.assertEquals(inviteNewUserModalPage.getEmptyEmailErrorMessage(), EXPECTED_EMPTY_EMAIL_ERROR);
        Assert.assertEquals(inviteNewUserModalPage.getEmptyRoleTitleErrorMessage(), EXPECTED_EMPTY_ROLE_TITLE_ERROR);
    }

    @Test(groups = {"Critical"}, description = "The test creates an invitation of a new team member entering an invalid email")
    public void createInvitationOfNewUserUsingInvalidEmailTest() {
        loginPage.login(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        navigationMenuPage.clickOnWorkspaceNavigationTab()
                .clickOnInvitesSubMenuTab()
                .clickOnInviteNewMemberButton()
                .inviteNewUserUsingInvalidData(DATA_FOR_INVITATION_OF_NEW_USER_3);
        Assert.assertEquals(inviteNewUserModalPage.getInvalidEmailErrorMessage(), EXPECTED_INVALID_EMAIL_ERROR);
    }
}