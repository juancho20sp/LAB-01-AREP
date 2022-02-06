# Let's convert some values!

This is a repository that includes all the code needed to successfully deploy a unit converter to heroku, built with Java (Spark) and basic web technologies (HTML, JavaScript, CSS).

## Architecture

---

This is a simple _Client-Server_ architecture using an **APIRest** approach. The **backend** is a Spark application that exposes two endpoints that the **frontend** consumes. The communication is based on the REST protocol using **JSON** as standard for sending and receiving messages.

The REST method used form communication is the **GET** method and the values required for doing the calculations are sent as _query params_ using the **value** key.

### API

---

**Base URL**

```url
https://lab-01-arep-back.herokuapp.com/
```

### ENDPOINTS

---

For converting **Celsius** degrees to Fahrenheit degrees, you must use this endpoint:

```url
/celsius
```

For converting **Fahrenheit** degrees to Celsius degrees, you must use this endpoint:

```url
/fahrenheit
```

### REQUESTS

---

All the requests are sent as **GET** requests to the backend. In order to send a value to convert you must use the **value** as a query param, like this:

```url
/celsius?value=32
```

### RESPONSES

---

If a request is **successfully** sent to the server, it will respond with a message like this:

```json
{
  "status": 200,
  "result": 50.0,
  "units": "Fahrenheit"
}
```

Where:

- **status:** The status of the request (see [HTTP status codes](https://developer.mozilla.org/es/docs/Web/HTTP/Status)).
- **result:** The result of the conversion.
- **units**: The units of the **result** field.

If a request is sent in a bad format to the server, it will respond with a message like this:

```json
{
  "status": 400,
  "message": "The value sent is not valid.",
  "value": "asdasd"
}
```

Where:

- **status:** The status of the request (see [HTTP status codes](https://developer.mozilla.org/es/docs/Web/HTTP/Status)).
- **message:** The server message for the user.
- **value:** The value sent by the user.

### LINKS

---

**Backend**

```url
https://lab-01-arep-back.herokuapp.com/
```

**Frontend**

```url
https://lab-01-arep-front.herokuapp.com/
```

## Run the project locally!

---

### Backend

Download or clone the project, go to the _Backend_ directory and run:

```url
mvn package
```

Then, go to **App.java** and run the **main()** method.

### Frontend

Download or clone the project, go to the _Frontend_ directory and open the **index.html** file.

---

### Let's run the tests!

For running the automated tests of the API, download or clone the project, go to the _Backend_ directory and run:

```url
mvn test
```

## Built With

- [Spark](https://sparkjava.com/) - As the Java framework for the backend.
- HTML and CSS - As the main technologies for developing the UI.
- [JavaScript](https://developer.mozilla.org/es/docs/Web/JavaScript) - As the language used in the client for creating experiences and handling user events.

## Author

- **Juan David Murillo** - [Github](https://github.com/juancho20sp) | [Twitter](https://twitter.com/juancho20sp)<br/>
  Student at: [Escuela Colombiana de Ingeniería Julio Garavito](https://www.escuelaing.edu.co/es/) <br/>
  2022

## License

This is an _open source_ project.

### Thanks for checking out!
