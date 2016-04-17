#codereviewer
##What is it
**codereviewer** is a simple web application that makes the linking of in-house source code over the internet safe. Want to share code with your coworker, but company policy forbids uploading code to third-party services (e.g. Slack) as security precaution? Use **codereviewer** to serve up files behind the comfort of your enterprise firewall.

**codereviewer** allows developers to take advantage of third-party hosted communication services, while keeping the persistance and access of the shared source code under the developers' control.

The design philosophy is to *Keep It Simple*. There is no user login, database management, or configuration, because sharing code doesn't have to be complicated.

##How to use it
1. Clone the repository
2. Open a terminal
3. Change directory to the repository root
4. Run `./gradlew bootRun`
5. In a web browser, navigate to `http://{host}:8080/review`, where `{host}` is a LAN IP address
6. Add source code to the review unit, then submit to save
7. Copy the resulting URL from the browser's address bar and share it

##How does it work
**codereviewer** is a self-contained Spring Boot application that can be built and deployed on the embedded application server with a single command. When deployed, the web app is accessible to anyone who can reach the local machine through the deployed server port. So in this sense, **codereviewer** is as secure as the local machine and LAN firewall. 

Source code files are organized into *review units*. The developer creates a *review unit*, adds one or more source code files to it, then saves the unit. Saving the *review unit* produces a shareable URL containing a unique reference id, which can then be given to anyone with port access to the web app. In the current version, *review units* are stored in the JVM process memory; none of the stored information is retained by the application when the process is terminated.

##License
Apache License Version 2.0, January 2004.

See [LICENSE](https://github.com/earthgrazer/codereviewer/blob/master/LICENSE).
