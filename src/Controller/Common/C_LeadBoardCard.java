package Controller.Common;

import Model.Entities.LeadBoardCard;
import javafx.scene.control.Label;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class C_LeadBoardCard {
    public static LeadBoardCard leadBoardCard;
    public Label lbl_Name;
    public Circle img_Avatar;
    public Label lbl_Points;
    public Label lbl_Rank;

    public  void initialize(){
        if(leadBoardCard != null){
            img_Avatar.setFill(new ImagePattern(leadBoardCard.getAvatar()));
            lbl_Name.setText(leadBoardCard.getName());
            lbl_Points.setText(String.valueOf(leadBoardCard.getTotalPoints()));
            lbl_Rank.setText(String.valueOf(leadBoardCard.getRank()));
        }
    }
}
