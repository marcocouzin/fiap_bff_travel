package br.com.fiap.fiap_bff_travel.controller;

import br.com.fiap.fiap_bff_travel.model.Destination;
import br.com.fiap.fiap_bff_travel.model.DestinationOut;
import br.com.fiap.fiap_bff_travel.model.DestiniesReturn;
import br.com.fiap.fiap_bff_travel.util.Util;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController
@RequestMapping("travel")
public class TravelController {

    private final AtomicReference<String> urlAutocomplete = new AtomicReference<>("https://commons.t4w.com.br/new/api/v1/mapping/autocomplete/all/{destinyargument}/managerid/270/token/aac7faba-ca30-4071-a18a-41cda1424bdc");

    private final RestTemplate restTemplate = new RestTemplate();

    @RequestMapping
    public String greeting() {
        return "Hello World";
    }

    @CrossOrigin
    @RequestMapping(value = "/fiaptravel/v1/{destiny}", method = RequestMethod.GET)
    public List<DestiniesReturn> searchDestiniesGrouped(@PathVariable String destiny, @RequestHeader(value = "User-Agent") String userAgent) {

        Util.logNavigation("LISTANDO DESTINOS PARA: " + URLDecoder.decode(destiny, StandardCharsets.UTF_8));

        ResponseEntity<Destination[]> response;
        response = restTemplate.exchange(urlAutocomplete.get()
                , HttpMethod.GET, Util.createHttpEntityHeader(userAgent)
                , Destination[].class
                , URLDecoder.decode(destiny, StandardCharsets.UTF_8));

        Destination[] dest = response.getBody();
        List<DestinationOut> destOut = new ArrayList<>();
        for (Destination destination : Objects.requireNonNull(dest)) {
            destOut.add(new DestinationOut(destination.getType(), destination));
        }

        Map<String, List<Destination>> result = destOut.stream()
                .collect(Collectors.groupingBy(
                                DestinationOut::getGroup,
                                Collectors.mapping(DestinationOut::getSubgroup, Collectors.toList())
                        )
                );

        destOut.clear();
        List<DestiniesReturn> destReturn = new ArrayList<>();
        List<DestiniesReturn> destReturnTemp = new ArrayList<>();

        for (Map.Entry<String, List<Destination>> entry : result.entrySet()) {
            if (entry.getKey().contains("Vicinity")){
                destReturn.add(new DestiniesReturn(entry.getKey(), entry.getValue()));
            }
            else {
                destReturnTemp.add(new DestiniesReturn(entry.getKey(), entry.getValue()));
            }
        }

        destReturn.addAll(destReturnTemp);

        return destReturn;
    }
}
