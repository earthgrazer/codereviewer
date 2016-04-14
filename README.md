What is **codereviewer**
====================
**codereviewer** is a simple web application that makes the linking of proprietary source code over the internet safe. A common scenario where **codereviewer** could be useful is copying and pasting source code on off-site communication services like Slack; someone might want to do this to show another developer some code changes. This requires trust that the off-site service does expire communication history, and whatever it keeps is kept in a way that is secure and confidential.

**codereviewer** allows developers to take advantage of third-party hosted communication services, while keeping the persistance and access of the shared source code under the developers' control.

How does **codereviewer** work
==========================
Pretty simple actually. **codereviewer** is a self-contained Spring Boot application that can be built and deployed on the embedded application server with a single command. When deployed, the web app is accessible to anyone who can reach the local machine through the deployed server port. So in this sense, **codereviewer** is as secure as the local machine and LAN firewall. 

Source code files are organized into *review units*. The developer creates a *review unit*, adds one or more source code files to it, then saves the unit. Saving the *review unit* produces a shareable URL containing a unique reference id, which can then be given to anyone with port access to the web app. In the current **codereviewer** version, *review units* are stored in the JVM process memory; all stored information is discarded when the web app is terminated.

How to use **codereviewer**
===========================
1. Clone the repository
2. Open a terminal
3. Change directory to the repository root
4. Run ./gradlew bootRun
5. In a web browser, navigate to http://{host}:8080/review, where {host} is a LAN IP address
6. Add source code to the review unit, then submit to save
7. Copy the resulting URL from the browser's address bar and share it
