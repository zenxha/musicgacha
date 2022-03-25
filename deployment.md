{% include navigation.html %}

<h1> AWS Deployment </h1>

<h2> Update, Upgrade, and install Maven </h2>

- create instance of Ubuntu 20.04
  - the newest Ubuntu version within the free tier
  - very similar to raspberry pi but on a cloud machine that allow access remotely, since they are both derivatives of Debian
  - no UI(User Interface), only displays terminal which allows it to be a lightweight OS(Operating System)
  
```
$ sudo apt-get update
```
- which pulls in applications installed such as "snapd" and "maven" 

```
$ sudo apt-get upgrade
```
- upgrade apt-get which finalizes updates and applies them to the machine

```
$ sudo apt-get install maven
```
  - main proponent to running java application
  - apache-maven run the "java -jar" file in order to deploy website
  
```
$ sudo apt-get install git
```
- use of git allows the pulling and pushing of project as well as committing changes and cloning the project for deployment


<h2> Clone project and test Java Web Application </h2>

```
$ sudo git clone https://github.com/zenxha/musicgacha.git
```
- clones project through the use of git
  - use "ls" in the terminal to check for if the "musicgacha" file exists on device
  - if "musicgacha" exists on your machine, continue to the next step

```
$ cd musicgacha
```
- change directories into the musicgacha project

```
$ sudo mvn package
```
- package the project using maven in order to create a jar file to run the java application

```
$ sudo java -jar /home/ubuntu/musicgacha/target/coders-0.0.1-SNAPSHOT.jar
```
- use jar file to run java application(project)

>- run "localhost:8080" in your browser of choice, IF ON YOU'RE ON YOUR DEPLOYMENT DEVICE

<h2> Setup Security Groups for HTTP and HTTPS </h2>

Inbound Rules
>- Type: HTTP
>- Port Range: 80
>- Source: 0.0.0.0/0

>- Type: HTTPS
>- Port Range: 443
>- Source: 0.0.0.0/0

Outbound Rules

>- Type: HTTP
>- Port Range: 80
>- Source: 0.0.0.0/0

>- Type: HTTPS
>- Port Range: 443
>- Source: 0.0.0.0/0

<h2> Setup NGINX </h2>

```
$ sudo apt-get install nginx
```
- if not installed, install nginx in order to reverse-proxy(using localhost, run project to domain directly without needing to change IP address manually)

```
$ sudo nano /etc/nginx/sites-available/musicgacha
```
- create an nginx file to reverse proxy project from "localhost"

```
server {
    listen 80;
    server_name musicgacha.cf;

    location / {
        proxy_pass http://localhost:8080;
    }
}
```

Test nginx file configuration
```
$ sudo ln -s /etc/nginx/sites-available/musicgacha /etc/nginx/sites-enabled
$ sudo nginx -t
```

If no errors occur when "sudo nginx -t" is checked, continue
```
$ sudo systemctl restart nginx
```

<h2> Setup Certbot(HTTPS) </h2>

```
sudo apt-get install snapd
```

```
sudo certbot --nginx
```

If the certificate expires after the 3 month certificate period, do
```
sudo certbot renew
```


<h2> Create Service File </h2>

"sudo nano" into new service file in /etc/systemd/system/musicgacha.service
```
[Unit]
Description=Java
After=network.target

[Service]
User=ubuntu
Restart=always
ExecStart=java -jar /home/ubuntu/p1-codecodecoders/target/csa-0.0.1-SNAPSHOT.jar

[Install]
WantedBy=multi-user.target 
```

Run and enable service file for the project
```
$ sudo systemctl start p1-codecodecoders
$ systemctl status p1-codecodecoders
```

If running the service file is successful, make the service file persistent on the machine(always running whenever the machine starts up and is on)
```
$ sudo systemctl enable p1-codecodecoders
```
