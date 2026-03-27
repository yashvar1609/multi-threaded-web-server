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

#### 📊 Single Threaded Performance Comparison

| Metric              | Without Delay        | With Delay              |
|--------------------|--------------------|------------------------|
| Request Handling   | Sequential          | Sequential             |
| Response Time      | Lower               | Significantly Higher   |
| Throughput         | Better              | Reduced                |
| Errors/Timeouts    | Minimal             | May Occur              |
| Overall Performance| Acceptable          | Poor under load        |

### 🔹 Multi Threaded (Without Thread Pool)

#### Without Delay
![Aggregate Report](https://github.com/yashvar1609/multi-threaded-web-server/blob/main/screenshots/multi-threaded/report-multi-threaded.png)
*Aggregate Report – Multi Threaded (Without Thread Pool)*

![Graph](https://github.com/yashvar1609/multi-threaded-web-server/blob/main/screenshots/multi-threaded/graph-multi-threaded.png)
*Response Time Graph – Multi Threaded (Without Thread Pool)*

📌 Observation:
The multi-threaded server handles multiple client requests concurrently, significantly improving response time and throughput compared to the single-threaded implementation.

### 🔹 Thread Pool Based Server

#### Without Delay
![Aggregate Report](https://github.com/yashvar1609/multi-threaded-web-server/blob/main/screenshots/multi-threaded-with-thread-pool/report-thread-pool.png)
*Aggregate Report – Thread Pool Based Server*

![Graph](https://github.com/yashvar1609/multi-threaded-web-server/blob/main/screenshots/multi-threaded-with-thread-pool/graphj-thread-pool.png)
*Response Time Graph – Thread Pool Based Server*

📌 Observation:
The thread pool-based server efficiently manages a fixed number of threads, reducing overhead from frequent thread creation. This results in stable performance and better resource utilization under concurrent requests.
#### 📊 Multi-Threaded vs Thread Pool (Simple Explanation)

| Metric            | Multi-Threaded Server                | Thread Pool Server                     |
|------------------|------------------------------------|----------------------------------------|
| Working Style    | Creates a new thread for each request | Reuses a fixed number of threads       |
| Average Time     | ~3259 ms (slower)                  | ~1003 ms (faster)                      |
| Median Time      | ~3014 ms                           | ~1003 ms                               |
| Throughput       | ~573 requests/min                  | ~1007 requests/min                     |
| Stability        | Less stable (high variation)       | Very stable (low variation)            |
| Deviation        | High (1439 → inconsistent)         | Very low (1 → consistent)              |
| Resource Usage   | High (many threads created)        | Optimized (threads reused)             |
| Performance      | Good                               | Excellent                              |

📌 Explanation:
- In a multi-threaded server, a new thread is created for every incoming request, which increases overhead and reduces performance under heavy load.
- In contrast, a thread pool reuses a fixed number of threads, reducing the cost of thread creation and improving performance, stability, and efficiency.
 - This is why the thread pool server shows lower response time, higher throughput, and more consistent behavior.

#### 📊 Overall Performance Comparison

| Metric            | Single Threaded        | Multi Threaded         | Thread Pool            |
|------------------|-----------------------|------------------------|------------------------|
| Request Handling | One at a time         | Multiple (concurrent)  | Multiple (controlled)  |
| Response Time    | High                  | Moderate               | Low                    |
| Throughput       | Low                   | High                   | Very High              |
| Stability        | Low (with delay)      | Moderate               | High                   |
| Resource Usage   | Low                   | High                   | Optimized              |
| Scalability      | Poor                  | Good                   | Very Good              |
| Performance      | Weak                  | Good                   | Best                   |

📌 Summary:
The single-threaded server is simple but inefficient under load.  
The multi-threaded server improves performance by handling multiple requests concurrently.  
The thread pool-based server further optimizes performance by managing threads efficiently, resulting in better stability and scalability.

## 📚 Key Learnings

- Understood how client-server communication works using Java sockets  
- Learned the difference between single-threaded and multi-threaded request handling  
- Gained practical knowledge of thread creation and concurrency in Java  
- Explored how thread pools improve performance by reusing threads  
- Learned to perform performance testing using Apache JMeter  
- Analyzed how response time, throughput, and delay affect server performance  
## 🎯 Conclusion

This project demonstrates how different server architectures impact performance and efficiency in handling client requests.

The single-threaded server is simple but becomes inefficient under load as it processes one request at a time. The multi-threaded server improves performance by handling multiple requests concurrently, but introduces overhead due to frequent thread creation.

The thread pool-based server provides the most efficient solution by reusing a fixed number of threads, reducing overhead and ensuring better performance, stability, and scalability under high load conditions.

Overall, the project highlights the importance of efficient thread management in building scalable and high-performance server applications.
