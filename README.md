# Simple-Key-Value-Store

A simple cache for storing key-value store like redis/memcache which are in memory data stores.
It can also be used as a micro service. Hosting part is still to be done.

Cache is used for quick data read and write as DB read and write operations are much slower in comparison. 

# Data Structures used:
1. HashMap 
2. Doubly Linked List

# Walk through algorithm:

1. GET(key) :
This needs to be done in O(1) hence, we would be needing a HashMap for storing the node's address corresponding to the key. Also, we will maintain of doubly linked list containing all the values. 
Whenever a GET(key) is done the node is removed and placed at the front of the list. The most recently used are placed at the front and least recently used at the back of the list.

2. GET(key, version) :
I have done this operation but it would take O(N) in worst case. Traversing the list until the correct version and the versioning order is automatically updated by GET(key)

3. SET(key, value) :
This operation will take again O(1) time. Create a node at the front of the list and add a entry to the HashMap. 



# Work needs to be done:
1. Adding support for data structures such as List, String, Set.
2. Changing code so that it can be used as a service (API).


# Get the sources:
git clone https://github.com/guptaabhinav206/Simple-Key-Value-Store.git

# Execution :
Import the project in any IDE.
Run Main.java class.

or

Create a package and compile all classes

   javac Main.java

   java Main

Also, I have added a JUNIT test case. 

