package Model.Entities;

import javafx.scene.image.Image;

public class LeadBoardCard {
    private Image avatar;
    private String name;
    private int totalPoints;
    private int rank;

    public LeadBoardCard(Image avatar, String name, int totalPoints, int rank) {
        this.setAvatar(avatar);
        this.setName(name);
        this.setTotalPoints(totalPoints);
        this.setRank(rank);
    }


    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
