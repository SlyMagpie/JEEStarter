package lt.vu.auth;

import org.apache.deltaspike.security.api.authorization.Secures;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Authorizer {

    @Inject
    private AuthenticatedUserHolder authenticatedUserHolder;

    @Secures
    @UserLoggedInArbaRagai
    public boolean tikrinamArPrisijunges() {
        return authenticatedUserHolder.isAuthenticated();
    }

    @Secures
    @AdministratorArbaKrantai
    public boolean tikrinamArAdminas() {
        return authenticatedUserHolder.isAdmin();
    }
}
