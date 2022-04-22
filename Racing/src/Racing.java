import java.util.Map;

public class Racing {

    private String raceDate;
    private Map<String,Integer> places;

    Racing(String rDate, Map<String,Integer> positions){

        this.raceDate = rDate;
        this.places = places;
    }
    public String getrDate(){
        return raceDate;
    }
    public void setrDate(String rDate){
        this.raceDate = rDate;
    }
    public Map<String,Integer>getPositions(){
        return places;
    }
    public void setPositions(Map<String,Integer>positions){
        this.places = positions;
    }
}
