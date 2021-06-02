package com.bets.Bets.Cotrollers;
import java.util.ArrayList;
import java.util.List;
import com.bets.Bets.Models.BetModel;
import com.bets.Bets.Respositories.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @GetMapping(path="/{id}")
    public String getBets(@PathVariable("id") String id){
        try{
            if(id==null || Validdate.isNumeric(id.toString())){
                return "Operacion Fallida";
       
            }
            else{
                return betRepository.activatebet(Long.valueOf(id));
            }
        }catch(Exception w){
            return "Operacion Fallida";
        }
    }
    @PostMapping()
    public String makebet(@RequestBody Long id){
        try{
            if(id==null || Validdate.isNumeric(id.toString())){
                return "Operacion Fallida";
       
            }
            else{
                return betRepository.activatebet(Long.valueOf(id));
            }
        }catch(Exception w){
            return "Operacion Fallida";
        }
    }
}
