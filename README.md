# Twitchly

#### A full-stack Twitch resources recommendation App for users to search Twitch resources and get recommendations based on the user preferences.

### Tech Stack: Spring MVC, React.JS,  MySQL, Twitch APIs

## Demo Pictures:

Log-in

<img src="https://raw.githubusercontent.com/hesihui/Twitchly/main/demo_pic/login.png" />

System 

<img src="https://raw.githubusercontent.com/hesihui/Twitchly/main/demo_pic/system_look.png"/>

## Backend Configuration

#### To configure your mysql db: 

src/main/java/com/app/twitchly/ApplicationConfig.java

```java
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        String RDS_ENDPOINT = "<DATABASE ENDPOINTS for AWS >";
        String USERNAME = "root";
        String PASSWORD = "root";
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://" + RDS_ENDPOINT + ":3306/twitch?createDatabaseIfNotExist=true&serverTimezone=UTC");
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
```

#### To configure your Twitch API keys :

src/main/java/com/app/twitchly/service/GameService.java

```java
    private static final String TOKEN = "Bearer <yout token>";
    private static final String CLIENT_ID = "<client id>";
```

## Backend APIs:

Postman samples: https://www.getpostman.com/collections/aa36c4bb541e3a17c1e0

#### Add a favorite item: POST http://localhost:8080/favorite

```json
{
    "favorite": {
            "id": "366282939",
            "title": "WCS WINTER Europe qualifier II: Luolis vs Hellraiser",
            "url": "https://www.twitch.tv/videos/366282939",
            "thumbnail_url": "https://static-cdn.jtvnw.net/cf_vods/d2nvs31859zcd8/cf8f12b9daa4e2554818_divinesiatv_14772441901_5056332498//thumb/thumb366282939-480x480.jpg",
            "broadcaster_name": "divinesiatv",
            "game_id": "490422",
            "item_type": "VIDEO"
    }
}
```

#### Login: POST http://localhost:8080/login

```json
{
  "user_id": "1234",
  "password": "1234"
}
```

## Resources

Twitch API documentation: https://dev.twitch.tv/docs/api/