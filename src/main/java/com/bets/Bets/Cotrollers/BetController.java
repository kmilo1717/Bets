package com.bets.Bets.Cotrollers;
import java.util.ArrayList;
import java.util.List;

import com.bets.Bets.Models.BetModel;
import com.bets.Bets.Models.IndivudualBetModel;
import com.bets.Bets.Respositories.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bets.Bets.Services.BetServices;
@RestController
@RequestMapping("/bet")
public class BetController {
    @Autowired
    BetRepository betRepository;
    @GetMapping()
    public String createbetgeneral() {

        return betRepository.getidcreated().get(0).getId().toString();
    }
    @GetMapping(path = "/{id}")
    public String activatebetgeneral(@PathVariable("id") String id) {
        try {
            if (id == null || BetServices.isNumeric(id.toString())) {

                return "Operacion Fallida";

            } else {

                return betRepository.activatebet(Long.valueOf(id));
            }
        } catch (Exception w) {

            return "Operacion Fallida";
        }
    }
    @PostMapping(path = "/register")
    public String makebetindividual(@RequestHeader Long idbet, @RequestHeader Long iduser, @RequestHeader(defaultValue = "-1") Integer number,
            @RequestHeader(defaultValue = "sin definir") String color, @RequestHeader Long credit) {
        try {
            IndivudualBetModel datarequest = new IndivudualBetModel();
            datarequest.setIduser(iduser);
            datarequest.setIdbet(idbet);
            datarequest.setNumber(number);
            datarequest.setCredit(credit);
            datarequest.setColor(color);
            if (datarequest.validatedata()) {

                return betRepository.makebet(datarequest);
            } else {

                return "Operacion Fallida";
            }

        } catch (Exception w) {

            return "Operacion Fallida";
        }
    }
    @GetMapping(path = "/close/{id}")
    public ArrayList<IndivudualBetModel> closebetgeneral(@PathVariable Long id) {
        int randomvalue = (int) (Math.random() * 37);
        String color = BetServices.getcolorvaluerandom(randomvalue);
        ArrayList<IndivudualBetModel> datafinal= new ArrayList<IndivudualBetModel>();
        datafinal.addAll(betRepository.closebet(randomvalue, color, id));

        return datafinal;
    }
    @GetMapping(path = "/getall")
    public List<BetModel> getAllbet() {
        return betRepository.getallbet();
    }
}
