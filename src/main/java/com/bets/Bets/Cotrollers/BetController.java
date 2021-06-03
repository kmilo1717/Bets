package com.bets.Bets.Cotrollers;
import java.util.ArrayList;
import java.util.List;
import com.bets.Bets.Respositories.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bets.Bets.Services.Validdate;
@RestController
@RequestMapping("/bet")
public class BetController {
    @Autowired
    BetRepository betRepository;
    @GetMapping()
    public String createbet() {
        return betRepository.getidcreated().get(0).getId().toString();
    }
    @GetMapping(path = "/{id}")
    public String getBets(@PathVariable("id") String id) {
        try {
            if (id == null || Validdate.isNumeric(id.toString())) {
                
                return "Operacion Fallida";

            } else {
                return betRepository.activatebet(Long.valueOf(id));
            }
        } catch (Exception w) {

            return "Operacion Fallida";
        }
    }
    @PostMapping(path = "/register")
    public String makebet(@RequestHeader Long idbet, @RequestHeader String iduser, @RequestHeader Long number,
            @RequestHeader String color) {
        try {
            if (idbet == null || Validdate.isNumeric(idbet.toString()) || Validdate.isNumeric(iduser.toString())
                    || iduser == null) {

                return "Operacion Fallida";
            } else {
                List<String> datarequest = new ArrayList<String>();
                datarequest.add(idbet.toString());
                datarequest.add(iduser.toString());
                datarequest.add(number.toString());
                datarequest.add(color);

                return betRepository.makebet(datarequest);
            }
        } catch (Exception w) {

            return "Operacion Fallida";
        }
    }
}
