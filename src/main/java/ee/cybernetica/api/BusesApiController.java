package ee.cybernetica.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-08T12:57:29.477097300+03:00[Europe/Tallinn]")
@Controller
@RequestMapping("${openapi.cityTransport.base-path:}")
public class BusesApiController implements BusesApi {

    private final NativeWebRequest request;

    @Autowired
    public BusesApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
