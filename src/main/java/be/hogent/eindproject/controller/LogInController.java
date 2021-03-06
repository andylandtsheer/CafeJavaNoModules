package be.hogent.eindproject.controller;

import be.hogent.eindproject.controller.DTO.WaiterDTO;
import be.hogent.eindproject.controller.DTO.mappers.WaiterMapper;
import be.hogent.eindproject.model.infrastructure.WaiterRepository;
import be.hogent.eindproject.model.model.Waiter;

public class LogInController extends Controller {
    private WaiterDTO loggedInWaiterDTO;
    private boolean loggedIn = false;

    public LogInController() {
        setNoBodyLoggedInWaiterDTO();
    }

    //for testing with Mocked waiterRepository
    LogInController(WaiterRepository waiterRepository) {
        super(waiterRepository);
        setNoBodyLoggedInWaiterDTO();
    }

    public boolean checkLogin(int waiterId, String password) {
        Waiter waiter = waiterRepository.findByID(waiterId);
        if (waiter.getPassword().equals(password)) {
            loggedInWaiterDTO = WaiterMapper
                    .mapToWaiterDTO(
                            waiterRepository.findByID(waiterId));
            loggedIn = true;
        }
        return loggedIn;
    }

    public WaiterDTO getLoggedInWaiterDTO() {
        return loggedInWaiterDTO;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void logOut() {
        loggedIn = false;
        setNoBodyLoggedInWaiterDTO();
    }

    private void setNoBodyLoggedInWaiterDTO() {
        loggedInWaiterDTO = null;
    }
}
