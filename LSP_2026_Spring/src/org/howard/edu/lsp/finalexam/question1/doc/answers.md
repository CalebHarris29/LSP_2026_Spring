# Final Exam Question 1

## Part 1:

Shared Resource #1:  
`nextId`

Shared Resource #2:  
`requests`

Concurrency Problem:  
A race condition may occur if multiple threads call `addRequest()` at the same time. This can cause duplicate request IDs, skipped IDs, or unsafe changes to the shared `ArrayList`.

Why addRequest() is unsafe:  
`addRequest()` is unsafe because it performs multiple operations on shared data without synchronization. It calls `getNextId()` and then modifies the shared `requests` list, so two threads can interfere with each other while creating and adding requests.

## Part 2:

Fix A:  
`public synchronized int getNextId()` does not fully solve the problem. It protects the ID generation, so duplicate IDs are prevented, but `requests.add(request)` is still not synchronized. Since `ArrayList` is not thread-safe, multiple threads can still modify the list at the same time.

Fix B:  
`public synchronized void addRequest(String studentName)` correctly solves the concurrency problem. It locks the entire request creation and insertion process, so only one thread can generate an ID and add a request at a time.

Fix C:  
`public synchronized List<String> getRequests()` does not solve the problem. It only synchronizes access when returning the list, but it does not protect `nextId` or the `requests.add()` operation inside `addRequest()`.

## Part 3:

Answer + Explanation:  
No, `getNextId()` should not be public. Based on Arthur Riel’s heuristics, classes should hide internal implementation details and expose only necessary behavior. The request ID should be managed internally by `RequestManager`, not directly accessed or controlled by outside classes.

## Part 4:

Description:  
An alternative approach is to use an explicit lock, such as `ReentrantLock`, instead of the `synchronized` keyword. The lock is acquired before accessing shared resources and released afterward, ensuring only one thread can execute the critical section at a time.

Code Snippet:


```java

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

private final Lock lock = new ReentrantLock();

public void addRequest(String studentName) {
    lock.lock();
    try {
        int id = nextId++;
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    } finally {
        lock.unlock();
    }
}
```