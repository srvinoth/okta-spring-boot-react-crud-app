# okta-spring-boot-react-crud-app

 This example app shows how to create a Spring Boot API and CRUD (create, read, update, and delete) its data with a React app.

**Prerequisites:** [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), [Node.js 8+](https://nodejs.org/), and [Yarn](https://yarnpkg.com/en/docs/install). You can use npm instead of Yarn, but you'll need to translate the Yarn syntax to npm.

> [Okta](https://developer.okta.com/) has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage, and secure users and roles in any application.

## Getting Started

To install this example application, run the following commands:

```bash
git clone https://github.com/srvinoth/okta-spring-boot-react-crud-app.git spring-react
cd spring-react
```

This will get a copy of the project installed locally. To install all of its dependencies and start each app, follow the instructions below.

To run the server, run:
 
```bash
./mvnw spring-boot:run
```

To run the client, cd into the `app` folder and run:
 
```bash
yarn && yarn start
```

### Create an Application in Okta

You will need to [create an OIDC Application in Okta]() to get your values to perform authentication. 

Log in to your Okta Developer account (or [sign up](https://developer.okta.com/signup/) if you don’t have an account) and navigate to **Applications** > **Add Application**. Click **Web**, click **Next**, and give the app a name you’ll remember. Specify `http://localhost:8080/login/oauth2/code/okta` as a Login redirect URI. Click **Done**, then click **Edit** to edit General Settings. Add `http://localhost:3000` and `http://localhost:8080` as Logout redirect URIs, then click **Save**. 

#### Server Configuration

Set the `issuer` and copy the `clientId` and `clientSecret` into `src/main/resources/application.yml`. 

**NOTE:** The value of `{yourOktaDomain}` should be something like `dev-229605.oktapreview.com`. Make sure you don't include `-admin` in the value!

```yaml
spring:
  profiles:
    active: @spring.profiles.active@
  security:
    oauth2:
      client:
        registration:
          okta:
            client-id: {clientId}
            client-secret: {clientSecret}
            scope: openid email profile
        provider:
          okta:
            issuer-uri: https://{yourOktaDomain}/oauth2/default
```

## Links

This example uses the following open source libraries:

* [React](https://reactjs.org/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Security](https://spring.io/projects/spring-security)
