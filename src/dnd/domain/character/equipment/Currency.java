package dnd.domain.character.equipment;

public class Currency {

    private Integer copperPieces;
    private Integer silverPieces;
    private Integer goldPieces;
    private Integer electrumPieces;
    private Integer platinumPieces;

    public double getWeight() {
        
        Double count = Double.valueOf(copperPieces + silverPieces + goldPieces + electrumPieces + platinumPieces);
        count = count/48;
        return count;
    }

    public String getCurrencyDisplay() {

        StringBuilder sb = new StringBuilder();
        String prepend = "";
        if(copperPieces!=null && copperPieces!=0) {
            sb.append(prepend+"CP: " + copperPieces);
            prepend=" ";
        }
        if(silverPieces!=null && silverPieces!=0) {
            sb.append(prepend+"SP: " + silverPieces);
            prepend=" ";
        }
        if(goldPieces!=null && goldPieces!=0) {
            sb.append(prepend+"GP: " + goldPieces);
            prepend=" ";
        }
        if(electrumPieces!=null && electrumPieces!=0) {
            sb.append(prepend+"EP: " + electrumPieces);
            prepend=" ";
        }
        if(platinumPieces!=null && platinumPieces!=0) {
            sb.append(prepend+"PP: " + platinumPieces);
            prepend=" ";
        }

        return sb.toString();
    }

    public Integer getCopperPieces() {
        return copperPieces;
    }
    public void setCopperPieces(Integer copperPieces) {
        this.copperPieces = copperPieces;
    }
    public Integer getSilverPieces() {
        return silverPieces;
    }
    public void setSilverPieces(Integer silverPieces) {
        this.silverPieces = silverPieces;
    }
    public Integer getGoldPieces() {
        return goldPieces;
    }
    public void setGoldPieces(Integer goldPieces) {
        this.goldPieces = goldPieces;
    }
    public Integer getElectrumPieces() {
        return electrumPieces;
    }
    public void setElectrumPieces(Integer electrumPieces) {
        this.electrumPieces = electrumPieces;
    }
    public Integer getPlatinumPieces() {
        return platinumPieces;
    }
    public void setPlatinumPieces(Integer platinumPieces) {
        this.platinumPieces = platinumPieces;
    }


}
