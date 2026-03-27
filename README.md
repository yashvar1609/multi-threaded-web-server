# multi-threaded-web-server
## 📌 Description
This project implements a Java-based web server using three different approaches:
- Single-threaded server
- Multi-threaded server
- Thread pool-based server
  
The objective of this project is to understand how web servers handle client requests, and to explore the concepts of multithreading and thread pools in Java through practical implementation.

## ⚙️ Features
- Handles client-server communication using Java sockets
- Supports single-threaded request handling
- Implements multi-threading to handle multiple clients concurrently
- Uses thread pool for efficient thread management
- Demonstrates basic networking and concurrency concepts in Java

  ## 🛠️ Tech Stack
- Java (Core Java, Multithreading)
- Socket Programming
- Apache JMeter (for performance testing)
- IntelliJ IDEA (IDE)

## 📂 Project Structure
- SingleThreaded/
- MultiThreaded/
- MultiThreadedUsingThreadPool/

## ▶️ How to Run

### 1. Compile
- javac Server.java
- javac Client.java
  
### 2. Run Server
- java Server

### 3. Run Client
- java Client
#### Note : Run the server first, then run the client in a separate terminal.

## 📊 Performance Testing

Performance testing was conducted using Apache JMeter under two conditions:
- Without delay (high load)
- With delay (controlled load)

### 🔹 Observations
- Single-threaded server handles one request at a time, which can lead to increased response time and occasional timeouts under load
- Multi-threaded server processes multiple requests concurrently, improving response time
- Thread pool-based server provides better resource management and more stable performance under load

Some errors/timeouts were observed in the single-threaded implementation under higher load conditions.

## 📸 Performance Comparison
### 🔹 Single Threaded

#### Without Delay
![Aggregate Report](https://github.com/yashvar1609/multi-threaded-web-server/blob/main/screenshots/single-threaded/no-delay-aggregate.png)
*Aggregate Report – Single Threaded (Without Delay)*

![Graph](https://github.com/yashvar1609/multi-threaded-web-server/blob/main/screenshots/single-threaded/no-delay-graph.png)
*Response Time Graph – Single Threaded (Without Delay)*

#### With Delay
![Aggregate Report](https://github.com/yashvar1609/multi-threaded-web-server/blob/main/screenshots/single-threaded/delay-aggregate.png)
*Aggregate Report – Single Threaded (With Delay)*

![Graph](https://github.com/yashvar1609/multi-threaded-web-server/commit/eb5a5c1d3eef46589531821bac7bda38a99eb58e)
*Response Time Graph – Single Threaded (With Delay)*

📌 Observation:
The single-threaded server processes one request at a time. When delay is introduced, response time increases significantly and may lead to timeouts under load.
