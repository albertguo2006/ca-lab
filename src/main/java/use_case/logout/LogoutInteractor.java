package use_case.logout;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private LogoutUserDataAccessInterface userDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute() {
        // Implement the logout logic:
        // 1. remember the current username
        final String currentUsername = this.userDataAccessObject.getCurrentUsername();

        // 2. clear the current username in the DAO
        this.userDataAccessObject.setCurrentUsername(null);

        // 3. create output data and notify the presenter
        final LogoutOutputData outputData = new LogoutOutputData(currentUsername);
        this.logoutPresenter.prepareSuccessView(outputData);
    }
}

