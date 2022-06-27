package Model.Database;

import Model.Entities.LeadBoardCard;
import Utils.DBConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public class DashboardService {

    ArrayList<LeadBoardCard> leadBoardCards = new ArrayList<LeadBoardCard>();

    public ArrayList<LeadBoardCard> getLeadBoard() throws SQLException, ClassNotFoundException {
        String sql = "SELECT avatar , first_name , last_name , marks"
        DBConnection.getInstance().getConnection().prepareStatement(sql);
    }
}
