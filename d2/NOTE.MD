### Install GSON

```groovy
 // Install GSON
    implementation 'com.google.code.gson:gson:2.8.6'
```

### Create Message Bean

```java


public class Message {

    private String title;
    private String message;
    private Date dateTime;

    public Message() {
    }

    public Message(String title, String message, Date dateTime) {
        this.title = title;
        this.message = message;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}

```

### Convert message object into a message json

```java

public class ResourceAccessRest extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Message message = new Message("Test", "Message", new Date());
        Gson gson = new Gson();
        String json = gson.toJson(message);


        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(json);
    }

}

```

### Read request data

```java

  StringBuffer jb = new StringBuffer();
  String line = null;
  try {
      BufferedReader reader = req.getReader();
      while ((line = reader.readLine()) != null)
          jb.append(line);
  } catch (Exception e) {
      System.out.println(e);
  }
    
  String payloadString = jb.toString();   

```
### Convert json string to object

```java

   String payloadString = jb.toString();

   Gson gson = new Gson();
   Message msg = gson.fromJson(payloadString,Message.class);
   System.out.println(msg);


```