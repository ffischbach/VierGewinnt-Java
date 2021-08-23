public class Player {
    String name;
    String token;

    Player(String name, String token){
        setName(name);
        setToken(token);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getToken(){
        return this.token;
    }

    public void setToken(String token){
        this.token = token;
    }
}
