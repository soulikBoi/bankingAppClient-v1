package bank.view.viewController;

import bank.view.ViewHandler;
import bank.view.viewModel.RegistrationViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class RegistrationController {
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private TextField password2;
    @FXML
    private TextField email;
    @FXML
    private Text error;
    private Region root;
    private ViewHandler viewHandler;
    private RegistrationViewModel viewModel;

    public void init(ViewHandler viewHandler, RegistrationViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
        this.userName.textProperty().bindBidirectional(viewModel.userNameProperty());
        this.password.textProperty().bindBidirectional(viewModel.passwordProperty());
        this.password2.textProperty().bindBidirectional(viewModel.password2Property());
        this.email.textProperty().bindBidirectional(viewModel.emailProperty());
        this.error.textProperty().bind(viewModel.errorProperty());
    }

    public Region getRoot() {
        return root;
    }

    @FXML
    private void registerButton() {
        if (viewModel.register()) {
            viewHandler.openView("login");
        }
    }

    @FXML
    private void onEnter() {
        registerButton();
    }

    @FXML
    private void backButton() {
        viewHandler.openView("login");
    }
}

