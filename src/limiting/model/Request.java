package limiting.model;

public class Request {

    private String id;

    private String IP;

    public Request(String id, String IP) {
        this.id = id;
        this.IP = IP;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
}
