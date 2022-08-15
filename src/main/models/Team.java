package src.main.models;

import java.util.Arrays;
import java.util.Objects;

public class Team {

    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;


    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    public Team (String house, String keeper, String seeker, String[] chasers){
        if (house == null || keeper == null || seeker == null){
            throw new IllegalArgumentException("Field values cannot be null");
        }
        if (house.isBlank() || keeper.isBlank() || seeker.isBlank()){
            throw new IllegalArgumentException("Field values cannot be blank");
        }
        if (chasers.length != 3){
            throw new IllegalArgumentException("Chasers should be 3");
        }
        if (hasNull(chasers) || hasBlank(chasers)){
            throw new IllegalArgumentException("Illegal elements");
        }


        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public Team (Team source){
        this.house = source.house;
        this.keeper = source.keeper;
        this.seeker = source.seeker;
        this.chasers = Arrays.copyOf(source.chasers, source.chasers.length);
    }

    public String getHouse() {
        return house;
    }

    public String getKeeper() {
        return keeper;
    }

    public String getSeeker() {
        return seeker;
    }
    public String[] getChasers() {
        return Arrays.copyOf(chasers, chasers.length) ;
    }

    public void setHouse(String house) {
        checkParameter(house);
        this.house = house;
    }

    public void setKeeper(String keeper) {
        checkParameter(keeper);
        this.keeper = keeper;
    }

    public void setSeeker(String seeker) {
        checkParameter(seeker);
        this.seeker = seeker;
    }

    public void setChasers(String[] chasers) {
        if (chasers.length != 3 || hasNull(chasers) || hasBlank(chasers)){
            throw new IllegalArgumentException("illegal chasers arguments");
        }
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public void checkParameter(String param){
        if (param == null || param.isBlank()){
            throw new IllegalArgumentException(param + " can not be null or blank");
        }
    }

    
     public static String getPositionChaser() {
         return POSITION_CHASER;
     }

     public static String getPositionSeeker() {
         return POSITION_SEEKER;
     }

     public static String getPositionKeeper() {
         return POSITION_KEEPER;
     }

     
    //  Testing functions
     public static boolean hasNull(String[] array ){
        return Arrays.stream(array).anyMatch((element) -> element == null);
     }

     public static boolean hasBlank(String[] array){
         return Arrays.stream(array).anyMatch((element) -> element.isBlank());
     }

     public String toString(){
        return 
        "House: " + this.house + "\n" +
        "Keeper: " + this.keeper + "\n" +         
        "Seeker: "  + this.seeker + "\n" +         
        "Chasers: " + Arrays.toString(this.chasers) + "\n";
     }

     public boolean equals(Object obj){
        if (obj == null){
            return false;
        }

        if (!(obj instanceof Team)){
            return false;
        }

        Team team = (Team)obj;
        return 
        this.house.equals(team.house) && 
        this.keeper.equals(team.keeper) &&
        this.seeker.equals(team.seeker) &&
        Arrays.toString(this.chasers).equals(Arrays.toString(team.chasers));

     }

     public int hashCode(){
        return Objects.hash(house, keeper, seeker, Arrays.toString(this.chasers));
     }



}
