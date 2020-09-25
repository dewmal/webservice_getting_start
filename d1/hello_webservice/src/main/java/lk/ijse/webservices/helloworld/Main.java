package lk.ijse.webservices.helloworld;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World Server Starting...");
        RestServer server = new RestServer();
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
