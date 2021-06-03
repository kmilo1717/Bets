package com.bets.Bets.Respositories;
import java.util.List;
import com.bets.Bets.Models.BetModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class BetRepository {
    private JdbcTemplate jdbcTemplate;
 
    public BetRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BetModel> getidcreated() {
        jdbcTemplate.update("insert into bets values (?,?,?)", null, "Example","Unable");
        List<BetModel> Last = jdbcTemplate.query("SELECT * FROM bets ORDER BY id DESC LIMIT 1", new BetMapper());
        return Last;
    }
    public List<BetModel> getAll() {
        return jdbcTemplate.query("select * from bets", new BetMapper());
      }

    public String activatebet(Long id) {
        try{
            int a =jdbcTemplate.update("UPDATE bets SET status='Enabled' WHERE ?", id);
            return "Operacion Exitosa"+ a;
        }catch(Exception e){
            return "Operacion Fallida";
        }    
        
    }
    public String makebet(List<String> datarequest) {
        try{
            jdbcTemplate.update("INSERT INTO individualbet VALUES (?,?,?,?)", datarequest.get(0), datarequest.get(1), datarequest.get(2),datarequest.get(3));
            return "Operacion Exitosa";
        }catch(Exception e){
            return "Operacion Fallida";
        }  
    }    
    
}
