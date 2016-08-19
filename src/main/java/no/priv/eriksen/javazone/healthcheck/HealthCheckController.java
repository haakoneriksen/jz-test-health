package no.priv.eriksen.javazone.healthcheck;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthCheckController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(method = RequestMethod.GET, path = "/healthcheck")
    public @ResponseBody String getHealthChecks() {
        final Collection<HealthCheck> values = applicationContext.getBeansOfType(HealthCheck.class).values();

        boolean allIsWell = true;
        List<String> failReasons = new ArrayList<>();
        for (HealthCheck hc : values) {
            if (hc.getResult().value == HealthCheck.Result.Value.FAIL) {
                allIsWell = false;
                failReasons.add(hc.getClass().getSimpleName() + ":" + hc.getResult().failReason.orElse("Unknown reason"));
            }
        }

        if (allIsWell) {
            return "OK";
        } else {
            return "FAIL" + " " + failReasons.stream().collect(Collectors.joining(", "));
        }
    }

}

