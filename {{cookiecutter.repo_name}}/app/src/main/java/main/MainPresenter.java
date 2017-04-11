package {{ cookiecutter.package_name }}.main;

import javax.inject.Inject;

public class MainPresenter {
    private IMainView view;

    @Inject
    public MainPresenter(IMainView view) {
        this.view = view;
    }
}