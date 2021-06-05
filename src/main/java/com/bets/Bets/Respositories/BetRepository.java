package com.bets.Bets.Respositories;
import java.util.List;
import com.bets.Bets.Models.BetModel;
import com.bets.Bets.Models.IndivudualBetModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class BetRepository {
    private JdbcTemplate jdbcTemplate;
    public BetRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<BetModel> getidcreated() {
        jdbcTemplate.update("INSERT INTO bets VALUES (?,?, default, default, default)", null, "unable");
        List<BetModel> Last = jdbcTemplate.query("SELECT * FROM bets ORDER BY id DESC LIMIT 1", new BetMapper());

        return Last;
    }
    public String activatebet(Long id) {
        try {
            jdbcTemplate.update("UPDATE bets SET status='enabled' WHERE ?", id);

            return "Operacion Exitosa";
        } catch (Exception e) {

            return "Operacion Fallida";
        }

    }
    public String makebet(IndivudualBetModel datarequest) {
        try {
            jdbcTemplate.update("INSERT INTO individualbet VALUES (?,?,?,?,?, default, default, default)",
                    datarequest.getIdbet(), datarequest.getIduser(), datarequest.getCredit(), datarequest.getColor(),
                    datarequest.getNumber());

            return "Operacion Exitosa";
        } catch (Exception e) {

            return "Operacion Fallida";
        }
    }
    public List<IndivudualBetModel> closebet(Integer randomnumber, String Color, Long idbet) {
        List<BetModel> validate = jdbcTemplate.query("SELECT * FROM bets WHERE id=?", new BetMapper(), idbet);
            if(validate.get(0).getStatus().equals("enabled")){
            jdbcTemplate.update("UPDATE bets SET status='closed', numbergain=? WHERE id=?", randomnumber, idbet);
            jdbcTemplate.update("UPDATE individualbet SET status='sin ganancia' WHERE number<>? AND color<>?",
                    randomnumber, Color);
            jdbcTemplate.update("UPDATE individualbet SET gain= credit*1.8, status='ganador' WHERE color=?", Color);
            jdbcTemplate.update("UPDATE individualbet SET gain= credit*5, status='ganador' WHERE number=?",
                    randomnumber);
            }

        return jdbcTemplate.query("SELECT * FROM individualbet INNER JOIN users ON iduser=id WHERE idbet=?",
                new IndividualbetMapper(), idbet);
    }
    public List<BetModel> getallbet() {
        return jdbcTemplate.query("SELECT * FROM bets", new BetMapper());
    }

}
